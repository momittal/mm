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
    <form name="hotelform" action="" method="post">
		<input type='hidden' name='pagenum' value='1' />		

		<table>
		<tr>
		<td>Hotel Name: </td>
		<td><input type='text' name='hotelname' value='' ng-model="hotelname" required onkeypress="return acceptRegExOnly(event, /^[a-zA-Z0-9 ]$/);"/></td>
		<td><span style="color:red" ng-show="hotelform.hotelname.$touched && hotelform.hotelname.$invalid">Hotel name is required.</span></td>
		
		</tr>
		
		<tr>
		<td>Address Line 1: </td>
		<td><input type='text' name='addressline1' ng-model="addressline1" required value='' onkeypress="return acceptRegExOnly(event, /^[a-zA-Z0-9 ]$/);"/></td>
		<td><span style="color:red" ng-show="hotelform.addressline1.$touched && hotelform.addressline1.$invalid">Address Line 1 is required.</span></td>
		
		</tr>
		
		<tr>
		<td>Address Line 2: </td>
		<td><input type='text' name='addressline2' value='' onkeypress="return acceptRegExOnly(event, /^[a-zA-Z0-9 ]$/);"/></td>
		</tr>
		
		<tr>
		<td>Zipcode: </td>
		<td><input type='text' name='zipcode' ng-model="zipcode" required value='' onkeypress="return acceptRegExOnly(event, /^[0-9]$/);"/></td>
		<td><span style="color:red" ng-show="hotelform.zipcode.$touched && hotelform.zipcode.$invalid">Zipcode is required.</span></td>
		
		</tr>
		
		<tr>
		<td>City: </td>
		<td><input type='text' name='city' ng-model="city" required value='' onkeypress="return acceptRegExOnly(event, /^[a-zA-Z ]$/);"/></td>
		<td><span style="color:red" ng-show="hotelform.city.$touched && hotelform.city.$invalid">City is required.</span></td>
		
		</tr>
		
		<tr>
		<td>State: </td>
		<td><input type='text' name='state' ng-model="state" required value='' onkeypress="return acceptRegExOnly(event, /^[a-zA-Z ]$/);"/></td>
		<td><span style="color:red" ng-show="hotelform.state.$touched && hotelform.state.$invalid">State is required.</span></td>
		
		</tr>
		
		<tr>
		<td>Country: </td>
		<td><input type='text' name='country' ng-model="country" required value='' onkeypress="return acceptRegExOnly(event, /^[a-zA-Z ]$/);"/></td>
		<td><span style="color:red" ng-show="hotelform.country.$touched && hotelform.country.$invalid">Country is required.</span></td>
		
		</tr>
		
		</table>
		
		<c:if test="${!empty requestScope.error}">
                <p style="color:red">Please Enter Valid Data. No Special Characters are allowed. ZipCode only take integer input </p>
            </c:if>
            
            <c:if test="${!empty requestScope.errormsg}">
                <p style="color:red">${requestScope.errormsg}</p>
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