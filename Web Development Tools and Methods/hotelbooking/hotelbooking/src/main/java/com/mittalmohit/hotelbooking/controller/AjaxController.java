package com.mittalmohit.hotelbooking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping({"/ajaxcallhotelname.htm"})
public class AjaxController {
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
	System.out.println("Ajax Called");
	return null;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	protected String doGetAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
	System.out.println("Ajax Called GET");
	return null;
	}
	
}
