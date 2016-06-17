package com.smartphone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smartphone.pojo.UserDetails;

public class InsertUserData extends DAO{

	 Connection conn;
	    PreparedStatement ps;
	    ResultSet rs;
	    int count = 0;
	    String insertQuery;
	    String selectQuery;
	    List<UserDetails> udetails = new ArrayList<UserDetails>();
	    List<UserDetails> uds = new ArrayList<UserDetails>();
	    
	    public int enterData(long user_id, double src_lat, double src_long, double des_lat, double des_long, double current_lat, double current_long, String cur_time, String trip_id) {
	    	try {
	            conn = getConnection();
	    	// Set auto-commit to false
            conn.setAutoCommit(false);
            
          //  System.out.println("INSIDE DAO");
           // System.out.println(user_id);
            insertQuery = "Insert into usertrips(user_id, src_lat, src_long, des_lat, des_long, current_lat, current_long, cur_time, trip_id) values (?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(insertQuery);
            //ps.setInt(1, table_id);
            ps.setLong(1, user_id);
            ps.setDouble(2, src_lat);
            ps.setDouble(3, src_long);
            ps.setDouble(4, des_lat);
            ps.setDouble(5, des_long);
            ps.setDouble(6, current_lat);
            ps.setDouble(7, current_long);
            ps.setString(8, cur_time);
            ps.setString(9, trip_id);
            
            int result = ps.executeUpdate();
            //System.out.println("INSERT RESULT" + result);
            
            conn.commit();
            conn.close();
            
	    	} //Statement stmt = conn.createStatement();
            
	    	catch (SQLException ex) {
	           // Logger.getLogger(InsertDataDao.class.getName()).log(Level.SEVERE, null, ex);
	    		ex.printStackTrace();
	        } finally {
	            close(conn);
	        }
            return 0;
	    } 
	    
	    public List<UserDetails> extractData(long user_id, double src_lat, double src_long, double des_lat, double des_long) {
	    	try {
	            conn = getConnection();
	    	// Set auto-commit to false
            conn.setAutoCommit(false);
           // System.out.println(user_id +" " + src_lat +" " + src_long +" " + des_lat +" " + des_long );
            selectQuery = "Select * from usertrips where user_id=" + user_id + " and src_lat=" + src_lat + " and  src_long=" +src_long + " and des_lat=" +des_lat + " and des_long=" + des_long;
            
            //selectQuery = "Select * from usertrips";
            
            ps = conn.prepareStatement(selectQuery);
            
            System.out.println("QUERY IS  " + selectQuery);
            
            rs = ps.executeQuery(selectQuery);
            System.out.println("After result set" + rs.getFetchSize());
            while(rs.next()) {
            	//System.out.println("INSIDE RESULT SET");
            	UserDetails ud = new UserDetails();
            	ud.setUser_id(rs.getLong("user_id"));
            	ud.setSrc_long(rs.getDouble("src_long"));
            	ud.setSrc_lat(rs.getDouble("src_lat"));
            	ud.setDes_lat(rs.getDouble("des_lat"));
            	ud.setDes_long(rs.getDouble("des_long"));
            	ud.setUser_lat(rs.getDouble("current_lat"));
            	ud.setUser_long(rs.getDouble("current_long"));
            	ud.setCur_time(rs.getString("cur_time"));
            	ud.setTrip_id(rs.getString("trip_id"));
            	
            	udetails.add(ud);
            }
            conn.close();
	    	}
	    	catch (Exception e) {
		           // Logger.getLogger(InsertDataDao.class.getName()).log(Level.SEVERE, null, ex);
	    		e.printStackTrace();
		        } finally {
		            close(conn);
		        }
	    	
	    	   return udetails;
	    	   
	    }
	    
	 public List<UserDetails> getTripId(long user_id, double src_lat, double src_long, double des_lat, double des_long) {
		 try {
	            conn = getConnection();
	    	// Set auto-commit to false
         conn.setAutoCommit(false);
         	
         selectQuery = "Select distinct(trip_id) from usertrips where user_id=" + user_id + " and src_lat=" + src_lat + " and  src_long=" +src_long + " and des_lat=" +des_lat + " and des_long=" + des_long;
         	ps = conn.prepareStatement(selectQuery);
            
            rs = ps.executeQuery(selectQuery);
            while(rs.next()) {
            	UserDetails us = new UserDetails();
            	us.setTrip_id(rs.getString("trip_id"));
            	
            	uds.add(us);
            }
            conn.close();
		 }
		 catch (Exception e) {
	           // Logger.getLogger(InsertDataDao.class.getName()).log(Level.SEVERE, null, ex);
  		e.printStackTrace();
	        } 
		 finally {
	            close(conn);
	        }
 	
 	   return uds;
	 }
}
