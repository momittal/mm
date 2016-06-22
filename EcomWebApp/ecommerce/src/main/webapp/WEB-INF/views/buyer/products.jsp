<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
	<div id="header">
		<%@include file="/resources/navbar.jsp"%>
	</div>
	<div class="content">
		${ requestScope.test}
		<ul class="products">
			<c:forEach var="product" items="${requestScope.allProducts}">
				<li><a href="productdetail?id=${product.id }"> <strong>${ product.title} </strong> 
						<br /> $${product.price }
				</a></li>
			</c:forEach>

		</ul>
	</div>

	<div id="footer">Footer</div>
</body>
</html>