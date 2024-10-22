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
import co.hostelmanagement.dto.UserDTO;

public class ForgotPassService extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
	
		
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		String confimpass = req.getParameter("confirmPassword");
		
		
		if(!pass.equals(confimpass))
		{
			req.setAttribute("passerrorMessage", "Passwords do not match.");
			RequestDispatcher rd = req.getRequestDispatcher("/ForgetPassword.jsp");
			rd.forward(req, response);
			return;
			
		}
		 
		UserDTO user=new UserDTO();
		user.setEmail(email);
		user.setPassword(pass);
		
		boolean isSuc = false;
		//boolean isRole=false;

		try {

			isSuc = Controller.updateForgotPass(user);

			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("registrationError", "An error occurred during registration. Please try again.");
			RequestDispatcher rd = req.getRequestDispatcher("/FotgetPassword.jsp");
			rd.forward(req, response);
			return;
		}

		if (isSuc) {
			req.setAttribute("Success", "Password is successfull changed :");

			RequestDispatcher rd = req.getRequestDispatcher("/Login.jsp");
			rd.forward(req, response);
		} else {
			req.setAttribute("error1", "Email  is  changed :");

			RequestDispatcher rd = req.getRequestDispatcher("/ForgetPassword.jsp");
			rd.forward(req, response);
		}
		
		
		
		
	}

}
