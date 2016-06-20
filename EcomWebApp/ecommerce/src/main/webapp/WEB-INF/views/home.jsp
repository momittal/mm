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

		<div id="form">
			<form method="post" action="login">
				<table>
					<tr>
						<td><label>Username: </label></td>
						<td><input type="text" name="username" placeholder="username" /></td>
					</tr>
					<tr>
						<td><label>Password: </label></td>
						<td><input type="password" name="password"
							placeholder="password" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" name="Login" /></td>
					</tr>
				</table>
			</form>
		</div>

	</div>

	<div id="footer"><%@include file="/resources/footer.jsp"%></div>
</body>
</html>