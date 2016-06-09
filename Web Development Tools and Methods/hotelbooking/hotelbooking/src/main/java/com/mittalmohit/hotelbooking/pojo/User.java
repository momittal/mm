package com.mittalmohit.hotelbooking.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user",
uniqueConstraints = {@UniqueConstraint(columnNames={"email"})})
@Inheritance(strategy= InheritanceType.JOINED)
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private long userId;
	@Column(name="firstname", nullable=false)
	private String firstName;
	@Column(name="lastname", nullable=false)
	private String lastName;
	@Column(name="phonenumber", unique=true, nullable=false)
	private long phoneNumber;
	@Column(name="email", nullable=false )
	private String email;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="user",cascade=CascadeType.ALL)
	private UserAccount userAccount;
	 
	
	
	

	public User() {
		
	}	
	
	
	
	
	public User(String firstName, String lastName, String email, long phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}




	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public UserAccount getUserAccount() {
		return userAccount;
	}



	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
	
	
	
}
