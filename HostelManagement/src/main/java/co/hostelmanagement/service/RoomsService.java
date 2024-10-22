package co.hostelmanagement.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import co.hostelmanagement.controller.Controller;
import co.hostelmanagement.controller.RoomController;
import co.hostelmanagement.dto.PaymentDTO;
import co.hostelmanagement.dto.RoleDTO;
import co.hostelmanagement.dto.RoomDTO;

public class RoomsService extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		String fname = req.getParameter("fullName");
		String contact1 = req.getParameter("contact");
		String roomtype = req.getParameter("roomType");
		int numRoom;
		int candidate;
		String viewType = req.getParameter("viewType");
		String roomviewType = req.getParameter("roomviewType");
		String checkin = req.getParameter("checkinDate");
		String checkout = req.getParameter("checkoutDate");
		String roomNumber = req.getParameter("roomNumber");

		
		if (!RoomController.isRoomAvailable(roomNumber)) {
			req.setAttribute("bookingError1", "The selected room is already booked.");
			RequestDispatcher dispatcher = req.getRequestDispatcher("Rooms.jsp");
			dispatcher.forward(req, response);
			return;
		}

		
		if (contact1 == null || contact1.length() != 10 || !contact1.matches("\\d+")) {
			req.setAttribute("errorMessagephone", "Invalid Phone number. It must be 10 digits.");
			RequestDispatcher rd = req.getRequestDispatcher("/Rooms.jsp");
			rd.forward(req, response);
			return;
		}

		
		Long contact = Long.parseLong(contact1);

		try {
			numRoom = Integer.parseInt(req.getParameter("roomNumber"));
			candidate = Integer.parseInt(req.getParameter("cndidate"));
		} catch (NumberFormatException e) {
			req.setAttribute("errorMessage", "Invalid room number or candidate count.");
			RequestDispatcher rd = req.getRequestDispatcher("/Rooms.jsp");
			rd.forward(req, response);
			return;
		}

	
//		if (candidate <= 2) {
//			req.setAttribute("errorcandidate", "Not enough rooms for candidates.");
//			RequestDispatcher rd = req.getRequestDispatcher("/Rooms.jsp");
//			rd.forward(req, response);
//			return;
//		}

		
		if (roomtype.equals("Private") && candidate != 1) {
			req.setAttribute("errorprivate", "Not enough private rooms for candidates.");
			RequestDispatcher rd = req.getRequestDispatcher("/Rooms.jsp");
			rd.forward(req, response);
			return;
		}

		
		if (checkin.compareTo(checkout) >= 0) {
			req.setAttribute("errorcandidate", "Check-in date must be before check-out date.");
			RequestDispatcher rd = req.getRequestDispatcher("/Rooms.jsp");
			rd.forward(req, response);
			return;
		}

		
		RoomDTO room = new RoomDTO();
		room.setName(fname);
		room.setContact(contact);
		room.setRoomType(roomtype);
		room.setRoom(numRoom);
		room.setAndidate(candidate);
		room.setViewType(viewType);
		room.setRoomviewType(roomviewType);
		room.setCheckin(checkin);
		room.setCheckout(checkout);

		PaymentDTO pay=new PaymentDTO();
		pay.setRoom_number(numRoom);
	
		boolean isRoomInserted = RoomController.insertRoomsDetails(room);
		if (isRoomInserted) {
			
			boolean isBooked = RoomController.bookRoom(String.valueOf(numRoom));
			if (isBooked) {
				req.setAttribute("candidate", candidate);
				req.setAttribute("viewType", viewType);
				req.setAttribute("roomviewType", roomviewType);
				req.setAttribute("roomtype", roomtype);
				req.setAttribute("roomNumber", numRoom);  
				RequestDispatcher rd = req.getRequestDispatcher("/PaymentProssecc.jsp");
				rd.forward(req, response);
			} else {
				req.setAttribute("bookingError", "Room booking failed. Please try again.");
				RequestDispatcher rd = req.getRequestDispatcher("/Rooms.jsp");
				rd.forward(req, response);
			}
		} else {
			PrintWriter out = response.getWriter();
			out.println("<html><body><h3>Room registration failed. Please try again.</h3></body></html>");
		}
	}
}
