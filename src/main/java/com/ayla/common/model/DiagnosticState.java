package com.ayla.common.model;

public class DiagnosticState {

	String uuid;
	String dsn;
	String oem;
	String rule_name;
	String oem_model;
	String name;
	
	String user_uuid;
	String rule_uuid;
	String diagnostic_name;
	String created_at;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getDsn() {
		return dsn;
	}
	public void setDsn(String dsn) {
		this.dsn = dsn;
	}

	public String getUser_uuid() {
		return user_uuid;
	}
	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}
	public String getRule_uuid() {
		return rule_uuid;
	}
	public void setRule_uuid(String rule_uuid) {
		this.rule_uuid = rule_uuid;
	}
	public String getDiagnostic_name() {
		return diagnostic_name;
	}
	public void setDiagnostic_name(String diagnostic_name) {
		this.diagnostic_name = diagnostic_name;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getRule_name() {
		return rule_name;
	}
	public void setRule_name(String rule_name) {
		this.rule_name = rule_name;
	}
	public String getOem_model() {
		return oem_model;
	}
	public void setOem_model(String oem_model) {
		this.oem_model = oem_model;
	}
	public String getOem() {
		return oem;
	}
	public void setOem(String oem) {
		this.oem = oem;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

		
}
