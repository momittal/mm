<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
</head>
<body>
	<div id="navbar">
		<%@include file="/WEB-INF/resources/navbar.jsp"%>
	</div>



	<div id="searchfilter">
		<%@include file="searchform.jsp"%>
		<%@include file="searchfilters.jsp"%>
	</div>


	<div id="searchresult">
		<h3>
			You Searched for <font color="GREEN">"${requestScope.searchTerm }"</font>
			<fmt:formatDate value="${requestScope.checkinDate}" var="checkinDate" type="date" pattern="MMM-dd-yyyy" />
			<fmt:formatDate value="${requestScope.checkoutDate}" var="checkoutDate" type="date" pattern="MMM-dd-yyyy" />
			from <font color="GREEN">${checkinDate }</font> to <font
				color="GREEN">${checkoutDate }</font>
		</h3>
		<table border='1'>
			<tr>
				<th>City</th>
				<th>Hotel Name</th>
				<th>Room Type</th>
				<th>Price (USD)</th>
				<th>Photo</th>
				<th>Refrigerator in Room</th>
				<th>Book Room</th>
			</tr>
			<c:forEach items="${hotels}" var="hotel">
				<c:forEach items="${hotel.rooms}" var="room">
					<c:choose>
						<c:when test="${!empty bookings }">
							<c:forEach items="${requestScope.bookings}" var="booking">
								<c:choose>
									<c:when test="${ booking.room.roomId ne room.roomId }">
										<tr>
											<td><c:out value="${hotel.address.city}" />
											<td>${hotel.hotelName}</td>
											<td><c:out value="${room.roomType}" /></td>
											
											<td>${room.rate }</td>
											<td><a target="new" href="${ room.photo }"> <img
													src="${ room.photo }" height="100" width="100" /></a></td>
											<td><c:choose>
													<c:when test="${not room.service.refrigeratorInRoom}">No</c:when>
													<c:otherwise>Yes</c:otherwise>
												</c:choose></td>
											<td><a href="bookroom.htm?city=${hotel.address.city}&hotelname=${hotel.hotelName}&selectedroomid=${room.roomId}&checkindate=${requestScope.checkinDate }&checkoutdate=${requestScope.checkoutDate}">Book
													Room</a></td>
										</tr>
									</c:when>
									<c:otherwise>

									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td><c:out value="${hotel.address.city}" />
								<td>${hotel.hotelName}</td>
								<td><c:out value="${room.roomType}" /></td>
								
								<td>${room.rate }</td>
								<td><a target="new" href="${ room.photo }"> <img
										src="${ room.photo }" height="100" width="100" /></a></td>
								<td><c:choose>
										<c:when test="${not room.service.refrigeratorInRoom}">No</c:when>
										<c:otherwise>Yes</c:otherwise>
									</c:choose></td>
								<td><a
									href="bookroom.htm?city=${hotel.address.city}&hotelname=${hotel.hotelName}&selectedroomid=${room.roomId}&checkindate=${requestScope.checkinDate }&checkoutdate=${requestScope.checkoutDate}">Book
										Room</a></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:forEach>
		</table>
	</div>

	<div id="footer">
		<%@include file="/WEB-INF/resources/footer.jsp"%>
	</div>


</body>
</html>