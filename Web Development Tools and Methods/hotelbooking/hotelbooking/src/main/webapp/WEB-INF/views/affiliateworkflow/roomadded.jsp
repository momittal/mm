<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Room Added</title>
</head>
<body>
<c:choose>
		<c:when test="${!empty sessionScope.user.userName}">
			<c:choose>
				<c:when test="${sessionScope.user.userRole =='user'}">
				You are not authorized to be here. <a href="http://localhost:8080/HotelBooking/">Click Here to go to Home</a>
			</c:when>
				<c:when test="${sessionScope.user.userRole =='affiliate'}">
					<div id="navbar">
						<%@include file="/WEB-INF/resources/navbar.jsp"%>
					</div>
					Room Added. <br /><br />
					
					
					<a href="/HotelBooking/affiliate/views/affiliateworkflow/addroom">Add
						Room</a>
					<br />
					<br />
					<a href="/HotelBooking/affiliate/views/affiliateworkflow/viewrooms">View
						All Rooms</a>
					<br />
					<br />
					

										
					<c:if test="${!empty requestScope.errormsg}">
						<p style="color: red">${requestScope.errormsg}</p>
					</c:if>


					<div id="footer">
						<%@include file="/WEB-INF/resources/footer.jsp"%>
					</div>
				</c:when>
				<c:when test="${sessionScope.user.userRole =='admin'}">
				You are not authorized to be here!! <a href="http://localhost:8080/HotelBooking/">Click Here to go to Home</a>
			</c:when>
				<c:otherwise>
				You are not authorized to be here! <a href="http://localhost:8080/HotelBooking/">Click Here to go to Home</a>
			</c:otherwise>
			</c:choose>
		</c:when>
	</c:choose>
	 
</body>
</html>