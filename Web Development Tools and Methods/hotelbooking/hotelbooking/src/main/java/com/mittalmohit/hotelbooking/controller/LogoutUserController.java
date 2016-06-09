package com.mittalmohit.hotelbooking.controller;

	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;
	import org.springframework.web.servlet.ModelAndView;


	@Controller
	@RequestMapping({"/logoutuser.htm","**/logoutuser.htm", "HotelBooking/logoutuser/"})
	public class LogoutUserController {
		
		@RequestMapping(method = RequestMethod.GET)
		public ModelAndView handleGetRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {   
			ModelAndView mv = new ModelAndView();
			HttpSession session = hsr.getSession();
			session.invalidate();
			 mv.setViewName("index");
			return mv;
		}

		
	}
