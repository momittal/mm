package com.mittalmohit.hotelbooking.filter;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class InputFilter implements Filter  {
	   public void  init(FilterConfig config) 
	                         throws ServletException{
	  
	   }
	   public void  doFilter(ServletRequest req, 
	                 ServletResponse response,
	                 FilterChain chain) 
	                 throws java.io.IOException, ServletException {
		   HttpServletRequest request = (HttpServletRequest) req;
		   for(Enumeration requestParameters = request.getParameterNames();
				   requestParameters.hasMoreElements();){
				   String parameterName = (String)requestParameters.nextElement();
				   String[] parameterValue = request.getParameterValues(parameterName);
				   for(String s: parameterValue){
					   System.out.println("String " +s);
					   s = s.replaceAll("[^\\dA-Za-z]", "").replaceAll("\\s+", "+").trim();
					   System.out.println("Filtered String " +s);
				   }
				    
		   }
		   System.out.println("Input Filtered!");	
	      // Pass request back down the filter chain
	      chain.doFilter(request,response);
	   }
	   public void destroy( ){
	      /* Called before the Filter instance is removed 
	      from service by the web container*/
	   }
	}