package co.hostelmanagement.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import co.hostelmanagement.controller.RoomController;
import co.hostelmanagement.dto.RoomDTO;


public class ViewRoomService extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
       
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	 List<RoomDTO> roomList = RoomController.getAvailableRoomNumbers();
         
         request.setAttribute("roomList", roomList);
        

         RequestDispatcher rd = request.getRequestDispatcher("/ViewRoom.jsp");
        // Change to Rooms.jsp
         rd.forward(request, response);
    }
}
