package com.ayla.common.model;

import java.util.Date;
import java.util.List;
import java.util.Map;



public class DeviceAlert {
	
	private Long id;
	
	private String status;
	
	private String alertDate;
	
	private String model;
	
	private String ruleName;
	
	private String deviceId;
	
	private Map<String, String> lastRecvdData;
	
	private Map<String, String> alertData;
	
	private Rule rule;
	
	private List<DeviceAlert> recetAlerts;
	
	private List<Event> recevtEvents;
	
	private List<Ticket> pastTickets;
	
	private List<String> warnings;
	
	private Customer customer;
	
	private boolean edit ;
	
	private Date alertDatef;
	
	private String rule_uuid;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	
	public String getAlertDate() {
		return alertDate;
	}

	public void setAlertDate(String alertDate) {
		this.alertDate = alertDate;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Map<String, String> getLastRecvdData() {
		return lastRecvdData;
	}

	public void setLastRecvdData(Map<String, String> lastRecvdData) {
		this.lastRecvdData = lastRecvdData;
	}

	public Map<String, String> getAlertData() {
		return alertData;
	}

	public void setAlertData(Map<String, String> alertData) {
		this.alertData = alertData;
	}


	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public List<DeviceAlert> getRecetAlerts() {
		return recetAlerts;
	}

	public void setRecetAlerts(List<DeviceAlert> recetAlerts) {
		this.recetAlerts = recetAlerts;
	}

	public List<Event> getRecevtEvents() {
		return recevtEvents;
	}

	public void setRecevtEvents(List<Event> recevtEvents) {
		this.recevtEvents = recevtEvents;
	}

	public List<Ticket> getPastTickets() {
		return pastTickets;
	}

	public void setPastTickets(List<Ticket> pastTickets) {
		this.pastTickets = pastTickets;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<String> getWarnings() {
		return warnings;
	}

	public void setWarnings(List<String> warnings) {
		this.warnings = warnings;
	}

	public boolean getEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public Date getAlertDatef() {
		return alertDatef;
	}

	public void setAlertDatef(Date alertDatef) {
		this.alertDatef = alertDatef;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getRule_uuid() {
		return rule_uuid;
	}

	public void setRule_uuid(String rule_uuid) {
		this.rule_uuid = rule_uuid;
	}
	

	
	
}
