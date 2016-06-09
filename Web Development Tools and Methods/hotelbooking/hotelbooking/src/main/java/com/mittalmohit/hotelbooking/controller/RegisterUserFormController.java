package com.mittalmohit.hotelbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mittalmohit.hotelbooking.validator.UserValidator;
import com.mittalmohit.hotelbooking.dao.UserDAO;
import com.mittalmohit.hotelbooking.exception.AdException;
import com.mittalmohit.hotelbooking.pojo.User;
import com.mittalmohit.hotelbooking.pojo.UserAccount;

@Controller
@RequestMapping({ "/registeruser.htm", "/views/flows/registrationflow", "/editprofile.htm"})
public class RegisterUserFormController {
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
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest hsr)
			throws Exception {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "/flows/registrationflow/registeruserform";
		}

		try {
			System.out.print("test");

			System.out.print("test1");

			User createdUser = userDao.create(user.getFirstName(), user.getLastName(), user.getEmail(),
					user.getPhoneNumber(), user.getUserAccount().getUserName(), user.getUserAccount().getPassword(),
					user.getUserAccount().getUserRole());
			HttpSession session = hsr.getSession();
			session.setAttribute("user", createdUser.getUserAccount());
			if (createdUser != null) {
				return "/flows/registrationflow/registrationsuccess";
			}

		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		hsr.setAttribute("error", "true");
		return "/flows/registrationflow/registeruserform";

	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest hsr) {
		HttpSession session = hsr.getSession();
		UserAccount userAccount =(UserAccount) session.getAttribute("user");
		if(userAccount == null){
			String requestURI = hsr.getRequestURL().toString();
			System.out.println("Request from " + requestURI);
			if (requestURI.contains("/booking/views")) {
				System.out.println("User Reigstration Request");
				hsr.setAttribute("role", "user");
			} else if (requestURI.contains("/admin/views")) {
				System.out.println("Admin Registration Request");
				hsr.setAttribute("role", "admin");
			}
			return "/flows/registrationflow/registeruserform";
		}
		if(userAccount!=null && userAccount.getUserRole().equals("user")){
			session.setAttribute("user",userAccount);

        	return "/flows/loginflow/loginsuccess";
		}	
		
		else if(userAccount!=null && userAccount.getUserRole().equals("affiliate")){
			session.setAttribute("user",userAccount);
			return "/affiliateworkflow/loginsuccess";
		}
		return "/flows/registrationflow/registeruserform";
		
	}
	
	
	
	
	

	@RequestMapping(method = RequestMethod.GET, value = "/editprofile.htm")
	public String editUser(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest hsr) {

		System.out.println("Edit Profile Request");
		UserAccount userAccount = (UserAccount) hsr.getSession().getAttribute("user");
		user.setFirstName(userAccount.getUser().getFirstName());
		user.setLastName(userAccount.getUser().getLastName());
		user.setEmail(userAccount.getUser().getEmail());
		user.setPhoneNumber(userAccount.getUser().getPhoneNumber());
		user.setUserAccount(userAccount);
		hsr.setAttribute("mode", "edit");
		hsr.setAttribute("role", "user");
		return "/flows/registrationflow/registeruserform";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/editprofile.htm")
	protected String doEditAction(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest hsr)
			throws Exception {
		validator.validate(user, result);
		System.out.println("post method of update profile");
		UserAccount userAccount = (UserAccount) hsr.getSession().getAttribute("user");;
		if (result.hasErrors()) {
			
			user.setFirstName(userAccount.getUser().getFirstName());
			user.setLastName(userAccount.getUser().getLastName());
			user.setEmail(userAccount.getUser().getEmail());
			user.setPhoneNumber(userAccount.getUser().getPhoneNumber());
			user.setUserAccount(userAccount);
			hsr.setAttribute("mode", "edit");
			return "/flows/registrationflow/registeruserform";
		}

		try {
			
			User updatedUser = userDao.update(userAccount,user.getFirstName(), user.getLastName(), user.getEmail(),
					user.getPhoneNumber(), user.getUserAccount().getUserName(), user.getUserAccount().getPassword(),
					user.getUserAccount().getUserRole());
			HttpSession session = hsr.getSession();
			session.setAttribute("user", updatedUser.getUserAccount());
			return "/flows/registrationflow/registrationsuccess";
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		user.setFirstName(userAccount.getUser().getFirstName());
		user.setLastName(userAccount.getUser().getLastName());
		user.setEmail(userAccount.getUser().getEmail());
		user.setPhoneNumber(userAccount.getUser().getPhoneNumber());
		user.setUserAccount(userAccount);
		hsr.setAttribute("error", "true");
		hsr.setAttribute("mode", "edit");
		return "/flows/registrationflow/registeruserform";

	}
	

}
