package com.mittalmohit.hotelbooking.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	@Id
	@GeneratedValue
	@Column(name="bookingid")
	private long bookingId;
	@Column(name="bookingDate")
	private Date bookingDate;
	@Column(name="checkinDate")
	private Date checkinDate;
	@Column(name="checkoutDate")
	private Date checkoutDate;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Room room;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private UserAccount userAccount;
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Payment payment;

	public Booking() {
		super();
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	
	
	

}
