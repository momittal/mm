package com.mittalmohit.ecommerce.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.mittalmohit.ecommerce.pojo.Address;
import com.mittalmohit.ecommerce.pojo.Buyer;
import com.mittalmohit.ecommerce.pojo.Phone;
import com.mittalmohit.ecommerce.pojo.Seller;
import com.mittalmohit.ecommerce.pojo.User;

public class UserDAO extends DAO{

	public Seller authenticateSeller(String username, String password) {
		try {
			begin();
			Query q = getSession().createQuery("from Seller where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);
			Seller seller = (Seller) q.uniqueResult();
			commit();
			return seller;
		} catch (HibernateException e) {
			rollback();
			System.out.println("hibernate Exception: " + e.getMessage());
			return null;
		}
	}

	public Buyer authenticateBuyer(String username, String password) {
		try {
			begin();
			Query q = getSession().createQuery("from Buyer where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);
			Buyer buyer = (Buyer) q.uniqueResult();
			commit();
			return buyer;
		} catch (HibernateException e) {
			rollback();
			System.out.println("hibernate Exception: " + e.getMessage());
			return null;
		}
	}


	public Buyer registerBuyer(String username,String password,String name,String email,String addressLine1,
			String addressLine2,String city,String state,String country, String zipcode, String phoneNumber){
		try{
			begin();
			Buyer buyer  = new Buyer();
			buyer.setName(name);
			buyer.setEmail(email);
			buyer.setUsername(username);
			buyer.setPassword(password);
			Address address = new Address();
			address.setCity(city);
			address.setCountry(country);
			address.setLine1(addressLine1);
			address.setLine2(addressLine2);
			address.setState(state);
			address.setZipcode(00);
			Phone phone = new Phone();
			phone.setNumber(00);
			buyer.setAddress(address);
			address.setUser(buyer);
			buyer.setPhone(phone);
			phone.setUser(buyer);
			getSession().save(buyer);

			commit();
			return buyer;
		}catch(Exception e){
			System.out.println("Exception in registerBuyer: " + e.getMessage());
			return null;
		}
	}

	public Seller registerSeller(String username,String password,String name,String email,String addressLine1,
			String addressLine2,String city,String state,String country, String zipcode, String phoneNumber){
		try{
			begin();
			Seller seller  = new Seller();
			seller.setName(name);
			seller.setEmail(email);
			seller.setUsername(username);
			seller.setPassword(password);
			Address address = new Address();
			address.setCity(city);
			address.setCountry(country);
			address.setLine1(addressLine1);
			address.setLine2(addressLine2);
			address.setState(state);
			address.setZipcode(00);
			Phone phone = new Phone();
			phone.setNumber(00);
			seller.setAddress(address);
			address.setUser(seller);
			seller.setPhone(phone);
			phone.setUser(seller);
			getSession().save(seller);

			commit();
			return seller;
		}catch(Exception e){
			System.out.println("Exception in registerSeller: " + e.getMessage());
			return null;
		}
	}


}
