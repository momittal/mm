package com.mittalmohit.hotelbooking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mittalmohit.hotelbooking.dao.RoomDAO;
import com.mittalmohit.hotelbooking.pojo.Employee;
import com.mittalmohit.hotelbooking.pojo.Room;
import com.mittalmohit.hotelbooking.pojo.UserAccount;

@Controller
@RequestMapping({"/views/affiliateworkflow/viewrooms"})
public class AffiliateViewRoomController {
	
	@Autowired
	RoomDAO roomDao;
	
	@RequestMapping(method = RequestMethod.GET)
	protected String doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserAccount userAccount = (UserAccount) request.getSession().getAttribute("user");
		if(userAccount.getUserRole().equals("affiliate")){
			System.out.print("Affiliate View Room Controller");
			
			Employee employee =(Employee) request.getSession().getAttribute("user");
			List<Room> rooms = roomDao.getRoomList(employee);
			
			
			request.setAttribute("rooms", rooms);
			return "/affiliateworkflow/viewrooms";
		}else{
			return "index";
		}
		
	}
	
}
