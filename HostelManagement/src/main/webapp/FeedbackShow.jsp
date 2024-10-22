<%@page import="co.hostelmanagement.dto.FeedbackDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Feedback Details</title>
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
    </style>
</head>
<body>
    <h2>Feedback Details</h2>
    <button>
			<a href="Home.jsp">Home</a>
		</button>
		<form action="FeedbackShowService" method="post">
			<button type="submit">Click me</button>
		</form>
    
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Experience</th>
                <th>Rating</th>
                <th>Comments</th>
                <th>Date Submitted</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<FeedbackDTO> feedbackList = (List<FeedbackDTO>) request.getAttribute("feedbackList");
                if (feedbackList != null) {
                    for (FeedbackDTO feedback : feedbackList) {
            %>
            <tr>
                <td><%= feedback.getName() %></td>
                <td><%= feedback.getEmail() %></td>
                <td><%= feedback.getExperience() %></td>
                <td><%= feedback.getRating() %></td>
                <td><%= feedback.getComments() %></td>
                <td><%= feedback.getCreatedDate()%></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="6">No feedback found.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

</body>
</html>
