package com.ayla.common.model;

import java.util.List;

public class Rule {

	String name;
	String description;
	String expression;
	List<String> action_ids;
	String rule_uuid;
	boolean is_enabled;
	boolean is_abstract;
	String user_uuid;
	String created_at;
	String updated_at;
	String created_by;
	String updated_by;
	String model;
	String ruledesc;
	String uuid;
	List<String> roles;
	
	String state;
	
	private String forule;
	
	private String forAttrib;
	
	private String forval;
	
	private String type;
	
	private String knowledgeUrl;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public List<String> getAction_ids() {
		return action_ids;
	}
	public void setAction_ids(List<String> action_ids) {
		this.action_ids = action_ids;
	}

	public String getRule_uuid() {
		return rule_uuid;
	}
	public void setRule_uuid(String rule_uuid) {
		this.rule_uuid = rule_uuid;
	}
	public boolean getIs_enabled() {
		return is_enabled;
	}
	public void setIs_enabled(boolean is_enabled) {
		this.is_enabled = is_enabled;
	}
	public boolean getIs_abstract() {
		return is_abstract;
	}
	public void setIs_abstract(boolean is_abstract) {
		this.is_abstract = is_abstract;
	}
	public String getUser_uuid() {
		return user_uuid;
	}
	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRuledesc() {
		return ruledesc;
	}
	public void setRuledesc(String ruledesc) {
		this.ruledesc = ruledesc;
	}
	public String getForule() {
		return forule;
	}
	public void setForule(String forule) {
		this.forule = forule;
	}
	public String getForAttrib() {
		return forAttrib;
	}
	public void setForAttrib(String forAttrib) {
		this.forAttrib = forAttrib;
	}
	public String getForval() {
		return forval;
	}
	public void setForval(String forval) {
		this.forval = forval;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKnowledgeUrl() {
		return knowledgeUrl;
	}
	public void setKnowledgeUrl(String knowledgeUrl) {
		this.knowledgeUrl = knowledgeUrl;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
