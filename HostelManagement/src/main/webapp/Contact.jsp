<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact Us - A Cool Hostel</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        /* Header styles */
        header {
            background-color: #007bff;
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
        .contact-info {
            margin-bottom: 20px;
        }
        .contact-info h3 {
            margin-top: 10px;
            color: #555;
        }
        .contact-info p {
            line-height: 1.6;
        }

        /* Contact form styles */
        .contact-form {
            margin-top: 20px;
        }
        .contact-form input, .contact-form textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .contact-form input[type="submit"] {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }
        .contact-form input[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* Footer styles */
        footer {
            background-color: #007bff;
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
            <button onclick="location.href='AboutUs.jsp'">About Us</button>
        </div>
        <div class="header-title">
            A Cool Hostel
        </div>
    </header>

    <!-- Main content section -->
    <div class="container">
        <h1>Contact Us - A Cool Hostel</h1>
        <div class="contact-info">
            <h3>Hostel Address:</h3>
            <p>
                A Cool Hostel<br>
                123 Freedom Road,<br>
                Cityville, State 456789<br>
                Country: India<br>
            </p>
            
            <h3>Contact Details:</h3>
            <p>
                Phone: +123-456-7890<br>
                Email: info@acoolhostel.com
            </p>
        </div>

        <h3>Get in Touch with Us:</h3>
        <div class="contact-form">
            <form action="submitContact.jsp" method="post">
                <label for="name">Your Name:</label>
                <input type="text" id="name" name="name" required>

                <label for="email">Your Email:</label>
                <input type="email" id="email" name="email" required>

                <label for="message">Your Message:</label>
                <textarea id="message" name="message" rows="5" required></textarea>

                <input type="submit" value="Send Message">
            </form>
        </div>
    </div>

    <!-- Footer section -->
    <footer>
        &copy; 2024 A Cool Hostel. All rights reserved.
    </footer>

</body>
</html>
