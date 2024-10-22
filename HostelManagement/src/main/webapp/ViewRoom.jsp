<%@page import="co.hostelmanagement.dto.RoomDTO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Room Information</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	color: #333;
	line-height: 1.6;
}

header {
	background-color: #333;
	color: #fff;
	padding: 15px;
	text-align: center;
}

header h1 {
	margin: 0;
	font-size: 24px;
}

header button {
	margin-top: 10px;
	padding: 10px 15px;
	background-color: #28a745;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

header button a {
	color: white;
	text-decoration: none;
}

main {
	width: 80%;
	margin: 30px auto;
	background: #fff;
	padding: 20px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

th, td {
	padding: 10px;
	border: 1px solid #ddd;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}
</style>
</head>
<body>

	<header>
		<h1>Room Information</h1>
		<button>
			<a href="Rooms.jsp">Rooms</a>
		</button>
		<button>
			<a href="Home.jsp">Home</a>
		</button>
	</header>

	<main>
		<h2>Available Rooms</h2>

		<form action="ViewRoomService" method="post">
			<button type="submit">Refresh Room List</button>
		</form>

		<table>
			<thead>
				<tr>
					<th>Room Number</th>
					<th>Room Type</th>
					<th>View</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<RoomDTO> roomList = (List<RoomDTO>) request.getAttribute("roomList");
				//List<RoomDTO> roomList1 = (List<RoomDTO>) request.getAttribute("bookRoomNumbers");
				if (roomList != null && !roomList.isEmpty()) {
					for (RoomDTO room : roomList) {
				%>
				<tr>
					<td><%=room.getRoom_number()%></td>
					<td><%=room.getRoomType()%></td>
					<td><%=room.getView()%></td>
					<td><%=room.isBooked() ? "Booked" : "Available"%></td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="4">No rooms available.</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>

</body>
</html>
