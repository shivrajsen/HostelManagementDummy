<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password</title>
    <link rel="stylesheet" href="styles.css"> <!-- Link to your CSS file -->
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            max-width: 400px;
            padding: 20px;
            background: #ffffff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .button {
            width: 100%;
            padding: 10px;
            background: #5cb85c;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background 0.3s;
        }
        .button:hover {
            background: #4cae4c;
        }
        .message {
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Reset Password</h2>
    
    <button><a href="Login.jsp">Login </a></button>
    <% 
    String error = (String) request.getAttribute("passerrorMessage");
    String error1 = (String) request.getAttribute("error1");


		
		if (error != null) {
			%>
			<div style="color: red; text-align: center;"><%=error%></div>
			<%
		}
		if (error1 != null) {
			%>
			<div style="color: red; text-align: center;"><%=error1%></div>
			<%
		}
		%>
    <form action="ForgotPassService" method="post">
        <label for="email">Email Address:</label>
        <input type="email" id="email" name="email" required>
        
        <label for="password">New Password:</label>
        <input type="password" id="password" name="password" required>
        
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required>
        
        <button type="submit" class="button">Reset Password</button>
    </form>
    <div class="message">
        <p>Please enter your email and new password.</p>
    </div>
</div>

</body>
</html>
