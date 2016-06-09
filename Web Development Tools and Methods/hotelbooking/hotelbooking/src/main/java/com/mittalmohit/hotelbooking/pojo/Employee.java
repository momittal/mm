package com.mittalmohit.hotelbooking.pojo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Transient;

@Entity
@Table(name="employee")
@PrimaryKeyJoinColumn(name = "useraccountid")
public class Employee extends UserAccount{
	@JoinColumn(name="hotelid")
	@Column(name="hotelid")
	private long hotelId;
	
	@Transient
	private String hotelName;
	
	public Employee() {

	}
	

	public long getHotelId() {
		return hotelId;
	}
	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	
	
	
}
