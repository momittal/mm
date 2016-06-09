package com.mittalmohit.hotelbooking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.mittalmohit.hotelbooking.springview.PdfReportView;

@Controller
public class PdfReportController {
	
	@Autowired
	PdfReportView pdfView;
	
	@RequestMapping(value = "/report.pdf", method = RequestMethod.POST)
	public ModelAndView createReport(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("In PDF Report Controller");
		
		
		return new ModelAndView(pdfView);
	}
}
