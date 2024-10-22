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
import co.hostelmanagement.dto.RoomDTO;
import co.hostelmanagement.dto.UserDTO;

public class LoginService extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email=req.getParameter("email");
		String pass=req.getParameter("password");

		if(email.equals("admin123@gmail.com") && pass.equals("admin@123"))
		{
			
		    RequestDispatcher rd = req.getRequestDispatcher("/AdminHome.jsp");
		    rd.forward(req, response);	
		}
		
		UserDTO userEntity=new  UserDTO();
		userEntity.setEmail(email);
		userEntity.setPassword(pass);
		
		
		//Controller con=new Controller();
		boolean isSuccess = Controller.getLoginEmailPass(userEntity);

		if (isSuccess) {  
			
			req.setAttribute("success", "Login successful! Welcome, " + email + ".");
		    RequestDispatcher rd = req.getRequestDispatcher("/Home.jsp");
		    rd.forward(req, response);	
		} else {
		    req.setAttribute("error", "Invalid Email & Password");
		    RequestDispatcher rd = req.getRequestDispatcher("/Login.jsp");
		    rd.forward(req, response);
		}
		
		
		
	}
	

}
