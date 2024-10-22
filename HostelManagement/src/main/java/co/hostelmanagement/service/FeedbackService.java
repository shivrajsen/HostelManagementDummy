package co.hostelmanagement.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import co.hostelmanagement.controller.Controller;
import co.hostelmanagement.controller.FeedbackController;
import co.hostelmanagement.dto.FeedbackDTO;
import co.hostelmanagement.dto.UserDTO;

public class FeedbackService extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String experience = req.getParameter("experience");
		String rating = req.getParameter("rating");
		String comments = req.getParameter("comments");
		
		UserDTO userEntity=new  UserDTO();
		userEntity.setEmail(email);
		
		
		FeedbackDTO dto=new FeedbackDTO();
		dto.setName(name);
		dto.setEmail(email);
		dto.setExperience(experience);
		dto.setRating(rating);
		dto.setComments(comments);
		
		boolean isSuccess = FeedbackController.getLoginEmail(userEntity);
		boolean isFeed = FeedbackController.insertFeedbackDetails(dto);

		//boolean feedback=true;
		 if (isSuccess && isFeed) {
	            req.setAttribute("name", name); 
	            req.setAttribute("email", email); 
	            req.setAttribute("experience", experience); 
	            req.setAttribute("rating", rating); 
	            req.setAttribute("comments", comments);
	          
				
	            req.setAttribute("success", "LogOut successful! Welcome, " + name + ".");
			    RequestDispatcher rd = req.getRequestDispatcher("/Index.jsp");
			    rd.forward(req, response);
	        } else {
	        	 req.setAttribute("error", "Invalid Email");
	 		    RequestDispatcher rd = req.getRequestDispatcher("/Feedback.jsp");
	 		    rd.forward(req, response);
	        }

	}

}
