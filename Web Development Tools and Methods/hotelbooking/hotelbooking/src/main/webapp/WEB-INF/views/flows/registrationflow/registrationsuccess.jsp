<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registered Successfully</title>
</head>
<body>

	<c:choose>
	<c:when test="${requestScope.mode == 'edit'}">
		<h3>Profile Updated </h3>
	</c:when>
	<c:otherwise>
	<h3>Congratulations <font color="GREEN">${sessionScope.user.userName} </font>! You Have Been Registered Successfully! </h3>
	
	</c:otherwise>
	
	</c:choose>
	
	<h4>If you are not redirected <a href="/">Click Here</a></h4>
	<% response.setHeader("Refresh", "1; URL=/HotelBooking/");%>
</body>
</html>