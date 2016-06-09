<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div id="navbar">
    	<%@include file="/WEB-INF/resources/navbar.jsp" %>
       </div>
       
	<h3>Congratulations <font color="GREEN">${sessionScope.user.userName} </font> ! You Have Been Logged In Successfully! </h3>
	<h4>If you are not redirected to where you were then <a href="http://localhost:8080/HotelBooking/">Click Here</a></h4>
	
	
	<div id="footer">
  <%@include file="/WEB-INF/resources/footer.jsp" %>
  </div>
</body>
</html>