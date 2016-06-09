package com.mittalmohit.hotelbooking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mittalmohit.hotelbooking.dao.BookingDAO;

import com.mittalmohit.hotelbooking.pojo.Booking;
import com.mittalmohit.hotelbooking.pojo.UserAccount;

@Controller
@RequestMapping({"/bookinghistory.htm"})
public class BookingHistoryController {
	
	@Autowired
	BookingDAO bookingDao;
	
	@RequestMapping(method = RequestMethod.GET)
	protected String doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.print("View Booking History Controller");
		UserAccount userAccount = (UserAccount) request.getSession().getAttribute("user");
		if(userAccount.getUserRole().equals("user")){
			List<Booking> bookings = bookingDao.getAllBookingsByUserAccount(userAccount);
			request.setAttribute("bookings", bookings);			
			return "/userworkflow/bookinghistory";
		}else{
			return "index";
		}
		
	}
	
	
}
