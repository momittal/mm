package com.mittalmohit.hotelbooking.dao;



import org.hibernate.HibernateException;

import com.mittalmohit.hotelbooking.exception.AdException;
import com.mittalmohit.hotelbooking.pojo.Address;
import com.mittalmohit.hotelbooking.pojo.Hotel;
import com.mittalmohit.hotelbooking.pojo.Employee;
import com.mittalmohit.hotelbooking.pojo.User;
import org.hibernate.Query;

public class AffiliateDAO extends DAO{
	 public AffiliateDAO() {
	    }

	 
	 public void create(String username, String password, String userrole, String addressLine1, String addressLine2,
			 int zipcode, String city, String state, String country, String hotelName, 
			 String firstName, String lastName, String email, long phoneNumber) throws AdException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	            
	            //saving hotel details
	            Address address = new Address(addressLine1, addressLine2, zipcode, city, state, country);
	            Hotel hotel = new Hotel(hotelName);
	            hotel.setAddress(address);
	            address.setHotel(hotel);
	            getSession().save(hotel);
	            
	            //getting hotel id	            
	            Query query = getSession().getNamedQuery("getHotel");
	            query.setString("hotelName",hotelName);
	            long hotelId = ((Hotel)query.uniqueResult()).getHotelId();
	            
	          //saving admin
	            User user = new User(firstName, lastName, email, phoneNumber);
	            Employee employee = new Employee();
	            employee.setHotelId(hotelId);
	            employee.setUserName(username);
	            employee.setPassword(password);
	            employee.setUserRole(userrole);
	            employee.setUser(user);
	            user.setUserAccount(employee);
	            getSession().save(user);
	            commit();
	        } catch (HibernateException e) {
	            rollback();    
	            throw new AdException("Exception: " + e.getMessage());
	        }
	    }
	 
	 

	 
}
