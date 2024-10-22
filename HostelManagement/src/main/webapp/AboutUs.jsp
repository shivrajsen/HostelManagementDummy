<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us - Hostel</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 0 auto;
        }
        header {
            background-color: #007BFF;
            color: white;
            padding: 10px 0;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .logo {
            font-size: 24px;
            font-weight: bold;
            margin-left: 20px;
        }
        .buttons {
            margin-right: 20px;
        }
        .buttons button {
            background-color: white;
            color: #007BFF;
            border: 2px solid white;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            margin-left: 10px;
            transition: background-color 0.3s, color 0.3s;
        }
        .buttons button:hover {
            background-color: #0056b3;
            color: white;
        }
        section {
            background-color: white;
            padding: 20px;
            margin-top: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .content {
            text-align: left;
            line-height: 1.6;
        }
        footer {
            background-color: #007BFF;
            color: white;
            text-align: center;
            padding: 10px 0;
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <header>
        <div class="logo">COOL Hostel </div>
        <div class="buttons">
            <button onclick="window.location.href='Home.jsp'">Home</button>
            <button onclick="window.location.href='Contact.jsp'">Contact Us</button>
        </div>
    </header>

    <div class="container">
        <section>
            <h2>About Us</h2>
            <div class="content">
                <p>Located in the heart of the city, COOL Hostel offers a comfortable and affordable place to stay for travelers from around the world. Whether you're visiting for leisure, work, or study, we ensure a welcoming atmosphere that feels like home.</p>
                <p>Our hostel is designed to cater to all your needs, with spacious rooms, clean facilities, and friendly staff available 24/7. We also provide free Wi-Fi, communal kitchens, and shared lounges where guests can relax and interact with other travelers.</p>
            </div>
        </section>

        <section>
            <h2>Why Choose Us?</h2>
            <div class="content">
                <ul>
                    <li>Prime location close to public transport and major attractions</li>
                    <li>Affordable rates with various room options</li>
                    <li>Secure premises with round-the-clock surveillance</li>
                    <li>Friendly and helpful staff ready to assist</li>
                    <li>Clean and comfortable accommodations</li>
                </ul>
            </div>
        </section>

        <section>
            <h2>Contact Information</h2>
            <div class="content">
                <p><strong>Address:</strong> 123 COOL Hostel Street, City Center, Indore</p>
                <p><strong>Phone:</strong> +123 456 7890</p>
                <p><strong>Email:</strong> info@COOLhostel.com</p>
            </div>
        </section>
    </div>

    <footer>
        <p>&copy; 2024 COOL Hostel - All Rights Reserved</p>
    </footer>

</body>
</html>
