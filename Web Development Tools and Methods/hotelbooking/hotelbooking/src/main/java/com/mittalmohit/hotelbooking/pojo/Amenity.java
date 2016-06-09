package com.mittalmohit.hotelbooking.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.FetchType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="amenity")
public class Amenity {
	
	@Id
	@GeneratedValue(generator="generator")
	@GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="hotelId"))
	@Column(name="hotelid")
	private long hotelId;
	
	@OneToOne(fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn(name="hotelId")
	private Hotel hotel;
	
	
	@Column(name="swimmingpool")
	private Boolean swimmingPool;
	@Column(name="restaurant")
	private Boolean restaurant;
	@Column(name="wifi")
	private Boolean wifi;
	
	public Amenity(Boolean swimmingPool, Boolean restaurant, Boolean wifi) {
		super();
		this.swimmingPool = swimmingPool;
		this.restaurant = restaurant;
		this.wifi = wifi;
	}
	public Amenity() {
		
	}
	public long getHotelId() {
		return hotelId;
	}
	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}
	public Boolean getSwimmingPool() {
		return swimmingPool;
	}
	public void setSwimmingPool(Boolean swimmingPool) {
		this.swimmingPool = swimmingPool;
	}
	public Boolean getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Boolean restaurant) {
		this.restaurant = restaurant;
	}
	public Boolean getWifi() {
		return wifi;
	}
	public void setWifi(Boolean wifi) {
		this.wifi = wifi;
	}
	
	
	
	
}
