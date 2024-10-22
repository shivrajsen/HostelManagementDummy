<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>	
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hostel Management System</title>
    <link rel="stylesheet" href="styles.css"> <!-- Link to your CSS file -->
    <style> 
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        header {
            background: #35424a;
            color: #ffffff;
            padding: 10px 0;
            text-align: center;
        }
        .sub-header {
            background: #e0e0e0;
            color: #333;
            padding: 10px;
            text-align: center;
        }
        .nav-buttons {
            margin: 10px 0;
        }
        .button {
            display: inline-block;
            padding: 10px 15px;
            margin: 5px;
            background: #5cb85c;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background 0.3s;
        }
        .button:hover {
            background: #4cae4c;
        }
        footer {
            background: #35424a;
            color: #ffffff;
            text-align: center;
            padding: 10px 0;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background: #ffffff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>

<header>
    <h1>Hostel Management System</h1>
    <div class="nav-buttons">
        <a href="ViewRoom.jsp" class="button">View Room</a>
        <a href="ShowPaymentHistory.jsp" class="button">Payment History</a>
        <a href="Rooms.jsp" class="button">Rooms</a>
        <a href="AboutUs.jsp" class="button">AboutUS</a>
         <a href="Feedback.jsp" class="button">LogOut</a>
           <a href="FeedbackShow.jsp" class="button">Feedback Show</a>
        
    </div>
</header>

<div class="sub-header">
    <h2>Your Home Away From Home</h2>
    <p>Welcome to our hostel where comfort meets community. We provide safe accommodation with all necessary amenities.</p>
</div>
<div class="container">
    <h2>Welcome to the Hostel Management System</h2>
    <p>Our hostel is designed to provide a comfortable and secure living environment for students and working professionals. We offer a range of facilities to ensure a pleasant stay:</p>
    <ul>
        <li><strong>Comfortable Rooms:</strong> Well-furnished rooms with essential amenities.</li>
        <li><strong>24/7 Security:</strong> Ensuring safety with surveillance and on-site staff.</li>
        <li><strong>Free Wi-Fi:</strong> Stay connected with high-speed internet access.</li>
        <li><strong>Common Areas:</strong> Spacious lounges and study areas for relaxation and group activities.</li>
        <li><strong>Meal Services:</strong> Nutritious meals prepared with care, catering to diverse dietary needs.</li>
        <li><strong>Regular Maintenance:</strong> Prompt maintenance services to ensure a pleasant living experience.</li>
    </ul>
    <p>Join our community and experience the perfect blend of comfort and camaraderie!</p>
</div>


<footer>
    <p>&copy; 2024 Hostel Management System. All rights reserved.</p>
</footer>

</body>
</html>
