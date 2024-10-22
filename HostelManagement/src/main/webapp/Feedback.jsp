<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Feedback - A Cool Hostel</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        /* Header styles */
        header {
            background-color: green;
            color: white;
            padding: 10px 0;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header-left {
            display: flex;
            align-items: center;
            margin-left: 20px;
        }
        .header-left button {
            background-color: white;
            color: #007bff;
            border: none;
            padding: 10px 20px;
            margin-right: 10px;
            cursor: pointer;
            font-size: 14px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .header-left button:hover {
            background-color: #0056b3;
            color: white;
        }
        .header-title {
            font-size: 24px;
            margin-right: 20px;
        }

        /* Main container */
        .container {
            width: 60%;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
        }

        .feedback-form input, .feedback-form textarea, .feedback-form select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .feedback-form input[type="submit"] {
            background-color: gray;
            color: white;
            border: none;
            cursor: pointer;
        }

        .feedback-form input[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* Rating section styles */
        .rating {
            margin-bottom: 10px;
        }

        /* Footer styles */
        footer {
            background-color: green;
            color: white;
            text-align: center;
            padding: 15px 0;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>
<body>

    <!-- Header section -->
    <header>
        <div class="header-left">
            <button onclick="location.href='Home.jsp'">Home</button>
           
        </div>
        <div class="header-title">
            A Cool Hostel - Feedback
        </div>
    </header>

    <!-- Main content section -->
    <div class="container">
        <h1>We value your feedback!</h1>
        <p>Please take a moment to provide feedback about your stay at A Cool Hostel. Your opinion helps us improve our services.</p>
<%
		
		
		String error = (String) request.getAttribute("error");
		//String errorMessage = (String) request.getAttribute("errorMessage");
		if (error != null) {
			%>
			<div style="color: red; text-align: center;"><%=error%></div>
			<%
			}
		
		%>
        <div class="feedback-form">
            <form action="FeedbackService" method="post">
                <label for="name">Your Name:</label>
                <input type="text" id="name" name="name" required>

                <label for="email">Your Email:</label>
                <input type="email" id="email" name="email" required>

                <label for="experience">How was your overall experience?</label>
                <select id="experience" name="experience" required>
                    <option value="excellent">Excellent</option>
                    <option value="good">Good</option>
                    <option value="average">Average</option>
                    <option value="poor">Poor</option>
                </select>

                <label>Rate your stay (1-5):</label>
                <div class="rating">
                    <input type="radio" id="rating1" name="rating" value="1" required>
                    <label for="rating1">1</label>
                    <input type="radio" id="rating2" name="rating" value="2">
                    <label for="rating2">2</label>
                    <input type="radio" id="rating3" name="rating" value="3">
                    <label for="rating3">3</label>
                    <input type="radio" id="rating4" name="rating" value="4">
                    <label for="rating4">4</label>
                    <input type="radio" id="rating5" name="rating" value="5">
                    <label for="rating5">5</label>
                </div>

                <label for="comments">Any suggestions or feedback?</label>
                <textarea id="comments" name="comments" rows="5" required></textarea>

                <input type="submit" value="Submit Feedback">
            </form>
        </div>
    </div>

    <!-- Footer section -->
    <footer>
        &copy; 2024 A Cool Hostel. All rights reserved.
    </footer>

</body>
</html>
