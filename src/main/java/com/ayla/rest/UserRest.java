package com.ayla.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ayla.common.model.Application;
import com.ayla.common.model.LoginResponse;
import com.ayla.common.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/userRest")
public class UserRest  {


	public static  String loginurl = "https://user-gmdrp.aylanetworks.com/users/sign_in.json";
	String profileurl = "https://user-gmdrp.aylanetworks.com/users/get_user_data.json";
	
	public static final String app_secret = "app_secret-8P_U_GtdZIOpC_Ayybicfumzc-4";
	public static final String app_id =  "app_772687_0-id";
	public static String admin_access_token = "";

	public static final ObjectMapper MAPPER = new ObjectMapper();
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginResponse login(@RequestBody User user) throws JsonProcessingException{
		RestTemplate restTemplate = new RestTemplate();
		
		Application application = new Application();
		application.setApp_id(app_id);
		application.setApp_secret(app_secret);
		Map map = new HashMap<>();
		map.put("user", user);
		user.setApplication(application);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(map);
		System.out.println(jsonInString);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonInString, headers);
		
		
		ResponseEntity<LoginResponse> response
		  = restTemplate.exchange(loginurl,  HttpMethod.POST, entity, LoginResponse.class);
		return  response.getBody();
		
	
	}

	
	@RequestMapping(value = "/implicitLogin", method = RequestMethod.POST)
	public LoginResponse implicitLogin(@RequestBody User user) throws JsonProcessingException {

		User userObj = new User();
		String userId = "oemadmin@areoem-772687.com";
		String password = "Testing4ARE";

		user = userObj;
		user.setEmail(userId);
		user.setPassword(password);

		RestTemplate restTemplate = new RestTemplate();

		Application application = new Application();
		application.setApp_id(app_id);
		application.setApp_secret(app_secret);
		Map map = new HashMap<>();
		map.put("user", user);
		user.setApplication(application);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(map);
		System.out.println(jsonInString);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonInString, headers);

		ResponseEntity<LoginResponse> response = restTemplate.exchange(loginurl, HttpMethod.POST, entity,
				LoginResponse.class);
		return response.getBody();

	}

	
	@RequestMapping(value = "/getUserById", method = RequestMethod.POST)
	public User getUserById(@RequestHeader("Authorization") String authheader) throws JsonProcessingException{
		String access_token =  authheader.substring(authheader.indexOf(" ")+1);
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		headers.add("Authorization", "auth_token " + access_token);

		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		
				
		ResponseEntity<User> response
		  = restTemplate.exchange(profileurl,  HttpMethod.GET, entity, User.class);
		
		
		if(response.getStatusCode() == HttpStatus.OK ){
			if(response.getBody().getRole().getName().startsWith("OEM::Admin")){
				admin_access_token = access_token;
			}
			return  response.getBody();
		}else{
			return null;
		}

	}
	


	
}
