<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
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
    
 <c:choose>
<c:when test="${requestScope.mode == 'edit'}">
<form:form action="editprofile.htm" commandName="user" method="post">
<form:hidden path="userAccount.userRole" value='${requestScope.role}'/>
<table>
<tr>
    <td>First Name:</td>
    <td><form:input path="firstName" size="30" onkeypress="return acceptRegExOnly(event, /^[a-zA-Z]$/);"/> <font color="red"><form:errors path="firstName"/></font></td>
</tr>

<tr>
    <td>Last Name:</td>
    <td><form:input path="lastName" size="30" onkeypress="return acceptRegExOnly(event, /^[a-zA-Z]$/);"/> <font color="red"><form:errors path="lastName"/></font></td>
</tr>


<tr>
    <td>User Name:</td>
    <td><form:input readonly="true" path="userAccount.userName" size="30" onkeypress="return acceptRegExOnly(event, /^[a-zA-Z0-9]$/);" /> <font color="red"><form:errors path="userAccount.userName"/></font></td>
</tr>


<tr>
    <td>Password:</td>
    <td><form:password path="userAccount.password" size="30" onkeypress="return acceptRegExOnly(event, /^[a-zA-Z0-9]$/);" /> <font color="red"><form:errors path="userAccount.password"/></font></td>
</tr>

 <tr>
    <td>Email Id:</td>
    <td><form:input readonly="true" path="email" size="30" onkeypress="return acceptRegExOnly(event, /^[a-zA-Z0-9._@]$/);" /> <font color="red"><form:errors path="email"/></font></td>
</tr>

<tr>
    <td>Phone Number:</td>
    <td><form:input path="phoneNumber" size="30" onkeypress="return acceptRegExOnly(event, /^[0-9]$/);"/> <font color="red"><form:errors path="phoneNumber"/></font></td>
</tr>

  <tr>
    <td colspan="2"><input type="submit" name="_eventId_next" value="Edit Profile" /></td>
</tr>



</table>
<c:if test="${!empty requestScope.error}">
                <p style="color:red">Something went wrong!</p>
</c:if>
	
</form:form>


</c:when>



<c:otherwise>
<form:form action="/HotelBooking/booking/views/flows/registrationflow/" commandName="user" method="post">
<form:hidden path="userAccount.userRole" value='${requestScope.role}'/>
<table>
<tr>
    <td>First Name:</td>
    <td><form:input path="firstName" size="30" onkeypress="return acceptRegExOnly(event, /^[a-zA-Z]$/);"/> <font color="red"><form:errors path="firstName"/></font></td>
</tr>

<tr>
    <td>Last Name:</td>
    <td><form:input path="lastName" size="30" onkeypress="return acceptRegExOnly(event, /^[a-zA-Z]$/);"/> <font color="red"><form:errors path="lastName"/></font></td>
</tr>


<tr>
    <td>User Name:</td>
    <td><form:input path="userAccount.userName" size="30" onkeypress="return acceptRegExOnly(event, /^[a-zA-Z0-9]$/);" /> <font color="red"><form:errors path="userAccount.userName"/></font></td>
</tr>
<tr>
    <td>Password:</td>
    <td><form:password path="userAccount.password" size="30" onkeypress="return acceptRegExOnly(event, /^[a-zA-Z0-9]$/);" /> <font color="red"><form:errors path="userAccount.password"/></font></td>
</tr>

 <tr>
    <td>Email Id:</td>
    <td><form:input  path="email" size="30" onkeypress="return acceptRegExOnly(event, /^[a-zA-Z0-9._@]$/);" /> <font color="red"><form:errors path="email"/></font></td>
</tr>

<tr>
    <td>Phone Number:</td>
    <td><form:input path="phoneNumber" size="30" onkeypress="return acceptRegExOnly(event, /^[0-9]$/);"/> <font color="red"><form:errors path="phoneNumber"/></font></td>
</tr>

<tr>
    <td colspan="2"><input type="submit" name="_eventId_next" value="Create User" /></td>
</tr>



</table>
<c:if test="${!empty requestScope.error}">
                <p style="color:red">Something went wrong!</p>
</c:if>
	
</form:form>



</c:otherwise>
</c:choose>  
	
	
	<div id="footer">
  <%@include file="/WEB-INF/resources/footer.jsp" %>
  </div>
	
</body>
</html>