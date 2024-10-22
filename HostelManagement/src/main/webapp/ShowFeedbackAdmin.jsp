<%@page import="co.hostelmanagement.admin.service.UserServiceGet"%>
<%@page import="co.hostelmanagement.controller.AdminController"%>
<%@page import="co.hostelmanagement.dto.FeedbackDTO"%>
<%@ page import="java.util.List" %>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Feedback Records</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Feedback Records</h1>
        <button onclick="window.location.href='AdminHome.jsp'">Admin Home</button>
    
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Experience</th>
                <th>Rating</th>
                <th>Comments</th>
                <th>Created Date</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Retrieve all feedback records
                List<FeedbackDTO> feedbackList = UserServiceGet.getAllFeedback();
                
                if (feedbackList != null && !feedbackList.isEmpty()) {
                    for (FeedbackDTO feedback : feedbackList) {
            %>
                <tr>
                    <td><%= feedback.getName() %></td>
                    <td><%= feedback.getEmail() %></td>
                    <td><%= feedback.getExperience() %></td>
                    <td><%= feedback.getRating() %></td>
                    <td><%= feedback.getComments() %></td>
                    <td><%= feedback.getCreatedDate() != null ? feedback.getCreatedDate().toString() : "" %></td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="6" style="text-align:center;">No feedback available.</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
