<%@page import="co.hostelmanagement.admin.service.UserServiceGet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="co.hostelmanagement.dto.PayNowDTO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Records</title>
</head>
<body>
    <h1>Payment Records</h1>
        <button onclick="window.location.href='AdminHome.jsp'">Admin Home</button>
    <table border="1">
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
                UserServiceGet payNowService = new UserServiceGet();
                List<PayNowDTO> paymentList = payNowService.getAllPayments();
                for (PayNowDTO payment : paymentList) {
            %>
                <tr>
                    <td><%= payment.getRoom_number() %></td>
                    <td><%= payment.getBank_Name() %></td>
                    <td><%= payment.getCard_Type() %></td>
                    <td><%= payment.getCard_Number()%></td>
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
</body>
</html>
