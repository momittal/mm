package com.mittalmohit.hotelbooking.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;


import java.util.HashSet;

@Entity
@Table(name="hotel")
@NamedQueries({
	@NamedQuery(
	name = "getHotel",
	query = "from Hotel h where h.hotelName = :hotelName"
	),
	@NamedQuery(
			name = "getHotelLikeName",
			query = "from Hotel h where lower(h.hotelName) like lower(:hotelName)"
			),
	@NamedQuery(
			name = "getHotelById",
			query = "from Hotel h where h.hotelId = :hotelId"
			)
})
public class Hotel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="hotelid")
	private long hotelId;
	
	@Column(name="hotelname", unique = true)
	private String hotelName;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="hotelId")
	private Set<Room> rooms = new HashSet<Room>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="hotelId")
	private Set<Employee> employees = new HashSet<Employee>();
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="hotel",cascade=CascadeType.ALL)
	private Amenity amenity;
	
	
	@OneToOne(fetch=FetchType.EAGER, mappedBy="hotel",cascade=CascadeType.ALL)
	private Address address;
	
	
	
	
	public Hotel( String hotelName) {
		super();

		this.hotelName = hotelName;
	}
	public Hotel() {
	
	}

	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Set<Room> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployee(Set<Employee> employees) {
		this.employees = employees;
	}
	public Amenity getAmenity() {
		return amenity;
	}
	public void setAmenity(Amenity amenity) {
		this.amenity = amenity;
	}
	public long getHotelId() {
		return hotelId;
	}
	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}


	
	
	
	
}
