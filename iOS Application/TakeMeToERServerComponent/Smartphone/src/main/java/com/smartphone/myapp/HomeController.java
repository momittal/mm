package com.smartphone.myapp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smartphone.dao.InsertUserData;
import com.smartphone.pojo.UserDetails;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	// private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/usr", method = RequestMethod.POST)
	public void show(@RequestBody  UserDetails udetails) {
		System.out.println("In This Controller");
	}
	
	
	@RequestMapping(value = "/userTrip", method = RequestMethod.POST)
	@ResponseBody
	public void home(HttpServletRequest request) throws IOException {
		//logger.info("Welcome home! The client locale is {}.", locale);
		System.out.println("Trying to inser");
		
		//System.out.println("REQUEST " + request.getParameter("json"));
		
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(request.getParameter("json"));
			JSONObject jsonObj = (JSONObject)obj;
			
			long user_id = (Long) jsonObj.get("user_id");
			//System.out.println("AFTER USER_ID");
			double src_lat = (Double) jsonObj.get("src_lat");
			double src_long = (Double) jsonObj.get("src_long");
			double des_lat = (Double) jsonObj.get("dest_lat");
			double des_long = (Double) jsonObj.get("dest_long");
			double current_lat = (Double) jsonObj.get("user_lat");
			double current_long = (Double) jsonObj.get("user_long");
			String cur_time = (String) jsonObj.get("timestamp");
			//System.out.println("TIMESTAMP");
			String trip_id = (String) jsonObj.get("trip_id");
			
			InsertUserData insert = new InsertUserData();
			insert.enterData(user_id, src_lat, src_long, des_lat, des_long, current_lat, current_long, cur_time, trip_id);
	
		}
		catch(Exception e){
			
	         e.printStackTrace();
	      }
 
	}
	
	
	
	
	
	@RequestMapping(value = "/suggestion", method = RequestMethod.POST)
	@ResponseBody
	public String pastTrip(HttpServletRequest request) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		//System.out.println("LETS SEE THE REPOSNSE" );
		long user_id = Long.parseLong(request.getParameter("userid"));
		double src_lat = Double.parseDouble(request.getParameter("srllat"));
		double src_long = Double.parseDouble(request.getParameter("srllong"));
		double des_lat = Double.parseDouble(request.getParameter("destlat"));
		double des_long = Double.parseDouble(request.getParameter("destlong"));
		
		//Date cur_time = new Date();
		//String cur_time = "1989-02-02";
		
		InsertUserData insert = new InsertUserData();
		List<UserDetails> pastInfo = insert.extractData(user_id, src_lat, src_long, des_lat, des_long);
		
		JSONArray array = new JSONArray();
		
		System.out.println("AFTER INSERTING THE DATA");
		
		for(UserDetails ude : pastInfo) {
		//System.out.println("INSIDE FOR LOOP");
			JSONObject json = new JSONObject();
			json.put("user_id", ude.getUser_id());
			json.put("src_lat", ude.getSrc_lat());
			json.put("src_long", ude.getSrc_long());
			json.put("dest_lat", ude.getDes_lat());
			json.put("dest_long", ude.getDes_long());
			json.put("timestamp1", ude.getCur_time());
			json.put("user_lat", ude.getUser_lat());
			json.put("user_long", ude.getUser_long());
			json.put("trip_id", ude.getTrip_id());
			
			array.add(json);
		}
		
		

		String success = array.toString();
		System.out.println("JSON ARRAY VALUES " + success);
		return success;
	}
	
	@RequestMapping(value = "/trips", method = RequestMethod.POST)
	@ResponseBody
	public String tripId(HttpServletRequest request) {
		
		long user_id = Long.parseLong(request.getParameter("userid"));
		double src_lat = Double.parseDouble(request.getParameter("srllat"));
		double src_long = Double.parseDouble(request.getParameter("srllong"));
		double des_lat = Double.parseDouble(request.getParameter("destlat"));
		double des_long = Double.parseDouble(request.getParameter("destlong"));
		
		InsertUserData insert = new InsertUserData();
		List<UserDetails> uds = insert.getTripId(user_id, src_lat, src_long, des_lat, des_long);
		
		JSONArray array = new JSONArray();
		
		for(UserDetails ude : uds) {
				JSONObject json = new JSONObject();
				json.put("trip_id", ude.getTrip_id());
				
				array.add(json);
	}
		String tripid = array.toString();
	//	System.out.println("JSON ARRAY VALUES FOR TRIP ID " + tripid);
		return tripid;
		
	}
}
