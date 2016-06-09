package com.mittalmohit.hotelbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

import com.mittalmohit.hotelbooking.dao.UserDAO;
import com.mittalmohit.hotelbooking.exception.AdException;
import com.mittalmohit.hotelbooking.pojo.UserAccount;
import com.mittalmohit.hotelbooking.pojo.Employee;
import com.mittalmohit.hotelbooking.validator.UserValidator;

@Controller
@RequestMapping({"/loginuser.htm", "/views/flows/loginflow"})
public class LoginUserFormController {
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;
	
	@Autowired
	UserDAO userDao;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {    
		HttpSession session = hsr.getSession();
		UserAccount userAccount =(UserAccount) session.getAttribute("user");
		ModelAndView mv = new ModelAndView();
		String role = hsr.getParameter("userrole");
		if(userAccount == null){
			String requestURI = hsr.getRequestURL().toString();
	        System.out.println("Request from "+ requestURI);
	        
	            
	        String username = hsr.getParameter("username");
	        String password = hsr.getParameter("password");
	        
	        username = username.replaceAll("[^\\dA-Za-z]", "").replaceAll("\\s+", "+").trim();
	        password = password.replaceAll("[^\\dA-Za-z]", "").replaceAll("\\s+", "+").trim();  
	        
	        
	                
	        try {
				
				userAccount = userDao.authenticateUserAccount(username, password, role);
				try{
					if(userAccount!=null && role.equals("user")){
						session.setAttribute("user",userAccount);
						mv.setViewName("/flows/loginflow/loginsuccess");
			        	return mv;
					}	
					
					else if(userAccount!=null && role.equals("affiliate")){
						session.setAttribute("user",userAccount);
						//session.setAttribute("hotelId",((Employee)userAccount).getHotelId());
						mv.setViewName("/affiliateworkflow/loginsuccess");
			        	return mv;
					}
					else if(userAccount!=null && role.equals("admin")){
						session.setAttribute("user",userAccount);
						mv.setViewName("/adminworkflow/loginsuccess");
			        	return mv;
					}
					
				}catch(Exception e) {
					System.out.println("Exception: " + e.getMessage());
					
				}
			} 
			catch (AdException e) {
				System.out.println("Exception: " + e.getMessage());
			} 
	        hsr.setAttribute("error","true");
	        hsr.setAttribute("role", role);
	        mv.setViewName("/flows/loginflow/loginuserform");
	        return mv;

		}else{
			if(userAccount!=null && userAccount.getUserRole().equals("user")){
				session.setAttribute("user",userAccount);
				mv.setViewName("/flows/loginflow/loginsuccess");
	        	return mv;
			}	
			
			else if(userAccount!=null && userAccount.getUserRole().equals("affiliate")){
				session.setAttribute("user",userAccount);
				//session.setAttribute("hotelId",((Employee)userAccount).getHotelId());
				mv.setViewName("/affiliateworkflow/loginsuccess");
	        	return mv;
			}
		}
		hsr.setAttribute("error","true");
		hsr.setAttribute("role", role);
        mv.setViewName("/flows/loginflow/loginuserform");
        return mv;
        
	}
	
	
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleGetRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {   
		HttpSession session = hsr.getSession();
		UserAccount userAccount =(UserAccount) session.getAttribute("user");
		ModelAndView mv = new ModelAndView();
		if(userAccount == null){
			
			 mv.setViewName("/flows/loginflow/loginuserform");
			 String requestURI = hsr.getRequestURL().toString();
		     System.out.println("Request from "+ requestURI);
		     if(requestURI.contains("/affiliate/views")){
		    	 System.out.println("Affiiate Login Request");
		    	 hsr.setAttribute("role","affiliate");
		     }else if(requestURI.contains("/booking/views")){
		    	 System.out.println("User Login Request");
		    	 hsr.setAttribute("role","user");
		     }else if(requestURI.contains("/admin/views")){
		    	 System.out.println("Admin Login Request");
		    	 hsr.setAttribute("role","admin");
		     }
		}
		if(userAccount!=null && userAccount.getUserRole().equals("user")){
			session.setAttribute("user",userAccount);
			mv.setViewName("/flows/loginflow/loginsuccess");
        	return mv;
		}	
		
		else if(userAccount!=null && userAccount.getUserRole().equals("affiliate")){
			session.setAttribute("user",userAccount);
			//session.setAttribute("hotelId",((Employee)userAccount).getHotelId());
			mv.setViewName("/affiliateworkflow/loginsuccess");
        	return mv;
		}
		return mv;
	}

	
}
