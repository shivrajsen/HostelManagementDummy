<%@page import="co.hostelmanagement.dto.PayNowDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="co.hostelmanagement.dto.PaymentDTO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment History</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h1>Enter Room Number and Password to View Payment History</h1>
<button>
			<a href="Rooms.jsp">Rooms</a>
		</button>
		<button>
			<a href="Home.jsp">Home</a>
		</button>
    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        List<PayNowDTO> paymentList = (List<PayNowDTO>) request.getAttribute("paymentList");
    %>

    <% if (errorMessage != null) { %>
        <p class="error"><%= errorMessage %></p>
    <% } %>

    <form action="ShowPaymentHitory" method="POST">
    <button>
			<a href="Rooms.jsp">Rooms</a>
		</button>
		<button>
			<a href="Home.jsp">Home</a>
		</button>
        <label for="roomNumber">Room Number:</label>
        <input type="number" id="roomNumber" name="roomNumber" required>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <button type="submit">Submit</button>
    </form>

    <% if (paymentList != null && !paymentList.isEmpty()) { %>
        <h2>Payment History</h2>
        <table>
            <thead>
                <tr>
                    <th>Room Number</th>
                    <th>Bank Name</th>
                    <th>Card Type</th>
                    <th>Card Number</th>
                    <th>UPI ID</th>
                    <th>Payment Amount</th>
                    <th>Candidate</th>
                    <th>View Type</th>
                    <th>Room View Type</th>
                    <th>Bill Type</th>
                    <th>Transaction ID</th>
                    <th>Created Date</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (PayNowDTO payment : paymentList) {
                %>
                    <tr>
                        <td><%= payment.getRoom_number() %></td>
                        <td><%= payment.getBank_Name() %></td>
                        <td><%= payment.getCard_Type()%></td>
                        <td><%= payment.getCard_Number() %></td>
                        <td><%= payment.getUpi_Id() %></td>
                        <td><%= payment.getPaymentAmount() %></td>
                        <td><%= payment.getCandidate() %></td>
                        <td><%= payment.getViewType() %></td>
                        <td><%= payment.getRoomviewType() %></td>
                        <td><%= payment.getBillType() %></td>
                        <td><%= payment.getTransactionId() %></td>
                        <td><%= payment.getCreatedDate() %></td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    <% } %>
</body>
</html>
