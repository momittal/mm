<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Confirmed</title>
</head>
<body>
<div id="navbar">
	<%@include file="/WEB-INF/resources/navbar.jsp" %>
</div>



	<p>Booking Done! </p> 
	
	<div id="selectroomsdetails">
	Your booking details are
	<br/>
	<form action="report.pdf" target="report.pdf" method="POST">
	<table border="1">
	<tr>
	<td>City</td>
	<td><input type="text" readonly name="city" value="${requestScope.city }"/></td>
	</tr>
	<tr>
	<td>Hotel Name</td>
	<td><input type="text" readonly name="hotelname" value="${requestScope.hotelName }"/></td>
	</tr>
	<tr>
	<td>Room Type</td>
	<td><input type="text" readonly name="roomtype" value="${requestScope.selectedRoom.roomType}"/></td>
	</tr>
	<tr>
	<td>Amount</td>
	<td><input type="text" readonly name="amount" value="${requestScope.amount }"/></td>
	</tr>
	<tr>
	<td>Checkin Date</td>
	<td>	<input type="text" readonly name="checkindate" value="${requestScope.checkinDate }"/></td>
	</tr>
	<tr>
	<td>Checkout Date</td>
	<td><input type="text" readonly name="checkoutdate" value="${requestScope.checkoutDate }"/></td>
	</tr>
	<tr>
	<td colspan="2"><input type="submit" name="Print To PDF" value="Print To PDF""></input></td>
	</tr>
	</table>

	</form>
	</div>
	

	
	<div id="footer">
	<%@include file="/WEB-INF/resources/footer.jsp" %>
</div>
</body>
</html>