package com.ayla.common.model;

import java.util.List;
import java.util.Map;

public class Action {
	
	String name;
	String type;
	Map<String, String> parameters;
	List<Permission> permissions;
	String action_uuid;
	String user_uuid;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Map<String, String> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	public String getAction_uuid() {
		return action_uuid;
	}
	public void setAction_uuid(String action_uuid) {
		this.action_uuid = action_uuid;
	}
	public String getUser_uuid() {
		return user_uuid;
	}
	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}
	
	

}
