<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hostel Room Booking Form</title>
<style>
/* General reset and layout */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	color: #333;
	line-height: 1.6;
}

header {
	background-color: #333;
	color: #fff;
	padding: 15px 0;
	text-align: center;
}

header h1 {
	margin: 0;
	font-size: 24px;
}

main {
	width: 80%;
	max-width: 600px; /* Added max-width for better control */
	margin: 30px auto;
	background: #fff;
	padding: 30px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
}

.form-group {
	margin-bottom: 20px;
}

.form-group label {
	display: block;
	font-weight: bold;
	margin-bottom: 8px;
}

.form-group input, .form-group select {
	width: 100%; /* Full width */
	max-width: 300px; /* Limit the maximum width */
	padding: 10px;
	font-size: 15px;
	border: 1px solid #ccc;
	border-radius: 5px;
	transition: border-color 0.3s ease;
}

.form-group input[type="radio"], .form-group input[type="number"] {
	width: auto; /* Keep radio buttons and number inputs smaller */
}

.form-group input:focus {
	border-color: #28a745;
}

.form-group input[type="submit"] {
	background-color: #28a745;
	color: #fff;
	border: none;
	cursor: pointer;
	padding: 12px 30px;
	font-size: 16px;
	border-radius: 5px;
	transition: background-color 0.3s ease;
	width: auto; /* Reset width for the submit button */
}

.form-group input[type="submit"]:hover {
	background-color: #218838;
}

footer {
	background-color: #333;
	color: #fff;
	text-align: center;
	padding: 15px 0;
}
</style>

