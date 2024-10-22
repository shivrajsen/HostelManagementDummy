
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hostel Management Center</title>
    <link rel="stylesheet" type="text/css" href="styles.css"> <!-- Link to your CSS file -->
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
          /*  background: url('image/Hos.jpeg') no-repeat center center fixed; /* Background image */
            background-size: cover; /* Cover the entire viewport */
            line-height: 1.6;
            display: flex;
            flex-direction: column;
            min-height: 100vh; /* Ensures footer is at the bottom */
        }

        header {
            background-color: rgba(0, 123, 255, 0.8); /* Semi-transparent header for better visibility */
            color: white;
            padding: 10px;
            text-align: left; /* Align text to the left */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        header h1 {
       
            margin-left: 300px;
            margin: 0;
            font-size: 2.em;
        }

        nav {
            margin-top: 10px;
        }

        nav ul {
            list-style-type: none;
            padding: 0;
            display: flex;
            justify-content: flex-start; /* Aligns buttons to the left */
        }

        nav ul li {
            margin: 0 20px;
        }

        nav a {
            color: white;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s;
            font-size: 1.2em;
        }

        nav a:hover {
            color: #ffcc00;
        }

        .content {
            max-width: 800px;
            margin: 30px auto;
            padding: 20px;
            background: rgba(255, 255, 255, 0.9); /* Semi-transparent white background */
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            flex-grow: 1; /* Allows the content to grow and take available space */
        }

        .content h2 {
            color: #007bff;
            margin-top: 0;
        }

        footer {
            text-align: center;
            padding: 20px;
            background-color: rgba(0, 123, 255, 0.8); /* Semi-transparent footer */
            color: white;
            margin-top: auto; /* Pushes footer to the bottom */
            box-shadow: 0 -2px 5px rgba(0, 0, 0, 0.1);
        }

        footer p {
            margin: 5px 0;
        }
    </style>
</head>
<body>

<header>
    <h1>Welcome to Hostel Management Center</h1>
    <nav>
        <ul>
            <li><a href="Login.jsp">Login</a></li>
            <li><a href="Register.jsp">Register</a></li>
        </ul>
    </nav>
</header>

<div class="content">
    <h2>Manage Your Hostel Experience</h2>
    	
    <p>At Hostel Management Center, we provide the tools and services to help you manage your hostel effectively.</p>
    <p>From student registrations to room allocations, we strive to create a seamless living experience for all residents.</p>
</div>

<footer>
    <p>&copy; 2024 Hostel Management Center. All rights reserved.</p>
    <p>Stay connected with us for the latest updates!</p>
</footer>

</body>
</html>
