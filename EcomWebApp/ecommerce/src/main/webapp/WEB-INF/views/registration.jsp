<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
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
						<td><label>Username</label></td>
						<td><input type="text" name="username" placeholder="username" /></td>
					</tr>
					<tr>
						<td><label>Password</label></td>
						<td><input type="password" name="password"
							placeholder="password" /></td>
					</tr>
					<tr>
						<td><label>Confirm Password</label></td>
						<td><input type="password" name="confirmpassword"
							placeholder="re-enter password" /></td>
					</tr>
					<tr>
						<td><label>Name</label></td>
						<td><input type="text" name="name" placeholder="name" /></td>
					</tr>
					<tr>
						<td><label>Email</label></td>
						<td><input type="text" name="email" placeholder="email" /></td>
					</tr>
					<tr>
						<td><label>Address Line1</label></td>
						<td><input type="text" name="addressLine1"
							placeholder="address" /></td>
					</tr>
					<tr>
						<td><label>Address Line 2</label></td>
						<td><input type="text" name="adddressLine2"
							placeholder="address" /></td>
					</tr>
					<tr>
						<td><label>City</label></td>
						<td><input type="text" name="city" placeholder="city" /></td>
					</tr>
					<tr>
						<td><label>State</label></td>
						<td><input type="text" name="state" placeholder="state" /></td>
					</tr>
					<tr>
						<td><label>Country</label></td>
						<td><input type="text" name="country" placeholder="country" /></td>
					</tr>
					<tr>
						<td><label>Zipcode</label></td>
						<td><input type="text" name="zipcode" placeholder="zipcode" /></td>
					</tr>
					<tr>
						<td><label>Phone</label></td>
						<td><input type="text" name="phone" placeholder="phone" /></td>
					</tr>
					<tr>

						<td colspan="2"><input type="submit" name="submit"
							Value="Register" /></td>
					</tr>

				</table>

			</form>

		</div>
	</div>

	<div id="footer"><%@include file="/resources/footer.jsp"%></div>

</body>
</html>