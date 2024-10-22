<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>User Login</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	margin: 0;
	padding: 20px;
}

.container {
	background-color: white;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	max-width: 400px;
	margin: auto;
}

h2 {
	text-align: center;
}

input[type="text"], input[type="password"], input[type="email"] {
	width: 100%;
	padding: 10px;
	margin: 8px 0;
	border: 1px solid #ccc;
	border-radius: 4px;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px 15px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	width: 100%;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

.forgot-password {
	text-align: center;
	margin-top: 10px;
}

.forgot-password a {
	color: #4CAF50;
	text-decoration: none;
}

.forgot-password a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>

	<div class="container">
		<h2>User Login</h2>


		<li><a href="Register.jsp">Register</a></li>
		<li><a href="Index.jsp">Index</a></li>

		<%
		// Display error messages if they exist
		String emailErrorMessage = (String) request.getAttribute("error");
		String success = (String) request.getAttribute("Success");

		if (emailErrorMessage != null) {
		%>
		<div style="color: red; text-align: center;"><%=emailErrorMessage%></div>
		<%
		}
		if (success != null) {
			%>
			<div style="color: red; text-align: center;"><%=success%></div>
			<%
		}
		%>
		<form action="LoginService" method="post">
			<label for="email">Email:</label> <input type="email" id="email"
				name="email" required> <label for="password">Password:</label>
			<input type="password" id="password" name="password" required>

			<input type="submit" value="Login">
		</form>
		<div class="forgot-password">
			<p>
				<a href="ForgetPassword.jsp">Forgot Password?</a>
			</p>
		</div>
	</div>

</body>
</html>
