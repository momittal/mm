package com.mittalmohit.hotelbooking.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.mittalmohit.hotelbooking.exception.AdException;
import com.mittalmohit.hotelbooking.pojo.Employee;
import com.mittalmohit.hotelbooking.pojo.Room;
import com.mittalmohit.hotelbooking.pojo.Hotel;
import com.mittalmohit.hotelbooking.pojo.Service;
import com.mittalmohit.hotelbooking.pojo.UserAccount;

public class SearchDAO extends DAO{
	 public SearchDAO() {
	    }
	 
	 public List<Hotel> search(String searchTerm) throws AdException {
		 try {
	            begin();
	            
	            
	            Criteria crit = getSession().createCriteria(Hotel.class).createAlias("address", "a")
	            		.add(Restrictions.disjunction()
	            		.add(Restrictions.ilike("hotelName", searchTerm, MatchMode.ANYWHERE))
	            		.add(Restrictions.ilike("a.city", searchTerm, MatchMode.ANYWHERE)));
	            List<Hotel> hotels = crit.list();
	             
	            
//	            Query query = getSession().getNamedQuery("getHotelLikeName");
//	            query.setString("hotelName", "%" +searchTerm + "%");
//	            List<Hotel> hotels = query.list();
	            

	            commit();
	            
	            return hotels;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not get result " + e.getMessage());
	        }
	    }

}
