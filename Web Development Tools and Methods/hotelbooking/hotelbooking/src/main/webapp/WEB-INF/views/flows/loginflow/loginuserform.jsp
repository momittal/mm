<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login User Form</title>
</head>
<body ng-app="">
<div id="navbar">
    	<%@include file="/WEB-INF/resources/navbar.jsp" %>
       </div>

  	<c:choose>
  <c:when test="${requestScope.role == 'admin'}">
   	<form name="loginform" action="/HotelBooking/admin/views/flows/loginflow/" method="post">
  </c:when>
  <c:when test="${requestScope.role == 'affiliate'}">
   	<form name="loginform" action="/HotelBooking/affiliate/views/flows/loginflow/" method="post">
  </c:when>
  <c:otherwise>
	<form name="loginform" action="/HotelBooking/booking/views/flows/loginflow/" method="post">
  </c:otherwise>
</c:choose>
	<input type="hidden" name="from" value="${requestScope.currentURI}"/>
	<input type="hidden" name="userrole" value="${requestScope.role}">
<table>

<tr>
    <td>User Name:</td>
    <td><input type="text" name="username" size="30" ng-model="username" required onkeypress="return acceptRegExOnly(event, /^[a-zA-Z0-9]$/);"/></td>
    <td><span style="color:red" ng-show="loginform.username.$touched && loginform.username.$invalid">username is required.</span></td>
</tr>

<tr>
    <td>Password:</td>
    <td><input type="password" name="password" size="30" ng-model="password" required onkeypress="return acceptRegExOnly(event, /^[a-zA-Z0-9]$/);"/></td>
    <td><span style="color:red" ng-show="loginform.password.$touched && loginform.password.$invalid">password is required.</span></td>
    
</tr>
	

<tr>
    <td colspan="2"><input type="submit" value="Login" /></td>
</tr>

</table>
<c:if test="${!empty requestScope.error}">
                <p style="color:red">Invalid credentials</p>
            </c:if>

	
</form>
	<div id="footer">
  <%@include file="/WEB-INF/resources/footer.jsp" %>
  </div>
  
  
</body>
</html>