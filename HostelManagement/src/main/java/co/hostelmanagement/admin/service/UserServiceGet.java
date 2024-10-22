package co.hostelmanagement.admin.service;

import java.util.List;

import co.hostelmanagement.controller.AdminController;
import co.hostelmanagement.dto.FeedbackDTO;
import co.hostelmanagement.dto.PayNowDTO;
import co.hostelmanagement.dto.RoomDTO;
import co.hostelmanagement.dto.UserDTO;

public class UserServiceGet {

	

	
	    public List<UserDTO> getAllUsers() {
	        return AdminController.selectRegisteredUsers();
	    }
	    

	    public List<PayNowDTO> getAllPayments() {
	        return AdminController.selectPayNowUsers();
	
	    }
	    public static List<FeedbackDTO> getAllFeedback(){
	    	return AdminController.getShowFeedback();
	    }
	    
	    public static List<RoomDTO> getAllBookRoom(){
	    	return AdminController.getBookRoom();
	    }
}
