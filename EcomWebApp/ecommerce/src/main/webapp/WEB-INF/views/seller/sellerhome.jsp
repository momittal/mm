<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="header">
		<%@include file="/resources/navbar.jsp"%>
	</div>
	<div class="content">
			<h1>Welcome ${sessionScope.user.username}</h1>
			Seller Landing Page 
			<br /> <a href="addproduct">Add Product</a>
			<br /> <a href="viewproducts">View Product</a>
		
	</div>

	<div id="footer"><%@include file="/resources/footer.jsp"%></div>

</body>
</html>