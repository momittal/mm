package com.mittalmohit.hotelbooking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mittalmohit.hotelbooking.dao.BookingDAO;
import com.mittalmohit.hotelbooking.dao.SearchDAO;
import com.mittalmohit.hotelbooking.pojo.Booking;
import com.mittalmohit.hotelbooking.pojo.Hotel;
import com.mittalmohit.hotelbooking.pojo.Room;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping({"/searchresult.htm"})
public class SearchController {
	
	@Autowired
	SearchDAO searchDao;
	
	@Autowired
	BookingDAO bookingDao;
	
	@RequestMapping(method = RequestMethod.GET)
	protected String doSubmitAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("In Search Controller");
		String errormsg = "";
		String searchTerm = request.getParameter("searchterm");
		searchTerm = searchTerm.replaceAll("[^\\dA-Za-z ]", "").trim();
		if(searchTerm.equals("")){
			errormsg = "Please Enter Search Term";
			request.setAttribute("errormsg", errormsg);
			return "/searchflow/searchresult";
		}
		System.out.println(searchTerm);
		
		String date1 = request.getParameter("checkindate");
		String date2 = request.getParameter("checkoutdate");
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date checkinDate = null, checkoutDate = null; 
		try{
			checkinDate = formatter.parse(date1);
			checkoutDate = formatter.parse(date2);
		}catch(ParseException e){
			errormsg = "Please Select Dates";
			request.setAttribute("errormsg", errormsg);
			request.setAttribute("searchTerm", searchTerm);
			return "/searchflow/searchresult";
		}
		System.out.println(checkinDate);
		
		//Validating if checkout date is later than checkin date! Although taken care of it using jquery
		if (checkoutDate.getTime() <= checkinDate.getTime()){
			errormsg = "Error: Please Select checkout date later than checkindate";
			request.setAttribute("searchTerm", searchTerm);
			request.setAttribute("errormsg", errormsg);
			return "/searchflow/searchresult";
		}
		
		//getting list of hotels based on search term
		List<Hotel> hotels = searchDao.search(searchTerm);
		List<Booking> bookings = new ArrayList<Booking>();
		//getting room Ids
		for(Hotel hotel : hotels){
			for(Room room : hotel.getRooms()){
				long roomId = room.getRoomId();
				//get list of bookings for room by room id between searched checkin and checkout dates
				bookings.addAll(bookingDao.getAllBookingsByRoomId(room, checkinDate, checkoutDate));
			}
		}
		
		
		for(Booking b : bookings){
			System.out.println("checkin date" +b.getCheckinDate());
			System.out.println("checkout date "+b.getCheckoutDate());
		}
		

		
		request.setAttribute("checkinDate", checkinDate);
		request.setAttribute("checkoutDate", checkoutDate);
		request.setAttribute("searchTerm", searchTerm);
		request.setAttribute("hotels", hotels);
		request.setAttribute("bookings", bookings);
		
		return "/searchflow/searchresult";
	}
	
}
