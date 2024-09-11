package com.project.accident.blackspots.model;

import java.math.BigDecimal;

import javax.persistence.*;



@Entity
@Table(name="accidents")
public class accident {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
//	@Column(name="acc_id")
	private long accId;
//	@Column(name="lat")
	private BigDecimal lat;
//	@Column(name="lng")
	private BigDecimal lng;
//	@Column(name="ward")
	private String ward;
//	@Column(name="acc_type")
	private String accType;
//	@Column(name="date")
	private String date;
//	@Column(name="time")
	private String time;
//	@Column(name="weather")
	private String weather;
	
	@Override
	public String toString() {
		return "accident [lat=" + lat + ", lng=" + lng + ", ward=" + ward + ", accType=" + accType + ", date=" + date
				+ ", time=" + time + ", weather=" + weather + "]";
	}
	
	public long getAccId() {
		return accId;
	}
	public void setAccId(long accId) {
		this.accId = accId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
}
