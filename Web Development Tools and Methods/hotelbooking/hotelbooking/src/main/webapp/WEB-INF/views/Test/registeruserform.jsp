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
    
    
	<form:form action="registeruser.htm" commandName="user" method="post">

<table>
<tr>
    <td>First Name:</td>
    <td><form:input path="firstName" size="30" /> <font color="red"><form:errors path="firstName"/></font></td>
</tr>

<tr>
    <td>Last Name:</td>
    <td><form:input path="lastName" size="30" /> <font color="red"><form:errors path="lastName"/></font></td>
</tr>


<tr>
    <td>User Name:</td>
    <td><form:input path="userAccount.userName" size="30" /> <font color="red"><form:errors path="userAccount.userName"/></font></td>
</tr>

<tr>
    <td>Password:</td>
    <td><form:password path="userAccount.password" size="30" /> <font color="red"><form:errors path="userAccount.password"/></font></td>
</tr>

 <tr>
    <td>Email Id:</td>
    <td><form:input path="email" size="30" /> <font color="red"><form:errors path="email"/></font></td>
</tr>

<tr>
    <td>Phone Number:</td>
    <td><form:input path="phoneNumber" size="30" /> <font color="red"><form:errors path="phoneNumber"/></font></td>
</tr>  

<tr>
    <td colspan="2"><input type="submit" value="Create User" /></td>
</tr>
</table>
<c:if test="${!empty requestScope.error}">
                <p style="color:red"><font size="6">Handle Each Field Separately. Use of Ajax, to check for unique values</font></p>
            </c:if>
	
</form:form>
	<div id="footer">
  <%@include file="/WEB-INF/resources/footer.jsp" %>
  </div>
	
</body>
</html>