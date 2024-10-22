<%@page import="co.hostelmanagement.dto.RoomDTO"%>
<%@page import="co.hostelmanagement.admin.service.UserServiceGet"%>
<%@ page import="java.util.List" %>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Available Rooms</title>
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
    <h1>Available Rooms</h1>
     <button onclick="window.location.href='AdminHome.jsp'">Admin Home</button>
    <table>
        <thead>
            <tr>
                <th>Room Number</th>
                <th>Room Type</th>
                <th>View</th>
                <th>Is Booked</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Retrieve all available rooms
                List<RoomDTO> availableRooms = UserServiceGet.getAllBookRoom();
                
                if (availableRooms != null && !availableRooms.isEmpty()) {
                    for (RoomDTO room : availableRooms) {
            %>
                <tr>
                    <td><%= room.getRoom_number() %></td>
                    <td><%= room.getRoomType() %></td>
                    <td><%= room.getView() %></td>
                    <td><%= room.isBooked() ? "Yes" : "No" %></td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="4" style="text-align:center;">No available rooms.</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
