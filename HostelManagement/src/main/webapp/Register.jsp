<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }

        header {
            background-color: #4CAF50;
            color: white;
            padding: 10px 0;
            text-align: center;
        }

        header nav ul {
            list-style-type: none;
            padding: 0;
        }

        header nav ul li {
            display: inline;
            margin: 0 15px;
        }

        header nav ul li a {
            color: white;
            text-decoration: none;
        }

        header nav ul li a:hover {
            text-decoration: underline;
        }

        .container {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            margin: auto;
        }

        h2 {
            text-align: center;
        }

        input[type="text"], input[type="email"], input[type="password"], input[type="tel"],
        input[type="date"], select {
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

        .role-selection {
            margin: 20px 0;
        }

        footer {
            text-align: center;
            margin-top: 20px;
            font-size: 0.9em;
        }
    </style>
</head>
<body>

    <header>
        <h1>Hostel Management System</h1>
        <nav>
            <ul>
                <li><a href="Index.jsp">Home</a></li>
                <li><a href="Login.jsp">Login</a></li>
               
            </ul>
        </nav>
    </header>

    <div class="container">
        <h2>User Registration</h2>
        
        <%
		// Display error messages if they exist
		String passErrorMessage = (String) request.getAttribute("passerrorMessage");
        String emailerrorMessage = (String) request.getAttribute("emailerrorMessage");

		if (passErrorMessage != null) {
		%>
		<div style="color: red; text-align: center;"><%=passErrorMessage%></div>
		<%
		}
		if (emailerrorMessage != null) {
			%>
			<div style="color: red; text-align: center;"><%=emailerrorMessage%></div>
			<%
			}
		%>
        <form action="RegisterService" method="post">
            <label for="f_name">First Name:</label>
            <input type="text" id="f_name" name="f_name" required>

            <label for="l_name">Last Name:</label>
            <input type="text" id="l_name" name="l_name" required>

            <label for="fathers_name">Father's Name:</label>
            <input type="text" id="fathers_name" name="fathers_name">

            <label for="mothers_name">Mother's Name:</label>
            <input type="text" id="mothers_name" name="mothers_name">

            <label for="contact_no">Contact Number:</label>
            <input type="tel" id="contact_no" name="contact_no" required>

            <label for="alternate_no">Alternate Number:</label>
            <input type="tel" id="alternate_no" name="alternate_no">

            <label for="occupation">Occupation:</label>
            <input type="text" id="occupation" name="occupation">

            <label for="permanent_address">Permanent Address:</label>
            <input type="text" id="permanent_address" name="permanent_address">

            <label for="local_address">Local Address:</label>
            <input type="text" id="local_address" name="local_address">

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="adhar_no">Aadhar Number:</label>
            <input type="text" id="adhar_no" name="adhar_no" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <label for="confimpassword">Confirm Password:</label>
            <input type="password" id="confimpassword" name="confimpassword" required>
            
             <label for="created_by">created_by</label>
            <input type="text" id="created_by" name="created_by" required>
            

            <label for="DOB">Date of Birth:</label>
            <input type="date" id="DOB" name="DOB" required>

            <label for="status">Status:</label>
            <select id="status" name="status" required>
                <option value="active">Active</option>
                <option value="inactive">Inactive</option>
            </select>

            <div class="role-selection">
                <label>Role:</label><br>
                <label>
                    <input type="radio" name="role" value="admin" required> Admin
                </label>
                <label>
                    <input type="radio" name="role" value="manager"> Manager
                </label>
                <label>
                    <input type="radio" name="role" value="staff"> Staff
                </label>
                <label>
                    <input type="radio" name="role" value="user"> User
                </label>
            </div>

            <input type="submit" value="Register">
        </form>
    </div>

    <footer>
        <p>&copy; 2024 Hostel Management System. All rights reserved.</p>
    </footer>

</body>
</html>
