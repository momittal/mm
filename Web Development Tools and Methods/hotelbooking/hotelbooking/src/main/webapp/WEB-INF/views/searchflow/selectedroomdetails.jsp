<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
		<table border='1'>
		<tr><td>City</td><td>${requestScope.city }</td></tr>
		<tr><td>Hotel</td><td>${requestScope.hotelName }</td></tr>
		<tr><td>Room</td><td>${requestScope.selectedRoom.roomType}</td></tr>
		<tr><td>Price per night</td><td>${requestScope.selectedRoom.rate }</td></tr>
		
		
		<tr><td>CheckinDate</td><td>${requestScope.checkinDate }</td></tr>
		<tr><td>CheckoutDate</td><td>${requestScope.checkoutDate }</td></tr>
		</table>
	