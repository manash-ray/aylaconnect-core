package com.ayla.rest;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



import com.ayla.common.model.Action;
import com.ayla.common.model.Customer;
import com.ayla.common.model.Device;
import com.ayla.common.model.DeviceAlert;
import com.ayla.common.model.DiagnosticActions;
import com.ayla.common.model.DiagnosticHistory;
import com.ayla.common.model.DiagnosticState;
import com.ayla.common.model.DiagnosticStates;
import com.ayla.common.model.Event;
import com.ayla.common.model.LoginResponse;
import com.ayla.common.model.Permission;
import com.ayla.common.model.Rule;
import com.ayla.common.model.Ticket;
import com.ayla.common.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
@RequestMapping("/alertsRest")
public class AlertsRest {

	String profileurl = "https://user-gmdrp.aylanetworks.com/users/get_user_data.json";
	
	public static String getrulesforoem = "https://rulesservice-gmdrp.aylanetworks.com/rulesservice/v1/oems/:oem/rules.json?abstract_only=true&paginated=true&per_page=20&page=1&order_by=asc";
    
	//public static String getdsnsforrule = "https://rulesservice-gmdrp.aylanetworks.com/rulesservice/v1/diagnostic_states2?rule_uuid=:id&current_only=true";
	
	public static String getdsnsforrule = "https://rulesservice-gmdrp.aylanetworks.com/rulesservice/v1/rules/:id/diagnostic_states";	
	
	public static String createrule = "https://rulesservice-gmdrp.aylanetworks.com/rulesservice/v1/rules";
	
	public static String createaction = "https://rulesservice-gmdrp.aylanetworks.com/rulesservice/v1/actions";
	
	public static String devicedet = "https://ads-gmdrp.aylanetworks.com/apiv1/dsns/:dsn.json";
	
	public static String alerthistory =  "https://rulesservice-gmdrp.aylanetworks.com/rulesservice/v1/diagnostic_states2?dsn=:dsn";
	
	public static String propval = "https://ads-gmdrp.aylanetworks.com/apiv1/dsns/:dsn/properties/signal_strength.json";
	
	public static String getaction = "https://rulesservice-gmdrp.aylanetworks.com/rulesservice/v1/actions/:id.json";
	
	public static String datapoint = "https://ads-gmdrp.aylanetworks.com/apiv1/properties/1020233/datapoints.json?env=gumdrop&%5Bfilter%5D%5Border%5D=asc&%5Bfilter%5D%5Border_by%5D=datapoint.created_at&is_forward_page=true&limit=10&page=1&paginated=true&per_page=10";

	//TESTDSN_ARE772687_5628
	
	/*
	 * 
	oem::Admin - goit_admin@example.com  or oemadmin@areoem-772687.com
	oem password - Testing4ARE
	Oem app id - app_772687_0-id  Oem app secret - app_secret-8P_U_GtdZIOpC_Ayybicfumzc-4
	Role user#1 - acme_retail@example.com password - Testing4ARE
	Role user#2 - acme_telecom@example.com password - Testing4ARE

	 */

	
	
	
	
