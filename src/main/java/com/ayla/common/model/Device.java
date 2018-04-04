package com.ayla.common.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Device {
	
	private int id;
	
	private int key;
	private String product_name;
	
	private String product_class;
	
	private String model;
	
	private boolean has_properties;
	 
	private String dsn;
	
	private String oem;
	
	private String oem_model;
	
	private String sw_version;
	
	private String mac;
	
	private String lan_ip;
	
	private int user_id;
	
	private String user_uuid;
	
	private int template_id;
	
	private String connection_status;
	
	private String unique_hardware_id;
	
	private String ip;
	
	private String ssid;
	
	private String connected_at;
	
	private boolean enable_ssl;
	
	private boolean ans_enabled;
	
	private String ans_server;
	
	private boolean log_enabled;
	
	private String registration_type;
	
	private String module_updated_at;
	
	private boolean registrable;
	private String regtoken;
	private String setup_token;
	private boolean provisional;
	private String activated_at;
	private String created_at;
	private String last_get_at;
	
	private double lat;
	private double lng;
	
	private String locality;
	
	private String homekit;
	
	private boolean lan_enabled;
	
	private boolean registered;
	
	private boolean enable_wifi_loc;
	private String device_type;



	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDsn() {
		return dsn;
	}

	public void setDsn(String dsn) {
		this.dsn = dsn;
	}

	public String getOem_model() {
		return oem_model;
	}

	public void setOem_model(String oem_model) {
		this.oem_model = oem_model;
	}

	public String getSw_version() {
		return sw_version;
	}

	public void setSw_version(String sw_version) {
		this.sw_version = sw_version;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getLan_ip() {
		return lan_ip;
	}

	public void setLan_ip(String lan_ip) {
		this.lan_ip = lan_ip;
	}


	public String getUser_uuid() {
		return user_uuid;
	}

	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}

	public String getConnection_status() {
		return connection_status;
	}

	public void setConnection_status(String connection_status) {
		this.connection_status = connection_status;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getHomekit() {
		return homekit;
	}

	public void setHomekit(String homekit) {
		this.homekit = homekit;
	}

	public boolean isLan_enabled() {
		return lan_enabled;
	}

	public void setLan_enabled(boolean lan_enabled) {
		this.lan_enabled = lan_enabled;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	public String getProduct_class() {
		return product_class;
	}

	public void setProduct_class(String product_class) {
		this.product_class = product_class;
	}

	public boolean isHas_properties() {
		return has_properties;
	}

	public void setHas_properties(boolean has_properties) {
		this.has_properties = has_properties;
	}

	public boolean isEnable_wifi_loc() {
		return enable_wifi_loc;
	}

	public void setEnable_wifi_loc(boolean enable_wifi_loc) {
		this.enable_wifi_loc = enable_wifi_loc;
	}

	public String getDevice_type() {
		return device_type;
	}

	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}


	public String getOem() {
		return oem;
	}

	public void setOem(String oem) {
		this.oem = oem;
	}

	public String getUnique_hardware_id() {
		return unique_hardware_id;
	}

	public void setUnique_hardware_id(String unique_hardware_id) {
		this.unique_hardware_id = unique_hardware_id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getConnected_at() {
		return connected_at;
	}

	public void setConnected_at(String connected_at) {
		this.connected_at = connected_at;
	}

	public boolean isEnable_ssl() {
		return enable_ssl;
	}

	public void setEnable_ssl(boolean enable_ssl) {
		this.enable_ssl = enable_ssl;
	}

	public boolean isAns_enabled() {
		return ans_enabled;
	}

	public void setAns_enabled(boolean ans_enabled) {
		this.ans_enabled = ans_enabled;
	}

	public String getAns_server() {
		return ans_server;
	}

	public void setAns_server(String ans_server) {
		this.ans_server = ans_server;
	}

	public boolean isLog_enabled() {
		return log_enabled;
	}

	public void setLog_enabled(boolean log_enabled) {
		this.log_enabled = log_enabled;
	}

	public String getRegistration_type() {
		return registration_type;
	}

	public void setRegistration_type(String registration_type) {
		this.registration_type = registration_type;
	}

	public String getModule_updated_at() {
		return module_updated_at;
	}

	public void setModule_updated_at(String module_updated_at) {
		this.module_updated_at = module_updated_at;
	}

	public boolean isRegistrable() {
		return registrable;
	}

	public void setRegistrable(boolean registrable) {
		this.registrable = registrable;
	}

	public String getRegtoken() {
		return regtoken;
	}

	public void setRegtoken(String regtoken) {
		this.regtoken = regtoken;
	}

	public String getSetup_token() {
		return setup_token;
	}

	public void setSetup_token(String setup_token) {
		this.setup_token = setup_token;
	}

	public boolean isProvisional() {
		return provisional;
	}

	public void setProvisional(boolean provisional) {
		this.provisional = provisional;
	}

	public String getActivated_at() {
		return activated_at;
	}

	public void setActivated_at(String activated_at) {
		this.activated_at = activated_at;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getLast_get_at() {
		return last_get_at;
	}

	public void setLast_get_at(String last_get_at) {
		this.last_get_at = last_get_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(int template_id) {
		this.template_id = template_id;
	}
	
	
	
	
	
	
	


	
	
}
