package com.mittalmohit.hotelbooking.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	@Id
	@GeneratedValue
	@Column(name="paymentid")
	private long paymentId;
	@Column(name="amount")
	private int amount;
	@Column(name="creditcardnumber")
	private long creditCardNumber;
	@Column(name="creditcardexpiredate")
	private Date creditCardExpireDate;
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Booking booking;
	public Payment() {
		
	}
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public long getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public Date getCreditCardExpireDate() {
		return creditCardExpireDate;
	}
	public void setCreditCardExpireDate(Date creditCardExpireDate) {
		this.creditCardExpireDate = creditCardExpireDate;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	
}
