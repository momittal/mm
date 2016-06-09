package com.mittalmohit.hotelbooking.springview;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Header;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfWriter;

public class PdfReportView extends AbstractPdfView
{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document pdfdoc, PdfWriter pdfwriter, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String hotelName = request.getParameter("hotelname");
		String city = request.getParameter("city");
		String roomType = request.getParameter("roomtype");
		String amount = request.getParameter("amount");
		String checkinDate = request.getParameter("checkindate");
		String checkoutDate = request.getParameter("checkoutdate");
		
		
		
		Font fontHeading = new Font(Font.TIMES_ROMAN, 18, Font.BOLD, Color.BLUE );
		Font fontLeftContent = new Font(Font.TIMES_ROMAN, 16, Font.NORMAL, Color.BLACK );
		Font fontRightContent = new Font(Font.TIMES_ROMAN, 16, Font.ITALIC, Color.BLACK );
		Font fontFooter = new Font(Font.TIMES_ROMAN, 12, Font.BOLDITALIC, Color.BLUE );
		
//		Chunk c1 = new Chunk("Chunk 1", font_courier_16_italic_red);
//		Chunk c2 = new Chunk("Chunk 2", font_courier_16_italic_red);
		Phrase left0 = new Phrase("City														  	:	", fontLeftContent);
		Phrase left1 = new Phrase("Hotel Name		  	:	", fontLeftContent);
		Phrase left2 = new Phrase("Room Type					:	", fontLeftContent);
		Phrase left3 = new Phrase("Amount											:	", fontLeftContent);
		Phrase left4 = new Phrase("Checkin Date			:	", fontLeftContent);
		Phrase left5 = new Phrase("Checkout Date	:	", fontLeftContent);
		
		Chunk right0 = new Chunk(city, fontRightContent);
		Chunk right1 = new Chunk(hotelName, fontRightContent);
		Chunk right2 = new Chunk(roomType, fontRightContent);
		Chunk right3 = new Chunk(amount, fontRightContent);
		Chunk right4 = new Chunk(checkinDate, fontRightContent);
		Chunk right5 = new Chunk(checkoutDate, fontRightContent);
		
		
		
		
		Paragraph p1 = new Paragraph("Hotel Booking", fontHeading);
		p1.setAlignment(Element.ALIGN_CENTER);
		
		Paragraph p2 = new Paragraph();
		Paragraph p3 = new Paragraph("Thank you for booking with HotelBooking!", fontFooter );
		p3.setAlignment(Element.ALIGN_CENTER);
		
		pdfdoc.add(p1);
		pdfdoc.add(left0);
		pdfdoc.add(right0);
		pdfdoc.add(p2);
		pdfdoc.add(left1);
		pdfdoc.add(right1);
		pdfdoc.add(p2);
		pdfdoc.add(left2);
		pdfdoc.add(right2);
		pdfdoc.add(p2);
		pdfdoc.add(left3);
		pdfdoc.add(right3);
		pdfdoc.add(p2);
		pdfdoc.add(left4);
		pdfdoc.add(right4);
		pdfdoc.add(p2);
		pdfdoc.add(left5);
		pdfdoc.add(right5);
		pdfdoc.add(p3);
		
	}

}
