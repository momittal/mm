<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking History</title>
</head>
<body>
	<div id="navbar">
		<%@include file="/WEB-INF/resources/navbar.jsp"%>
	</div>

	<table border="1">
		<tr>
			<th>Room Type</th>
			<th>Amount Paid</th>
			<th>Booking Date</th>
			<th>Checkin Date</th>
			<th>Checkout Date</th>
		</tr>

		<c:forEach items="${requestScope.bookings}" var="booking">
			<tr>
				<td>${booking.room.roomType }</td>
				<td>${booking.payment.amount }</td>

				<fmt:formatDate value="${booking.bookingDate}" var="bookingDate" type="date" pattern="MMM-dd-yyyy" />
				<fmt:formatDate value="${booking.checkinDate}" var="checkinDate" type="date" pattern="MMM-dd-yyyy" />
				<fmt:formatDate value="${booking.checkoutDate}" var="checkoutDate" type="date" pattern="MMM-dd-yyyy" />

				<td>${bookingDate }</td>
				<td>${checkinDate }</td>
				<td>${checkoutDate }</td>
			</tr>
		</c:forEach>

	</table>
	<div id="footer">
		<%@include file="/WEB-INF/resources/footer.jsp"%>
	</div>

</body>
</html>