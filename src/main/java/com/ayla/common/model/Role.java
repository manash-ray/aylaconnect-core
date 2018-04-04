package com.ayla.common.model;

public class Role {

	private boolean can_add_role_user;
	private String group;
	private int id;
	private String name;
	private int oem_id;
	public boolean isCan_add_role_user() {
		return can_add_role_user;
	}
	public void setCan_add_role_user(boolean can_add_role_user) {
		this.can_add_role_user = can_add_role_user;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOem_id() {
		return oem_id;
	}
	public void setOem_id(int oem_id) {
		this.oem_id = oem_id;
	}
	
	
	
}
