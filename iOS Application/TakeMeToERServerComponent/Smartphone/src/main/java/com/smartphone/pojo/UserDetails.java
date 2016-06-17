package com.smartphone.pojo;

import java.util.Date;

public class UserDetails {

	private long user_id;
	private double src_lat;
	private double src_long;
	private double des_lat;
	private double des_long;
	private double user_lat;
	private double user_long;
	private String trip_id;
	private String cur_time;
	
	
	public UserDetails() {
		super();
	}
	public double getUser_lat() {
		return user_lat;
	}
	public void setUser_lat(double user_lat) {
		this.user_lat = user_lat;
	}
	public double getUser_long() {
		return user_long;
	}
	public void setUser_long(double user_long) {
		this.user_long = user_long;
	}
	public String getCur_time() {
		return cur_time;
	}
	public void setCur_time(String cur_time) {
		this.cur_time = cur_time;
	}
	public String getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(String trip_id) {
		this.trip_id = trip_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public double getSrc_lat() {
		return src_lat;
	}
	public void setSrc_lat(double src_lat) {
		this.src_lat = src_lat;
	}
	public double getSrc_long() {
		return src_long;
	}
	public void setSrc_long(double src_long) {
		this.src_long = src_long;
	}
	public double getDes_lat() {
		return des_lat;
	}
	public void setDes_lat(double des_lat) {
		this.des_lat = des_lat;
	}
	public double getDes_long() {
		return des_long;
	}
	public void setDes_long(double des_long) {
		this.des_long = des_long;
	}
	
	
	
}
