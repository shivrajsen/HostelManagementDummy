<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 80%;
            margin: auto;
            overflow: hidden;
            padding: 20px;
            background: white;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .pay-button {
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        .pay-button:hover {
            background-color: #218838;
        }
        .video-container, .complete-container {
            display: none;
            text-align: center;
            margin-top: 20px;
        }
        .complete-container img {
            width: 200px;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Payment Confirmation</h1>
    <button>
			<a href="Rooms.jsp">Rooms</a>
		</button>
		<button>
			<a href="Home.jsp">Home</a>
		</button>
    <p>Your Total Payment Amount: ₹<%= request.getAttribute("paymentAmount") %></p>

    <form id="paymentForm" action="PayNowServlate" method="POST">
        <input type="hidden" name="roomNumber" value="<%= request.getAttribute("roomNumber") %>"/>
        <input type="hidden" name="upiId" value="<%= request.getAttribute("upiId") %>"/>
        <input type="hidden" name="cardType" value="<%= request.getAttribute("cardType") %>"/>
        <input type="hidden" name="bankName" value="<%= request.getAttribute("bankName") %>"/>
        <input type="hidden" name="roomtype" value="<%= request.getAttribute("roomtype") %>"/>
        <input type="hidden" name="cardNumber" value="<%= request.getAttribute("cardNumber") %>"/>
        <input type="hidden" name="candidate" value="<%= request.getAttribute("candidate") %>"/>
        <input type="hidden" name="viewType" value="<%= request.getAttribute("viewType") %>"/>
        <input type="hidden" name="roomviewType" value="<%= request.getAttribute("roomviewType") %>"/>
        <input type="hidden" name="paymentAmount" value="<%= request.getAttribute("paymentAmount") %>">
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <button type="submit" class="pay-button">Pay Now</button>
    </form>

    <div class="video-container" id="processing-video">
        <video width="400" autoplay loop muted>
            <source src="image/preview.mp4" type="video/mp4">
          
        </video>
        <p>Processing your payment, please wait...</p>
    </div>

    <div class="complete-container" id="completion-image">
        <img src="image/zzz.webp" alt="Payment Complete">
        <p>Your payment was successful!</p>
    </div>
</div>

<script>
    document.getElementById("paymentForm").addEventListener("submit", function(event) {
        event.preventDefault(); 
        document.getElementById("processing-video").style.display = "block";
        document.querySelector(".pay-button").style.display = "none"; 

        setTimeout(function() {
            document.getElementById("processing-video").style.display = "none"; 
            document.getElementById("completion-image").style.display = "block";
            
           
            document.getElementById("paymentForm").submit();
        }, 3000); 
    });
</script>

</body>
</html>
