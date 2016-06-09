<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Rooms</title>
</head>
<body>
	<div id="navbar">
		<%@include file="/WEB-INF/resources/navbar.jsp"%>
	</div>

	<table border="1">
		<tr>
			<th>Room Type</th>
			<th>Price</th>
			<th>Photo</th>
			<th>AC</th>
			<th>Refrigerator</th>
		</tr>
		<c:forEach items="${requestScope.rooms}" var="room">
			<tr>
				<td>${room.roomType }</td>
				<td>${room.rate }</td>
				<td><a target="new" href="${room.photo }"><img height="100"
						width="100" src="${room.photo }" /></a></td>
				<td><c:choose>
						<c:when test="${not room.service.acInRoom}">No</c:when>
						<c:otherwise>Yes</c:otherwise>
					</c:choose></td>
				<td><c:choose>
						<c:when test="${not room.service.refrigeratorInRoom}">No</c:when>
						<c:otherwise>Yes</c:otherwise>
					</c:choose></td>
			</tr>
		</c:forEach>
	</table>


	<div id="footer">
		<%@include file="/WEB-INF/resources/footer.jsp"%>
	</div>
</body>
</html>