<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-app="">
	<div id="navbar">
    	<%@include file="/WEB-INF/resources/navbar.jsp" %>
    </div>
    <form name="adminform" action="" method="post">
		
		<table>
		<tr>
		<td>Your First Name: </td>
		<td><input type='text' name='firstname' ng-model="firstname" required value='' onkeypress="return acceptRegExOnly(event, /^[a-zA-Z]$/);"/></td>
		<td><span style="color:red" ng-show="adminform.firstname.$touched && adminform.firstname.$invalid">Please Enter First Name</span></td>
		
		</tr>
		
		<tr>
		<td>Your Last Name: </td>
		<td><input type='text' name='lastname' ng-model="lastname" required value='' onkeypress="return acceptRegExOnly(event, /^[a-zA-Z]$/);"/></td>
		<td><span style="color:red" ng-show="adminform.lastname.$touched && adminform.lastname.$invalid">Please Enter Last Name</span></td>
		
		</tr>
		
		<tr>
		<td>Email: </td>
		<td><input type="email" name='email' ng-model="email" required value='' onkeypress="return acceptRegExOnly(event, /^[a-zA-Z0-9@._]$/);"/></td>
		<td><span style="color:red" ng-show="adminform.email.$touched && adminform.email.$invalid">Please Enter Valid Email id.</span></td>
		
		</tr>
		
		<tr>
		<td>Phone Number: </td>
		<td><input type='text' name='phonenumber' ng-model="phonenumber" required value='' onkeypress="return acceptRegExOnly(event, /^[0-9]$/);"/></td>
		<td><span style="color:red" ng-show="adminform.phonenumber.$touched && adminform.phonenumber.$invalid">Please Enter Phone Number</span></td>
		
		</tr>
		
		<tr>
		<td>Username: </td>
		<td><input type='text' name='username' ng-model="username" required value='' onkeypress="return acceptRegExOnly(event, /^[a-zA-Z0-9]$/);"/></td>
		<td><span style="color:red" ng-show="adminform.username.$touched && adminform.username.$invalid">Please Enter Desired Username</span></td>
		
		</tr>
		
		<tr>
		<td>Password: </td>
		<td><input type="password" name='password' ng-model="password" required value='' onkeypress="return acceptRegExOnly(event, /^[a-zA-Z0-9]$/);"/></td>
		<td><span style="color:red" ng-show="adminform.password.$touched && adminform.password.$invalid">Please Enter Password</span></td>
		
		</tr>

		</table>
		
		<input type='hidden' name='pagenum' value='2'/>
		<input type='hidden' name='hotelchainname' value='${requestScope.hotelchainname}'/>
		<input type='hidden' name='hotelname' value='${requestScope.hotelname}'/>
		<input type='hidden' name='addressline1' value='${requestScope.addressline1}'/>
		<input type='hidden' name='addressline2' value='${requestScope.addressline2}'/>
		<input type='hidden' name='city' value='${requestScope.city}'/>
		<input type='hidden' name='state' value='${requestScope.state}'/>
		<input type='hidden' name='country' value='${requestScope.country}'/>
		
		<input type='hidden' name='numofrooms' value='${requestScope.numofrooms}'/>
		<input type='hidden' name='numofhotels' value='${requestScope.numofhotels}'/>
		<input type='hidden' name='numofemployees' value='${requestScope.numofemployees}'/>
		<input type='hidden' name='zipcode' value='${requestScope.zipcode}'/>
		<input type='hidden' name='userrole' value='${requestScope.userrole}'/>
		
		
		
		<c:if test="${!empty requestScope.error}">
                <p style="color:red">Something Went Wrong </p>
        </c:if>
            
            
		<input type='submit' name='submit' value='Submit'/>

	</form>

	<div id="footer">
  		<%@include file="/WEB-INF/resources/footer.jsp" %>
  	</div>
  	
  	<noscript>
	JavaScript is turned off in your web browser. Please turn it on to register your hotel on the website, then refresh the page.
	</noscript>
</body>
</html>