package com.mittalmohit.hotelbooking.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mittalmohit.hotelbooking.dao.BookingDAO;
import com.mittalmohit.hotelbooking.dao.RoomDAO;
import com.mittalmohit.hotelbooking.dao.UserDAO;
import com.mittalmohit.hotelbooking.pojo.Room;
import com.mittalmohit.hotelbooking.pojo.UserAccount;

@Controller
@RequestMapping({ "/bookroom.htm" })
public class BookRoomController {

	@Autowired
	RoomDAO roomDao;

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("POST Method of Book Room Controller");
		long selectedRoomId = Long.parseLong(request.getParameter("selectedroomid"));

		String errormsg = "";
		String date1 = request.getParameter("checkindate");
		String date2 = request.getParameter("checkoutdate");
		String date3 = request.getParameter("cardexpiredate");
		String city = request.getParameter("city");
		String hotelName = request.getParameter("hotelname");
		int amount, cvv;
		long cardNumber;

		SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss zzzz yyyy");
		SimpleDateFormat formatter2 = new SimpleDateFormat("MMyyyy");
		Date checkinDate = null, checkoutDate = null, cardExpireDate = null;
		Date bookingDate = new Date();

		// get room details via roomId

		Room selectedRoom = roomDao.getRoom(selectedRoomId);

		// get User Account from session
		HttpSession session = request.getSession();
		UserAccount userAccount = (UserAccount) session.getAttribute("user");

		// checking if user is logged in or not
		if (userAccount == null) {
			errormsg = "You need to be logged in to book the room. Please Log in and repeat your search!\n Thanks";
			request.setAttribute("errormsg", errormsg);
			request.setAttribute("checkinDate", checkinDate);
			request.setAttribute("checkoutDate", checkoutDate);
			request.setAttribute("selectedRoom", selectedRoom);
			request.setAttribute("hotelName", hotelName);
			request.setAttribute("city", city);
			return "/searchflow/bookroom";
		}

		try {
			checkinDate = formatter.parse(date1);
			checkoutDate = formatter.parse(date2);
			cardExpireDate = formatter2.parse(date3);
			System.out.println(cardExpireDate + " and " + bookingDate);
		} catch (ParseException e) {
			errormsg = "Please Enter Valid Date";
			request.setAttribute("errormsg", errormsg);
			request.setAttribute("checkinDate", checkinDate);
			request.setAttribute("checkoutDate", checkoutDate);
			request.setAttribute("selectedRoom", selectedRoom);
			request.setAttribute("city", city);
			request.setAttribute("hotelName", hotelName);
			return "/searchflow/bookroom";
		}
		// Validating if checkout date is later than checkin date! Although
		// taken care of it using jquery
		if (checkoutDate.getTime() <= checkinDate.getTime()) {
			errormsg = "Error: Please Select checkout date later than checkindate";
			request.setAttribute("errormsg", errormsg);
			request.setAttribute("checkinDate", checkinDate);
			request.setAttribute("checkoutDate", checkoutDate);
			request.setAttribute("selectedRoom", selectedRoom);
			request.setAttribute("city", city);
			request.setAttribute("hotelName", hotelName);
			return "/searchflow/bookroom";
		}

		try {
			amount = Integer.parseInt(request.getParameter("amount"));
			cvv = Integer.parseInt(request.getParameter("cvv"));
			cardNumber = Long.parseLong(request.getParameter("cardnumber"));
			if (cvv <= 0) {
				request.setAttribute("errormsg", "Please Enter Valid CVV");
				request.setAttribute("checkinDate", checkinDate);
				request.setAttribute("checkoutDate", checkoutDate);
				request.setAttribute("selectedRoom", selectedRoom);
				request.setAttribute("city", city);
				request.setAttribute("hotelName", hotelName);
				return "/searchflow/bookroom";
			}
			if (cardNumber <= 0) {
				request.setAttribute("errormsg", "Please Enter Valid Card Number");
				request.setAttribute("checkinDate", checkinDate);
				request.setAttribute("checkoutDate", checkoutDate);
				request.setAttribute("selectedRoom", selectedRoom);
				request.setAttribute("city", city);
				request.setAttribute("hotelName", hotelName);
				return "/searchflow/bookroom";
			}
			if (cardExpireDate.getTime() <= (new Date().getTime())) {
				request.setAttribute("errormsg", "Please Enter Valid Card Expire Date");
				request.setAttribute("checkinDate", checkinDate);
				request.setAttribute("checkoutDate", checkoutDate);
				request.setAttribute("selectedRoom", selectedRoom);
				request.setAttribute("city", city);
				request.setAttribute("hotelName", hotelName);
				return "/searchflow/bookroom";
			}

		} catch (NumberFormatException e) {
			errormsg = "Error: Please enter valid card details";
			request.setAttribute("errormsg", errormsg);
			request.setAttribute("checkinDate", checkinDate);
			request.setAttribute("checkoutDate", checkoutDate);
			request.setAttribute("selectedRoom", selectedRoom);
			request.setAttribute("city", city);
			request.setAttribute("hotelName", hotelName);
			return "/searchflow/bookroom";
		}

		// code for booking the room
		try {
			BookingDAO bookingDao = new BookingDAO();
			bookingDao.book(amount, cardExpireDate, cardNumber, bookingDate, checkinDate, checkoutDate, selectedRoom,
					userAccount);
		} catch (Exception e) {
			errormsg = "Sorry! Please try again later";
			request.setAttribute("errormsg", errormsg);
			request.setAttribute("checkinDate", checkinDate);
			request.setAttribute("checkoutDate", checkoutDate);
			request.setAttribute("selectedRoom", selectedRoom);
			request.setAttribute("hotelName", hotelName);
			request.setAttribute("city", city);
			return "/searchflow/bookroom";
		}

		request.setAttribute("checkinDate", checkinDate);
		request.setAttribute("checkoutDate", checkoutDate);
		request.setAttribute("selectedRoom", selectedRoom);
		request.setAttribute("hotelName", hotelName);
		request.setAttribute("city", city);
		request.setAttribute("amount", amount);
		return "/searchflow/booked";
	}

	@RequestMapping(method = RequestMethod.GET)
	protected String doGetAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Get Method of Book Room Controller");
		long selectedRoomId = Long.parseLong(request.getParameter("selectedroomid"));
		String checkinDate = request.getParameter("checkindate");
		String checkoutDate = request.getParameter("checkoutdate");
		String city = request.getParameter("city");
		String hotelName = request.getParameter("hotelname");
		// get room details via roomId
		RoomDAO roomDao = new RoomDAO();
		Room selectedRoom = roomDao.getRoom(selectedRoomId);
		
		SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss zzzz yyyy");
		Date d1 = formatter.parse(checkinDate);
		Date d2 = formatter.parse(checkoutDate);
		long amount = selectedRoom.getRate();;
		try{
			amount = (selectedRoom.getRate() * (d2.getTime() - d1.getTime()) / (1000) / (60) / (60) /(24));
		}catch(ArithmeticException e){
			System.out.println(e.getMessage());
		}
		finally {
			request.setAttribute("checkinDate", checkinDate);
			request.setAttribute("checkoutDate", checkoutDate);
			request.setAttribute("selectedRoom", selectedRoom);
			request.setAttribute("city", city);
			request.setAttribute("hotelName", hotelName);
			request.setAttribute("amount", amount);
			return "/searchflow/bookroom";
		}
		
	}

}
