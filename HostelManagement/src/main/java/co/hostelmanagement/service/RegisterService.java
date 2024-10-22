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
import co.hostelmanagement.dto.AddressDTO;
import co.hostelmanagement.dto.RoleDTO;
import co.hostelmanagement.dto.UserDTO;
import co.hostelmanagement.util.DBUtil;

public class RegisterService extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
	
		String f_name = req.getParameter("f_name");
		String l_name = req.getParameter("l_name");
		String fathers_name = req.getParameter("fathers_name");
		String mothers_name = req.getParameter("mothers_name");
		Long contact_no =Long.parseLong( req.getParameter("contact_no"));
		Long alternate_no =Long.parseLong( req.getParameter("alternate_no"));
		String occupation = req.getParameter("occupation");
		String permanent_address = req.getParameter("permanent_address");
		String local_address = req.getParameter("local_address");
		String email = req.getParameter("email");
		Long adhar_no = Long.parseLong(req.getParameter("adhar_no"));
		String password = 	req.getParameter("password");
		String confimpass = req.getParameter("confimpassword");
		String created = req.getParameter("created_by");
		String dob = req.getParameter("DOB"); 
		String status = req.getParameter("status");
		String role_name = req.getParameter("role");
		
		boolean emailExists = Controller.emailExists(email);
		if (emailExists) {
			req.setAttribute("emailerrorMessage", "Email is already registered.");

			RequestDispatcher rd = req.getRequestDispatcher("/Register.jsp");
			rd.forward(req, response);
			return;
		}
		
		if(!password.equals(confimpass))
		{
			req.setAttribute("passerrorMessage", "Passwords do not match.");
			RequestDispatcher rd = req.getRequestDispatcher("/Register.jsp");
			rd.forward(req, response);
			return;
			
		}
		
		
		  List<RoleDTO> roles = Controller.fetchRoleDetails();
	        
		  int role_id = 0;
	        for (RoleDTO r : roles) {
	        	if(r.getRole_name().equals(role_name)) {
	        	  role_id = r.getRole_id();
	        	}
	        	
	        
	        }
	    
	

	

		
		UserDTO user=new UserDTO();
		user.setF_Name(f_name);
		user.setL_Name(  l_name);
		user.setFathers_Name(fathers_name);
		user.setMothers_Name(mothers_name);
		user.setContect_no(contact_no);
		user.setAlternate_no(alternate_no);
		user.setOccupation(occupation);
		user.setEmail(email);
		user.setPassword(password);
		user.setDob(dob);
		user.setStatus(status);
		user.setCreated_by(created);
		user.setRole_id(role_id);
		
		AddressDTO address=new AddressDTO();
		address.setAdhar_Num(adhar_no);
		address.setPermanent_Address(permanent_address);
		address.setLocal_Address(local_address);
		
		
	//	RoleDTO r=new RoleDTO();
		//r.setRole_id(role1);
		//	r.setRole_description(role_description);
		//r.setRole_name(role_name);
		
		
		DBUtil d = new DBUtil();
		Long eventId = DBUtil.generateEventId();
		address.setId(eventId);

		boolean isSuccess = false;
		boolean isSucces = false;
		//boolean isRole=false;

		try {

			isSuccess = Controller.insertRegisterUser(user);

			isSucces = Controller.insertRegisterAddr(address);
			//isRole=Controller.insertRegisterRole(r);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("registrationError", "An error occurred during registration. Please try again.");
			RequestDispatcher rd = req.getRequestDispatcher("/RegisterService.jsp");
			rd.forward(req, response);
			return;
		}

		if (isSuccess && isSucces) {

			RequestDispatcher rd = req.getRequestDispatcher("/Login.jsp");
			rd.forward(req, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<html><body><h3>Registration failed. Please try again.</h3></body></html>");
		}
	}

		
		
		
		
	}


