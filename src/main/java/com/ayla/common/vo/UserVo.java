package com.ayla.common.vo;

import com.ayla.common.model.User;

public class UserVo extends User{


	private static final long serialVersionUID = 1L;



String name;
String picType;
String picName;
String currentPicid;
boolean adminApproved=false;







String fromCreatedDate;
String toCreatedDate;

String emails;


boolean isActive;

boolean isOrganizer;


String userPersonaName;

public String getPicType() {
	return picType;
}

public boolean isOrganizer() {
	return isOrganizer;
}

public void setOrganizer(boolean isOrganizer) {
	this.isOrganizer = isOrganizer;
}

public void setPicType(String picType) {
	this.picType = picType;
}

public String getPicName() {
	return picName;
}

public void setPicName(String picName) {
	this.picName = picName;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCurrentPicid() {
	return currentPicid;
}

public void setCurrentPicid(String currentPicid) {
	this.currentPicid = currentPicid;
}

public boolean isActive() {
	return isActive;
}



public void setActive(boolean isActive) {
	this.isActive = isActive;
}

public String getFromCreatedDate() {
	return fromCreatedDate;
}

public void setFromCreatedDate(String fromCreatedDate) {
	this.fromCreatedDate = fromCreatedDate;
}

public String getToCreatedDate() {
	return toCreatedDate;
}

public void setToCreatedDate(String toCreatedDate) {
	this.toCreatedDate = toCreatedDate;
}

public String getEmails() {
	return emails;
}

public void setEmails(String emails) {
	this.emails = emails;
}

public boolean isAdminApproved() {
	return adminApproved;
}

public void setAdminApproved(boolean adminApproved) {
	this.adminApproved = adminApproved;
}

public String getUserPersonaName() {
	return userPersonaName;
}

public void setUserPersonaName(String userPersonaName) {
	this.userPersonaName = userPersonaName;
}








 














	
}
