package co.hostelmanagement.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import co.hostelmanagement.controller.FeedbackController;
import co.hostelmanagement.controller.RoomController;
import co.hostelmanagement.dto.FeedbackDTO;
import co.hostelmanagement.dto.RoomDTO;

public class FeedbackShowService extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<FeedbackDTO> feedbackList = FeedbackController.getShowFeedback();
	        request.setAttribute("feedbackList", feedbackList);

	        RequestDispatcher rd = request.getRequestDispatcher("/FeedbackShow.jsp"); 
	        rd.forward(request, response);
	}

}
