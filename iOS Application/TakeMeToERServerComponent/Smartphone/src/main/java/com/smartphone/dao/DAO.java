package com.smartphone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.dbutils.DbUtils;

public class DAO {

	  private String driver;
	    private String dburl;
	    private String dbuser;
	    private String dbpassword;
	    
	    public DAO() {
	    	driver = "com.mysql.jdbc.Driver";
	        dburl = "jdbc:mysql://localhost:3306/smartphone";
	        dbuser = "root";
	        dbpassword="root";
	        
	        DbUtils.loadDriver(driver);
	    	
}
	    
	    public Connection getConnection(){
	        Connection conn =null;
	        try{
	            conn = DriverManager.getConnection(dburl,dbuser,dbpassword);
	            
	        }catch(SQLException ex){
	            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE,null,ex);
	        }
	        return conn;
	    }
	    public void close(Connection connection){
	        if(connection != null){
	            try{
	                DbUtils.close(connection);
	            }catch(SQLException ex){
	                System.out.println(ex.getMessage());
	            }
	        }
	    } 


  
    
   
    
}