</head>
<body>

	<!-- Header Section -->
	<header>
		<h1>Hostel Room Booking Form</h1>
		<button>
			<a href="Home.jsp">Home</a>
		</button>
	</header>

	<!-- Main Content Section -->
	<main>

		<%
		// Display error messages if they exist
		String errorMessagephone = (String) request.getAttribute("errorMessagephone");
		String errorcandidate = (String) request.getAttribute("errorcandidate");
		String roomsError = (String) request.getAttribute("roomsError");
		String success = (String) request.getAttribute("errorDate");
		String errorprivate = (String) request.getAttribute("errorprivate");
		String errorMessage = (String) request.getAttribute("errorMessage");
		String bookingError = (String) request.getAttribute("bookingError");
		String bookingError1 = (String) request.getAttribute("bookingError1");

		if (bookingError1 != null) {
			%>
			<div style="color: red; text-align: center;"><%=bookingError1%></div>
			<%
			}
		if (bookingError != null) {
		%>
		<div style="color: red; text-align: center;"><%=bookingError%></div>
		<%
		}
		if (errorMessage != null) {
		%>
		<div style="color: red; text-align: center;"><%=errorMessage%></div>
		<%
		}
		if (errorMessagephone != null) {
		%>
		<div style="color: red; text-align: center;"><%=errorMessagephone%></div>
		<%
		}
		if (errorcandidate != null) {
		%>
		<div style="color: red; text-align: center;"><%=errorcandidate%></div>
		<%
		}
		if (roomsError != null) {
		%>
		<div style="color: red; text-align: center;"><%=roomsError%></div>
		<%
		}
		if (success != null) {
		%>
		<div style="color: red; text-align: center;"><%=success%></div>
		<%
		}
		if (errorprivate != null) {
		%>
		<div style="color: red; text-align: center;"><%=errorprivate%></div>
		<%
		}
		%>


		<form action="RoomsService" method="post">

			<p>check room for Avalable</p>
			<button>
				<a href="ViewRoom.jsp" class="button">View Room</a>
			</button>

			<!-- Field 1: Candidate's Full Name -->
			<div class="form-group">
				<label for="fullName">Full Name:</label> <input type="text"
					id="fullName" name="fullName" placeholder="Enter your full name"
					required>
			</div>

			<!-- Field 2: Contact Information -->
			<div class="form-group">
				<label for="contact">Phone Number:</label> <input type="tel"
					id="contact" name="contact" placeholder="Enter your phone number"
					required>
			</div>

			<!-- Field 3: Room Type with Radio Buttons -->
			<div class="form-group">
				<label for="roomType">Room Type:</label> <input type="radio"
					id="roomTypePrivate" name="roomType" value="Private" required>
				Private Room <input type="radio" id="roomTypeShared" name="roomType"
					value="Shared" required> Shared Room
			</div>

			<!-- Field 4: Number of Rooms -->

			<div class="form-group">
				<label for="roomNumber">Select Room Number:</label> <select
					id="roomNumber" name="roomNumber" required>
					<optgroup label="First Floor">
						<option value="101">101</option>
						<option value="102">102</option>
						<option value="103">103</option>
						<option value="104">104</option>
						<option value="105">105</option>
						<option value="106">106</option>
						<option value="107">107</option>
						<option value="108">108</option>
						<option value="109">109</option>
						<option value="110">110</option>
					</optgroup>
					<optgroup label="Second Floor">
						<option value="201">201</option>
						<option value="202">202</option>
						<option value="203">203</option>
						<option value="204">204</option>
						<option value="205">205</option>
						<option value="206">206</option>
						<option value="207">207</option>
						<option value="208">208</option>
						<option value="209">209</option>
						<option value="210">210</option>
					</optgroup>
					<optgroup label="Third Floor">
						<option value="301">301</option>
						<option value="302">302</option>
						<option value="303">303</option>
						<option value="304">304</option>
						<option value="305">305</option>
						<option value="306">306</option>
						<option value="307">307</option>
						<option value="308">308</option>
						<option value="309">309</option>
						<option value="310">310</option>
					</optgroup>
					<optgroup label="Fourth Floor">
						<option value="401">401</option>
						<option value="402">402</option>
						<option value="403">403</option>
						<option value="404">404</option>
						<option value="405">405</option>
						<option value="406">406</option>
						<option value="407">407</option>
						<option value="408">408</option>
						<option value="409">409</option>
						<option value="410">410</option>
					</optgroup>
					<optgroup label="Fifth Floor">
						<option value="501">501</option>
						<option value="502">502</option>
						<option value="503">503</option>
						<option value="504">504</option>
						<option value="505">505</option>
						<option value="506">506</option>
						<option value="507">507</option>
						<option value="508">508</option>
						<option value="509">509</option>
						<option value="510">510</option>
					</optgroup>
				</select>
			</div>


			<!-- Field 5: Number of Candidates -->
			<div class="form-group">
				<label for="numRooms">Number of Candidates:</label> <input
					type="number" id="numRooms" name="cndidate" required min="1">
			</div>

			<!-- Field 6: View Type with Radio Buttons -->
			<div class="form-group">
				<label for="viewType">Room View Type:</label> <input type="radio"
					id="viewTypeCity" name="viewType" value="City" required>
				City View <input type="radio" id="viewTypeGarden" name="viewType"
					value="Garden" required> Garden View <input type="radio"
					id="viewTypeNone" name="viewType" value="None" required>
				None View

			</div>
			<div class="form-group">
				<label for="viewType">Room View Type:</label> <input type="radio"
					id="viewTypeCity" name="roomviewType" value="AC" required>
				AC Room <input type="radio" id="viewTypeGarden" name="roomviewType"
					value="NON-AC" required> NON-AC Room
					<input type="radio" id="viewTypeGarden" name="roomviewType"
					value="None" required> None
			</div>

			<!-- Field 7: Check-in and Check-out Dates -->
			<div class="form-group">
				<label for="checkinDate">Check-in Date:</label> <input type="date"
					id="checkinDate" name="checkinDate" required>
			</div>

			<div class="form-group">
				<label for="checkoutDate">Check-out Date:</label> <input type="date"
					id="checkoutDate" name="checkoutDate" required>
			</div>

			<!-- Submit Button -->
			<div class="form-group">
				<input type="submit" value="Book Room">
			</div>
		</form>
	</main>

	<!-- Footer Section -->
	<footer>
		<p>&copy; 2024 Hostel Management System. All Rights Reserved.</p>
	</footer>

</body>
</html>
