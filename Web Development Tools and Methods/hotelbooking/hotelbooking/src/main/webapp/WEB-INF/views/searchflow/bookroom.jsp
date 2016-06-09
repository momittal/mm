<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Room</title>

</head>
<body>
		<div id="navbar">
			<%@include file="/WEB-INF/resources/navbar.jsp" %>
		</div>

	
	
	<div id="detailsofroom">
		You are booking<br/>
		<%@ include file="selectedroomdetails.jsp" %>
	</div>
	
	<form id="payment" action="" method="POST">
	<input type="hidden" name="selectedroomid" value="${requestScope.selectedRoom.roomId}"/>
	<input type="hidden" name="checkindate" value="${requestScope.checkinDate }"/>
	<input type="hidden" name="checkoutdate" value="${requestScope.checkoutDate }"/>
	<input type="hidden" name="city" value="${requestScope.city }"/>
	<input type="hidden" name="hotelname" value="${requestScope.hotelName }"/>
	<table>
	<tr>
	<td>Amount You Pay: </td>
	<td><input readonly type="text" name="amount" value="${requestScope.amount }" ><br/></td>
	</tr>
	<tr>
	<td>Card Number: </td>
	<td><input type="text" name="cardnumber" value="" maxlength="16" onkeypress="return acceptRegExOnly(event, /^[0-9]$/);"><br/></td>
	</tr>
	<tr>
	<td>Expire Date: (MMYYYY) </td>
	<td><input type="text" name="cardexpiredate" id="cardexpiredate" maxlength="6" onkeypress="return acceptRegExOnly(event, /^[0-9]$/);"/><br/></td>
	</tr>
	<tr>
	<td>CVV: </td>
	<td><input type="text" name="cvv" value="" maxlength="3" onkeypress="return acceptRegExOnly(event, /^[0-9]$/);"><br/></td>
	</tr>
	
	
	
	
	
	</table>
	
	

	<input type="submit" name="book" value="Book Room"/><br/>
	<c:if test="${!empty requestScope.errormsg}">
    	<p style="color:red">${requestScope.errormsg}</p>
    </c:if>
	</form>
	
	

<div id="footer">
	<%@include file="/WEB-INF/resources/footer.jsp" %>
</div>	


</body>
</html>