	@RequestMapping(value = "/getAssignedAlerts/{firstResult}/{maxResult}", method = RequestMethod.POST)
	 public @ResponseBody Map<String, List<DeviceAlert>> getAssignedAlerts(@RequestHeader("Authorization") String authheader,@PathVariable("firstResult") int firstResult, @PathVariable("maxResult") int maxResult){
				
		String access_token =  authheader.substring(authheader.indexOf(" ")+1);
		DiagnosticActions d = getRules(access_token);
		Map<String, List<DeviceAlert>> ruleAlerts = new LinkedHashMap();
		DiagnosticActions dact = getRules(access_token);
		int custId = 5672;
		for(Rule r : d.getRules()){
			List<DeviceAlert> alertss = new ArrayList<>();
			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper mapper = new ObjectMapper();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			headers.add("Authorization", "auth_token " + access_token);
			System.out.println("access_token="+access_token);
			HttpEntity<String> entity = new HttpEntity<String>("", headers);
			
			String getdsnsforruler = getdsnsforrule.replace(":id", r.getRule_uuid());
			ResponseEntity<DiagnosticStates> response
			  = restTemplate.exchange(getdsnsforruler,  HttpMethod.GET, entity, DiagnosticStates.class);
			System.out.println("getdsnsforruler="+getdsnsforruler);
			DiagnosticStates s = response.getBody();
			
			for(DiagnosticState ds : s.getDiagnostic_states()){
				
				DeviceAlert p = new DeviceAlert();
				
				p.setRuleName(ds.getRule_name());
				p.setRule_uuid(ds.getRule_uuid());
				p.setDeviceId(ds.getDsn());
				p.setModel(ds.getOem_model());
				
				p.setAlertDate(ds.getCreated_at());
				try {
					Date alertDatef = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")).parse(p.getAlertDate().replaceAll("Z$", "+0000"));
					p.setAlertDatef(alertDatef);
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
		
				
				Customer customer = new Customer();
				customer.setAddress("32263 Lake Mead Dr, Belmont, California 93464");
				customer.setEmail("ctran@myspace.com");
				customer.setIspName("Service provider Inc");
				customer.setIspStatus("Stable");
				customer.setPhone("650-233-5678");
				customer.setName("Creg Tran");
				customer.setServiceType("Residential");
				customer.setLatitude(37.5095553);
				customer.setLongitude(-122.30948710000001);
				custId = custId + 25;
				customer.setId(new Long(custId));
				
				p.setCustomer(customer);
				/*List<Double> datalist = getDataPoint();
				if(datalist.size() > 1){
					double signal = datalist.get(1).doubleValue();
					
					if(signal < 6 && signal > 3){						
						p.setStatus("Y");						
					}else if(signal <= 3){
						
						p.setStatus("R");
					}else{
						
						p.setStatus("G");
					}
					
				}*/
				
				if(ds.getName().equalsIgnoreCase("red")){						
					p.setStatus("R");						
				}else if(ds.getName().equalsIgnoreCase("yellow")){
					
					p.setStatus("Y");
				}else{
					
					p.setStatus("G");
				}
				

				alertss.add(p);
			}
		   
			ruleAlerts.put(r.getName(), alertss);
		}
				
		return ruleAlerts;
		
		
	}


	@RequestMapping(value = "/loadVi", method = RequestMethod.POST)
	 public @ResponseBody DeviceAlert loadVi(@RequestHeader("Authorization") String authheader,  @RequestBody DeviceAlert p){
		List<Double> datalist = getDataPoint();
		Date dt = new Date() ;
		Date dateBefore = new Date(dt.getTime() - 10 * 24 * 3600 * 1000  );
		Map<String, String> m = new LinkedHashMap();
		m.put("Power On", "1");
		m.put("Grill Temp", "300");
		
		if(datalist.size() > 1){
			double signal = datalist.get(1).doubleValue();
			m.put("WiFi Signal Strength", datalist.get(1).doubleValue()+"");
			if(signal < 6 && signal > 3){
				
				p.setStatus("Y");
			}else if(signal <= 3){
				
				p.setStatus("R");
			}else{
				
				p.setStatus("G");
			}
		}
		m.put("ruleattrib", "WiFi Signal Strength");
		m.put("Probe Temp", "125");
		m.put("Smoke On", "0");
		m.put("Stand By Mode", "0");
		m.put("Pre Heat Mode", "0");
		m.put("Gas Level", "0");

		p.setAlertData(m);
		
		Ticket ticket = new Ticket();
		ticket.setDate(dateBefore);
		ticket.setIssue("Connectivity Failure");
		ticket.setStatus("Open");
		
		Ticket ticket1 = new Ticket();
		ticket1.setDate(new Date(dt.getTime() - 30 * 24 * 3600 * 1000  ));
		ticket1.setIssue("Connectivity Failure");
		ticket1.setStatus("Closed");	
		
		Ticket ticket2 = new Ticket();
		ticket2.setDate(new Date(dt.getTime() - 40 * 24 * 3600 * 1000  ));
		ticket2.setIssue("Connectivity Failure");
		ticket2.setStatus("Closed");
		List<Ticket> pastTickets = new ArrayList<>();
		pastTickets.add(ticket);
		pastTickets.add(ticket1);
		pastTickets.add(ticket2);
		p.setPastTickets(pastTickets);
		
		Event e = new Event();
		e.setDate(new Date(dt.getTime() - 50 * 24 * 3600 * 1000  ));
		e.setLocation("office");
		
		Event e1 = new Event();
		e1.setDate(new Date(dt.getTime() - 60 * 24 * 3600 * 1000  ));
		e1.setLocation("office");
		
		List<Event> recevtEvents = new ArrayList();
		recevtEvents.add(e);
		recevtEvents.add(e1);
		
		p.setRecevtEvents(recevtEvents);
			
		
		DiagnosticHistory dh = getAlertHistory(UserRest.admin_access_token, p.getRule_uuid(), p.getDeviceId());
		
		List<DeviceAlert> recetAlerts = new ArrayList<>();
		if(dh.getDiagnostic_states_history() != null){
			for(DiagnosticState st : dh.getDiagnostic_states_history()){
				DeviceAlert da = new DeviceAlert();
				if(st.getDiagnostic_name().startsWith("RED") || st.getDiagnostic_name().startsWith("red")){
					da.setStatus("R");
				}else if(st.getDiagnostic_name().startsWith("YELLOW") || st.getDiagnostic_name().startsWith("yellow")){
					da.setStatus("Y");
				}else{
					da.setStatus("G");
				}
				
				da.setAlertDate(st.getCreated_at());
				
				try {
					Date alertDatef = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")).parse(p.getAlertDate().replaceAll("Z$", "+0000"));
					da.setAlertDatef(alertDatef);
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Rule rule = new Rule();
				rule.setName(st.getRule_name());
				da.setRule(rule);
				recetAlerts.add(da);
				
			}
		}
		
		p.setRecetAlerts(recetAlerts);
		
		return p;
	}
	
	
	@RequestMapping(value = "/getSetAlerts", method = RequestMethod.POST)
	 public @ResponseBody List<Rule> getSetAlerts(@RequestHeader("Authorization") String authheader){
		
		String access_token =  authheader.substring(authheader.indexOf(" ")+1);
		DiagnosticActions da  = getRules(access_token);
		List<Rule> rules = new ArrayList();
		for(Rule r :da.getRules()){
			String actionId = r.getAction_ids().get(0);
			Action ac = getAction(access_token, actionId);
			if(ac.getParameters().get("diagnostc_state_name").equalsIgnoreCase("red")){
				r.setType("Error");
			}else if(ac.getParameters().get("diagnostc_state_name").equalsIgnoreCase("yellow")){
				r.setType("Warning");
			}else{
				r.setType("Replenishment");
			}
			String exp =r.getExpression();
			
			
			int beg = exp.indexOf("=")+1;
			int end = exp.indexOf("}", beg);
			String model = exp.substring(beg, end);
			beg =  exp.indexOf(",")+1;
			end = exp.indexOf(")", beg);
			String forat =exp.substring(beg, end);
			beg = end +1;
			
			String forval = exp.substring(beg);
			
			r.setModel(model);
			r.setRuledesc(forat + " "+forval);
			rules.add(r);
		}
		return rules;
	}


	@RequestMapping(value = "/loadSpAlerts", method = RequestMethod.POST)
	public @ResponseBody DeviceAlert loadSpAlerts(@RequestHeader("Authorization") String authheader,
			@RequestBody DeviceAlert p) {
		List<Double> datalist = getDataPoint();
		Date dt = new Date();
		int custId = 5270;
		Date dateBefore = new Date(dt.getTime() - 10 * 24 * 3600 * 1000);
		Map<String, String> m = new LinkedHashMap();

		p.setRuleName("Low WiFi Signal Strength");
		p.setRule_uuid("dcf76fd0-33b9-11e8-b27d-5fa9a451b447");
		p.setDeviceId("TESTDSN_ARE030744_3532");
		p.setModel("oemModel123");
		p.setAlertDate("2018-03-29T15:09:47.372Z");

		try {
			Date alertDatef = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"))
					.parse(p.getAlertDate().replaceAll("Z$", "+0000"));
			p.setAlertDatef(alertDatef);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		m.put("Power On", "1");
		m.put("Grill Temp", "300");

		if (datalist.size() > 1) {
			double signal = datalist.get(1).doubleValue();
			m.put("WiFi Signal Strength", datalist.get(1).doubleValue() + "");
			if (signal < 6 && signal > 3) {

				p.setStatus("Y");
			} else if (signal <= 3) {

				p.setStatus("R");
			} else {

				p.setStatus("G");
			}
		}
		m.put("ruleattrib", "WiFi Signal Strength");
		m.put("Probe Temp", "125");
		m.put("Smoke On", "0");
		m.put("Stand By Mode", "0");
		m.put("Pre Heat Mode", "0");
		m.put("Gas Level", "0");

		p.setAlertData(m);

		Ticket ticket = new Ticket();
		ticket.setDate(dateBefore);
		ticket.setIssue("Connectivity Failure");
		ticket.setStatus("Open");

		Ticket ticket1 = new Ticket();
		ticket1.setDate(new Date(dt.getTime() - 30 * 24 * 3600 * 1000));
		ticket1.setIssue("Connectivity Failure");
		ticket1.setStatus("Closed");

		Ticket ticket2 = new Ticket();
		ticket2.setDate(new Date(dt.getTime() - 40 * 24 * 3600 * 1000));
		ticket2.setIssue("Connectivity Failure");
		ticket2.setStatus("Closed");
		List<Ticket> pastTickets = new ArrayList<>();
		pastTickets.add(ticket);
		pastTickets.add(ticket1);
		pastTickets.add(ticket2);
		p.setPastTickets(pastTickets);

		Customer customer = new Customer();
		customer.setAddress("32263 Lake Mead Dr, Belmont, California 93464");
		customer.setEmail("ctran@myspace.com");
		customer.setIspName("Service provider Inc");
		customer.setIspStatus("Stable");
		customer.setPhone("650-233-5678");
		customer.setName("Creg Tran");
		customer.setServiceType("Residential");
		customer.setLatitude(37.5095553);
		customer.setLongitude(-122.30948710000001);
		custId = custId + 25;
		customer.setId(new Long(custId));

		p.setCustomer(customer);

		Event e = new Event();
		e.setDate(new Date(dt.getTime() - 50 * 24 * 3600 * 1000));
		e.setLocation("office");

		Event e1 = new Event();
		e1.setDate(new Date(dt.getTime() - 60 * 24 * 3600 * 1000));
		e1.setLocation("office");

		List<Event> recevtEvents = new ArrayList();
		recevtEvents.add(e);
		recevtEvents.add(e1);

		p.setRecevtEvents(recevtEvents);

		DiagnosticHistory dh = getAlertHistory(UserRest.admin_access_token, p.getRule_uuid(), p.getDeviceId());

		List<DeviceAlert> recetAlerts = new ArrayList<>();
		if (dh.getDiagnostic_states_history() != null) {
			for (DiagnosticState st : dh.getDiagnostic_states_history()) {
				DeviceAlert da = new DeviceAlert();
				if (st.getDiagnostic_name().startsWith("RED") || st.getDiagnostic_name().startsWith("red")) {
					da.setStatus("R");
				} else if (st.getDiagnostic_name().startsWith("YELLOW")
						|| st.getDiagnostic_name().startsWith("yellow")) {
					da.setStatus("Y");
				} else {
					da.setStatus("G");
				}

				da.setAlertDate(st.getCreated_at());

				try {
					Date alertDatef = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"))
							.parse(p.getAlertDate().replaceAll("Z$", "+0000"));
					da.setAlertDatef(alertDatef);
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Rule rule = new Rule();
				rule.setName(st.getRule_name());
				da.setRule(rule);
				recetAlerts.add(da);

			}
		}

		p.setRecetAlerts(recetAlerts);

		return p;
	}
	
	
	@RequestMapping(value = "/addAlert", method = RequestMethod.POST)
	 public @ResponseBody DiagnosticActions addAlert(@RequestHeader("Authorization") String authheader, @RequestBody Rule t) throws JsonProcessingException{
		
		Action a = new Action();
		a.setName("action"+t.getName());
		a.setType("DIAGNOSTIC");
		Map<String, String> map = new HashMap<String, String>();
				
	    map.put("diagnostc_state_name", t.getState());
	  
		a.setParameters(map);
		
		List<Permission> list = new ArrayList<>();
		for(String role : t.getRoles()){
			Permission p = new Permission();
			p.setRole(role);
			p.setType("READ");
			list.add(p);
		
		}
			
		a.setPermissions(list);
		
		Map<String, Action> ma = new HashMap();
		ma.put("action", a);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(ma);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String access_token =  authheader.substring(authheader.indexOf(" ")+1);
		headers.add("Authorization", "auth_token " + access_token);

		HttpEntity<String> entity = new HttpEntity<String>(jsonInString, headers);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> response
		  = restTemplate.exchange(createaction,  HttpMethod.POST, entity, String.class);
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(response.getBody()).getAsJsonObject().get("action").getAsJsonObject();
		
		String action_uuid = obj.get("action_uuid").getAsString();
				
		Rule r = new Rule();
		r.setIs_enabled(t.getIs_enabled());
		r.setIs_abstract(true);
		r.setName(t.getName());
		r.setDescription(t.getName());
		String expression ="DP(${oem_model="+t.getModel()+"},"+t.getForAttrib()+")"+ t.getForval();
		r.setExpression(expression);
		List<String> action_ids = new ArrayList();
		action_ids.add(action_uuid);
		r.setAction_ids(action_ids);
		Map<String, Rule> m = new HashMap();
		m.put("rule", r);
		String jsonInStringr = mapper.writeValueAsString(m);
		HttpHeaders headersr = new HttpHeaders();
		headersr.setContentType(MediaType.APPLICATION_JSON);
		headersr.add("Authorization", "auth_token " + access_token);

		HttpEntity<String> entityr = new HttpEntity<String>(jsonInStringr, headersr);
		RestTemplate restTemplater = new RestTemplate();
		
		ResponseEntity<Rule> responser
		  = restTemplater.exchange(createrule,  HttpMethod.POST, entityr, Rule.class);
		
		return getRules(access_token);
		
	}

	
	private List<Double> getDataPoint(){
		List<Double> list = new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		headers.add("Authorization", "auth_token " + UserRest.admin_access_token);

		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		
				
		ResponseEntity<String> response
		  = restTemplate.exchange(datapoint,  HttpMethod.GET, entity, String.class);
		JsonParser parser = new JsonParser();
		JsonArray array = parser.parse(response.getBody()).getAsJsonObject().getAsJsonArray("datapoints");
		if(array != null && array.size() > 0){
			list.add(array.get(0).getAsJsonObject().get("datapoint").getAsJsonObject().get("value").getAsDouble());
		}
		if(array != null && array.size() > 1){
			list.add(array.get(1).getAsJsonObject().get("datapoint").getAsJsonObject().get("value").getAsDouble());
		}		
		
		return list;
		
	}
	
	
	private User getUser(String access_token){
		
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		headers.add("Authorization", "auth_token " + access_token);

		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		
				
		ResponseEntity<User> response
		  = restTemplate.exchange(profileurl,  HttpMethod.GET, entity, User.class);
		return response.getBody();
		
	}
	
	
	private Device getDevice(String access_token, String dsn){
		Device dev = new Device();
		try{
		/*	RestTemplate restTemplate = new RestTemplate();
			ObjectMapper mapper = new ObjectMapper();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			headers.add("Authorization", "auth_token " + access_token);
	
			HttpEntity<String> entity = new HttpEntity<String>("", headers);
			
			String devicedetr = devicedet.replace(":dsn", dsn);
			System.out.println(devicedetr);
			ResponseEntity<String> response
			  = restTemplate.exchange(devicedetr,  HttpMethod.GET, entity, String.class);
			JsonParser parser = new JsonParser();
			
			JsonObject obj = parser.parse(response.getBody()).getAsJsonObject().get("device").getAsJsonObject();
			if(obj != null ){
				String model = obj.get("model").getAsString();
				int id = obj.get("id").getAsInt();
				dev.setModel(model);
				dev.setId(id);
			} */
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return dev;
	}
	
	private Action getAction(String access_token, String actionId){
		Action t = new Action();
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		headers.add("Authorization", "auth_token " + access_token);

		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		
		String getactionr = getaction.replace(":id", actionId);
		ResponseEntity<String> response
		  = restTemplate.exchange(getactionr,  HttpMethod.GET, entity, String.class);
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(response.getBody()).getAsJsonObject().get("action").getAsJsonObject();
		if(obj != null ){
			String name = obj.get("name").getAsString();
			String type = obj.get("type").getAsString();
			String diagAction = obj.get("parameters").getAsJsonObject().get("diagnostc_state_name").getAsString();
			t.setName(name);
			t.setType(type);
			Map<String, String> map = new HashMap<>();
			map.put("diagnostc_state_name", diagAction);
			t.setParameters(map);
		}
		return t;
		
	}
	
	
	private DiagnosticActions getRules(String access_token){
		User user = getUser(access_token);
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		headers.add("Authorization", "auth_token " + access_token);

		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		
		String getrulesforoemr = getrulesforoem.replace(":oem", user.getOem().getOem_id());
		ResponseEntity<DiagnosticActions> response
		  = restTemplate.exchange(getrulesforoemr,  HttpMethod.GET, entity, DiagnosticActions.class);
		return response.getBody();
		
	}
	
	private DiagnosticHistory getAlertHistory(String access_token, String ruleId, String dsn){
	
		try{
			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper mapper = new ObjectMapper();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			headers.add("Authorization", "auth_token " + access_token);
	
			HttpEntity<String> entity = new HttpEntity<String>("", headers);
			String alerthistoryr = alerthistory.replace(":dsn", dsn);
			ResponseEntity<DiagnosticHistory> response
			  = restTemplate.exchange(alerthistoryr,  HttpMethod.GET, entity, DiagnosticHistory.class);
			return response.getBody();
		}catch(Exception e){
			return new DiagnosticHistory();
		}
		
	}
	
	
	private Rule getRuleById(DiagnosticActions da, String id){
		
		for(Rule r :da.getRules()){
			if(r.getRule_uuid().equals(id)){
				return r;
			}
		}
		return null;
	}
	
	
}
