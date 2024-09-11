package com.project.accident.blackspots.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class location{

	long accId;
	BigDecimal lat;
	BigDecimal lng;
	String accType;
	int clusterId=-1;
	
/*	public location(long accId, BigDecimal lat, BigDecimal lng, String accType) {
		this.accId = accId;
		this.lat = lat;
		this.lng = lng;
		this.accType = accType;
		this.clusterId=-1;
	}
*/	
	public long getAccId() {
		return accId;
	}
	
	public void setAccId(long accId) {
		this.accId = accId;
	}
	
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	public BigDecimal getLng() {
		return lng;
	}
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public int getClusterId() {
		return clusterId;
	}
	public void setClusterId(int clusterId) {
		this.clusterId = clusterId;
	}

	
	
	
}
