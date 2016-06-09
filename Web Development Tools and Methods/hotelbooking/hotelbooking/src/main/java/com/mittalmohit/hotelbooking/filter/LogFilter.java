package com.mittalmohit.hotelbooking.filter;

import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter  {
	   public void  init(FilterConfig config) 
	                         throws ServletException{

	   }
	   public void  doFilter(ServletRequest request, 
	                 ServletResponse response,
	                 FilterChain chain) 
	                 throws java.io.IOException, ServletException {

	      // Get the IP address of client machine.   
	      String ipAddress = request.getRemoteAddr();
	      HttpServletRequest httpreq = (HttpServletRequest) request;
	      String browser = httpreq.getHeader("User-Agent");

	      // Log the IP address and current timestamp.
	      System.out.println("IP "+ ipAddress + ", Time "
	                                       + new Date().toString() + ", Browser " + browser + "\nStore this in log file!");

	      // Pass request back down the filter chain
	      chain.doFilter(request,response);
	   }
	   public void destroy( ){
	      /* Called before the Filter instance is removed 
	      from service by the web container*/
	   }
	}