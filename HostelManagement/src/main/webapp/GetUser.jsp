<%@page import="co.hostelmanagement.admin.service.UserServiceGet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="co.hostelmanagement.dto.UserDTO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registered Users</title>
</head>
<body>
    <h1>Registered Users</h1>
        <button onclick="window.location.href='AdminHome.jsp'">Admin Home</button>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Occupation</th>
                <th>Contact No</th>
                <th>Status</th>
                <th>Created By</th>
                <th>Role ID</th>
            </tr>
        </thead>
        <tbody>
            <%
                UserServiceGet userService = new UserServiceGet();
                List<UserDTO> userList = userService.getAllUsers();
                for (UserDTO user : userList) {
            %>
                <tr>
                    <td><%= user.getId() %></td>
                    <td><%= user.getF_Name() %></td>
                    <td><%= user.getL_Name() %></td>
                    <td><%= user.getEmail() %></td>
                    <td><%= user.getOccupation() %></td>
                    <td><%= user.getContect_no() %></td>
                    <td><%= user.getStatus() %></td>
                    <td><%= user.getCreated_by() %></td>
                     <td><%= user.getRole_id() %></td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
