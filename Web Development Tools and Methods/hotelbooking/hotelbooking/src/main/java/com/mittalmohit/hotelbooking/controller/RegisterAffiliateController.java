package com.mittalmohit.hotelbooking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mittalmohit.hotelbooking.dao.AffiliateDAO;
import com.mittalmohit.hotelbooking.exception.AdException;
import com.mittalmohit.hotelbooking.pojo.User;
import com.mittalmohit.hotelbooking.pojo.UserAccount;



@Controller
@RequestMapping({"/registeraffiliate.htm", "/views/flows/affiliateregistrationflow"})
public class RegisterAffiliateController {

	
	@Autowired
	AffiliateDAO affiliateDao = new AffiliateDAO();
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String error = "";
		int pageNum = Integer.parseInt(request.getParameter("pagenum"));
		
		//affiliate hotel details page
		if (pageNum == 1){
			String hotelName = request.getParameter("hotelname");
			String addressLine1 = request.getParameter("addressline1");
			String addressLine2 = request.getParameter("addressline2");		
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String country = request.getParameter("country");
			
			hotelName = hotelName.replaceAll("[^\\dA-Za-z ]", "").trim();
	        addressLine1 = addressLine1.replaceAll("[^\\dA-Za-z ]", "").trim();
	        addressLine2 = addressLine2.replaceAll("[^\\dA-Za-z ]", "").trim();
	        city = city.replaceAll("[^\\dA-Za-z ]", "").trim();
	        state = state.replaceAll("[^\\dA-Za-z ]", "").trim();
	        country = country.replaceAll("[^\\dA-Za-z ]", "").trim();
			
			
			if(!isStringValid(hotelName,1) || !isStringValid(addressLine1,1) || !isStringValid(city,1) || !isStringValid(state,1) || !isStringValid(country,1)){
				request.setAttribute("errormsg","Fields cannot be empty");
				return "/flows/affiliateregistrationflow/affiliatehoteldetails";
			}
		
			
			int zipcode;
			try{
				zipcode = Integer.parseInt(request.getParameter("zipcode"));
				if(zipcode <=0){
					request.setAttribute("errormsg","Please Enter Valid ZipCode");
					return "/flows/affiliateregistrationflow/affiliatehoteldetails";
				}
				
			}
			catch(NumberFormatException e){
				error = "error " + e.getMessage();
				System.out.println(error);
				request.setAttribute("error", true);
				request.setAttribute("errormsg","Please Enter Valid ZipCode");
				return "/flows/affiliateregistrationflow/affiliatehoteldetails";
			}
			
			request.setAttribute("hotelname",hotelName);
			request.setAttribute("addressline1",addressLine1);
			request.setAttribute("addressline2",addressLine2);
			request.setAttribute("city",city);
			request.setAttribute("state",state);
			request.setAttribute("country",country);
			request.setAttribute("zipcode",zipcode);	
			request.setAttribute("userrole", "affiliate");
			return "/flows/affiliateregistrationflow/affiliateadmindetails";
		}
		
		
		//affiliate admin detail page
		else if (pageNum == 2){
			
			
			String firstName, lastName, email, username, password;
			int zipcode;
			long phoneNumber;
			String hotelName, addressLine1, addressLine2, city,state, country, userrole;
			firstName = request.getParameter("firstname");
			lastName = request.getParameter("lastname");
			email = request.getParameter("email");
			phoneNumber = (Long.parseLong(request.getParameter("phonenumber")));
			username = request.getParameter("username");
			password = request.getParameter("password");			
			userrole = request.getParameter("userrole");
			
			
			hotelName = request.getParameter("hotelname");
			addressLine1 = request.getParameter("addressline1");
			addressLine2 = request.getParameter("addressline2");		
			city = request.getParameter("city");
			state = request.getParameter("state");
			country = request.getParameter("country");
			zipcode = Math.abs(Integer.parseInt(request.getParameter("zipcode")));
			

			//Saving to database
			try {
				
				
				affiliateDao.create( username,  password,  userrole,  addressLine1,  addressLine2,zipcode, 
						city,  state,  country,  hotelName,  firstName,  lastName,  email, phoneNumber);				
				System.out.print("DAO successful");
				
				return "/flows/affiliateregistrationflow/affiliateregistrationsuccess";
				
				
			} 
			catch (AdException e) {
				request.setAttribute("errormsg","Something Went Wrong. Please Try Again!");
				System.out.println("Exception: " + e.getMessage());
				return "/flows/affiliateregistrationflow/affiliatehoteldetails";
			}
				
			
		}
		
		request.setAttribute("errormsg","Something Went Wrong. Please Try Again!");
		return "/flows/affiliateregistrationflow/affiliatehoteldetails";
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(HttpServletRequest hsr, HttpServletResponse response) {
		HttpSession session = hsr.getSession();
		UserAccount userAccount =(UserAccount) session.getAttribute("user");
		if(userAccount == null){
			String requestURI = hsr.getRequestURL().toString();
		     System.out.println("Request from "+ requestURI);
		     if(requestURI.contains("/affiliate/views")){
		    	 System.out.println("Affiiate Registration Request - RegisterAffiliateController.java");
		    	 hsr.setAttribute("role","affiliate");
		     }
			return "/flows/affiliateregistrationflow/affiliatehoteldetails";
		}
		if(userAccount!=null && userAccount.getUserRole().equals("user")){
			session.setAttribute("user",userAccount);

        	return "/flows/loginflow/loginsuccess";
		}	
		
		else if(userAccount!=null && userAccount.getUserRole().equals("affiliate")){
			session.setAttribute("user",userAccount);
			return "/affiliateworkflow/loginsuccess";
		}
		
		
		return "/flows/affiliateregistrationflow/affiliatehoteldetails";
		
		
	}
	
	
	
	
	public boolean isStringValid(String str, int length){
		if (str.length() < length) {
			return false;
		}
		return true;
	}
	
	
}
