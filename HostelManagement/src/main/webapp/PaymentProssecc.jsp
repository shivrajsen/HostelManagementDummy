<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Page</title>
    <link rel="stylesheet" href="styles.css"> <!-- Optional CSS file -->
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f8f8f8;
        }
        header {
            background-color: #4CAF50;
            color: white;
            padding: 15px;
            text-align: center;
        }
        footer {
            background-color: #4CAF50;
            color: white;
            text-align: center;
            padding: 10px;
            position: relative;
            bottom: 0;
            width: 100%;
        }
        .container {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: 20px auto;
        }
        h2 {
            text-align: center;
        }
        .form-group {
            margin: 15px 0;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        select, input[type="text"], input[type="number"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<header>
    <h1>Payment Portal</h1>
</header>

<div class="container">
    <h2>Complete Your Payment</h2>
   
		<button>
			<a href="Home.jsp">Home</a>
		</button>
    
    
    
		<%
		// Display error messages if they exist
		
		String errorMessage1 = (String) request.getAttribute("errorMessage1");
		String errorMessage = (String) request.getAttribute("errorMessage");
		String errorMessage2 = (String) request.getAttribute("errorMessage2");
		String errorMessage3 = (String) request.getAttribute("errorMessage3");
		String errorMessage4 = (String) request.getAttribute("errorMessage4");
		String errorMessage5 = (String) request.getAttribute("errorMessage5");
		String errorMessage6 = (String) request.getAttribute("errorMessage6");
		String errorMessage7 = (String) request.getAttribute("errorMessage7");
		String errorMessage8 = (String) request.getAttribute("errorMessage8");

		
		if (errorMessage != null) {
		%>
		<div style="color: red; text-align: center;"><%=errorMessage%></div>
		<%
		}
	
		if (errorMessage1 != null) {
		%>
		<div style="color: red; text-align: center;"><%=errorMessage1%></div>
		<%
		}
		
		if (errorMessage2 != null) {
			%>
			<div style="color: red; text-align: center;"><%=errorMessage2%></div>
			<%
			}
			
			
		if (errorMessage3 != null) {
			%>
			<div style="color: red; text-align: center;"><%=errorMessage3%></div>
			<%
			}
			
			
		if (errorMessage4 != null) {
			%>
			<div style="color: red; text-align: center;"><%=errorMessage4%></div>
			<%
			}
			
			
		if (errorMessage5 != null) {
			%>
			<div style="color: red; text-align: center;"><%=errorMessage5%></div>
			<%
			}
			
			
		if (errorMessage6 != null) {
			%>
			<div style="color: red; text-align: center;"><%=errorMessage6%></div>
			<%
			}
			
			
		if (errorMessage7 != null) {
			%>
			<div style="color: red; text-align: center;"><%=errorMessage7%></div>
			<%
			}
			
			
		if (errorMessage8 != null) {
			%>
			<div style="color: red; text-align: center;"><%=errorMessage8%></div>
			<%
			}
			
			
		
			
			
		%>
    
    <form action="PaymentService" method="POST">
        <!-- Hidden field to hold the room number -->
        <input type="hidden" name="roomNumber" value="<%= request.getAttribute("roomNumber") %>"/>
         <input type="hidden" name="candidate" value="<%= request.getAttribute("candidate") %>"/>
          <input type="hidden" name="viewType" value="<%= request.getAttribute("viewType") %>"/>
           <input type="hidden" name="roomviewType" value="<%= request.getAttribute("roomviewType") %>"/>
            <input type="hidden" name="roomtype" value="<%= request.getAttribute("roomtype") %>"/>
        
        <div class="form-group">
            <label for="bankName">Bank Name:</label>
            <select id="bankName" name="bankName" required>
                <option value="" disabled selected>Select your bank</option>
                <option value="SBI Bank">SBI Bank </option>
                <option value="HDFC Bank">HDFC Bank </option>
                <option value="KOTAK MAHINDRA Bank">Kotak Mahindra Bank</option>
                <option value="ICIC Bank">ICIC Bank</option>
                <option value="IDFC Bank">IDFC Bank</option>
            </select>
        </div>
        <div class="form-group">
            <label for="cardType">Card Type:</label>
            <select id="cardType" name="cardType" required>
                <option value="" disabled selected>Select card type</option>
                <option value="Credit Card">Credit Card</option>
                <option value="Debit Card">Debit Card</option>
            </select>
        </div>
        <div class="form-group">
            <label for="cardNumber">Card Number:</label>
            <input type="number" id="cardNumber" name="cardNumber" required>
        </div>
        <div class="form-group">
            <label for="upiId">UPI ID:</label>
            <input type="text" id="upiId" name="upiId">
        </div>
        <button type="submit">Make Payment</button>
    </form>
</div>

<footer>
    <p>&copy; 2024 Your Company Name</p>
</footer>

</body>
</html>
