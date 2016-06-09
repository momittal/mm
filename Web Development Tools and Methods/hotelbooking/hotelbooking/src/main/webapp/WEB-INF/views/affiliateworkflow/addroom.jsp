<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Room</title>
</head>
<body>



	<c:choose>
		<c:when test="${!empty sessionScope.user.userName}">
			<c:choose>
				<c:when test="${sessionScope.user.userRole =='user'}">
				You are not authorized to be here. <a href="/">Click Here to go to Home</a>
			</c:when>
				<c:when test="${sessionScope.user.userRole =='affiliate'}">
					<div id="navbar">
						<%@include file="/WEB-INF/resources/navbar.jsp"%>
					</div>
					<center>
						<h3>Add Room</h3>
					</center>

					<form action="" method="POST" enctype="multipart/form-data">
						<table>

							<tr>
								<td>Room Type</td>
								<td><select style="width: 150px;" name="roomtype">
										<option value="Single">Single</option>
										<option value="Double">Double</option>
										<option value="Family">Family</option>
										<option value="Suite">Suite</option>
										<option value="Twin">Twin</option>
										<option value="Triple">Triple</option>
								</select></td>
							</tr>

							

							<tr>
								<td>Price</td>
								<td><input type="text" name="rate" /></td>
							</tr>

							<tr>
								<td>Services</td>
								<td>AC in Room <input type='checkbox' name='services'
									value='acinroom' /> Refrigerator in Room <input
									type='checkbox' name='services' value='refrigeratorinroom' />
									Sound Proof <input type='checkbox' name='services'
									value='soundproof' /></td>
							</tr>

							<tr>
								<td>Photo (jpeg)</td>
								<td><input type="file" name="photo" /></td>
							</tr>

							<tr>
								<td colspan="2"><input type="submit" name="submit"
									value="Add Room" /></td>
							</tr>

						</table>
					</form>
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