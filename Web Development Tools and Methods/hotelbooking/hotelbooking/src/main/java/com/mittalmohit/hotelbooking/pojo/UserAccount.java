package com.mittalmohit.hotelbooking.pojo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="useraccount")
@NamedQueries({
	@NamedQuery(
	name = "getUserAccountByUserName",
	query = "from UserAccount ua where ua.userName = :userName"
	)
})
public class UserAccount {
	@Id
	@GeneratedValue(generator="generator")
	@GenericGenerator(name="generator",strategy="foreign", parameters=@Parameter(name="property",value="user"))
	@Column(name="useraccountid")
	private long userAccountId;
	@Column(name="username", unique=true, nullable=false)
	private String userName;
	@Column(name="password", nullable=false)
	private String password;
	
	@OneToOne(fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn(name="useraccountid")
	private User user;
	
	@Column(name="userrole")  
	private String userRole;
	
	

	public UserAccount() {
		
	}

	

	public UserAccount(String userName, String password, String userRole) {
		super();
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
	}

	public long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(long userAccountId) {
		this.userAccountId = userAccountId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public String getUserRole() {
		return userRole;
	}



	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	
	
	
	
	
}
