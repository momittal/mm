<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<div id="header">
		<%@include file="/resources/navbar.jsp"%>
	</div>
	<div class="content">

		<div id="form">
			<form method="post" action="">
				<table>
					<tr>
						<td><label>Title</label></td>
						<td><input type="text" name="title" placeholder="Product Title"/></td>
					</tr>
					<tr>
						<td><label>Category</label></td>
						<td><Select name="category">
							<option value="Laptop">Laptop</option>
						</Select></td>
					</tr>
					<tr>
					<td><label>Description</label></td>
					<td><textarea rows="5" cols="20" name ="description"></textarea></td>
					</tr>
					<tr>
					<td><label>Quantity</label></td>
					<td><input type="text" name="quantity" placeholder="quantity"/></td>
					</tr>
					<tr>
					<td><label>Price</label></td>
					<td><input type="text" name="price" placeholder="price"/></td>
					</tr>
					
					<tr>
						<td colspan="2"><input type="submit" name="Add Product" /></td>
					</tr>
				</table>
			</form>
		</div>

	</div>

	<div id="footer"><%@include file="/resources/footer.jsp"%></div>
</body>
</body>
</html>