<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        /* Header style */
        .header {
            background-color: green;
            color: white;
            padding: 15px;
            text-align: center;
        }

        .header h1 {
            margin: 0;
        }

        /* Navigation button styles */
        .nav {
            display: flex;
            justify-content: center;
            margin: 20px 0;
        }

        .nav button {
            background-color: #007BFF;
            color: white;
            border: none;
            padding: 15px 30px;
            margin: 0 10px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
        }

        .nav button:hover {
            background-color: #0056b3;
        }

        /* Footer style */
        .footer {
            background-color: green;
            color: white;
            text-align: center;
            padding: 15px;
            position: fixed;
            width: 100%;
            bottom: 0;
        }

        .footer a {
            color: white;
            text-decoration: none;
        }

        .footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <!-- Header Section -->
    <div class="header">
        <h1>Admin Dashboard</h1>
        <p>Welcome, Admin!</p>
    </div>

    <!-- Navigation Buttons -->
    <div class="nav">
        <button onclick="window.location.href='ShowFeedbackAdmin.jsp'">View Feedback</button>
        <button onclick="window.location.href='GetUser.jsp'">Manage Users</button>
        <button onclick="window.location.href='BookViewRoom.jsp'">View Booked Room</button>
        <button onclick="window.location.href='ViewRoom.jsp'">ViewRooms</button>
       <button onclick="window.location.href='Home.jsp'">User Home</button>
        <button onclick="window.location.href='PaymentGet.jsp'">Payment Check</button>
        
    </div>

    <!-- Footer Section -->
    <div class="footer">
        <p>&copy; 2024 Admin Portal. All Rights Reserved.</p>
        <p><a href="https://yourcompany.com">Visit Our Website</a></p>
    </div>

</body>
</html>
