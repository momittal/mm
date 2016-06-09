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
    
    
  
	<form action="loginuser.htm" method="post">

<table>

<tr>
    <td>User Name:</td>
    <td><input type="text" name="username" size="30" /></td>
</tr>

<tr>
    <td>Password:</td>
    <td><input type="password" name="password" size="30" /></td>
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