package co.hostelmanagement.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.hostelmanagement.dto.FeedbackDTO;
import co.hostelmanagement.dto.PayNowDTO;
import co.hostelmanagement.dto.RoomDTO;
import co.hostelmanagement.dto.UserDTO;
import co.hostelmanagement.util.DBUtil;

public class AdminController 
{

	 public static List<UserDTO> selectRegisteredUsers() {
	        List<UserDTO> users = new ArrayList<>();
	        Connection connection = DBUtil.getController();

	        try {
	            PreparedStatement ps = connection.prepareStatement(
	                "SELECT id, f_Name, l_Name, email, password, occupation, alternate_no, contact_no, dob, status, create_by, role_id FROM userhostel");

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                UserDTO user = new UserDTO();
	                user.setId(rs.getLong("id"));
	                user.setF_Name(rs.getString("f_Name"));
	                user.setL_Name(rs.getString("l_Name"));
	                user.setEmail(rs.getString("email"));
	                user.setPassword(rs.getString("password"));
	                user.setOccupation(rs.getString("occupation"));
	                user.setAlternate_no(rs.getLong("alternate_no"));
	                user.setContect_no(rs.getLong("contact_no"));
	                user.setDob(rs.getString("dob"));
	                user.setStatus(rs.getString("status"));
	                user.setCreated_by(rs.getString("create_by"));
	                user.setRole_id(rs.getInt("role_id"));
	               

	                users.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (connection != null) {
	                    connection.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return users;
	    }
	
	 
	  public static List<PayNowDTO> selectPayNowUsers() {
	        List<PayNowDTO> payments = new ArrayList<>();
	        Connection connection = DBUtil.getController();

	        try {
	            PreparedStatement ps = connection.prepareStatement(
	                "SELECT room_number, bank_name, card_type, card_number, upi_id, payment_amount, candidate, view_type, roomview_type, bill_type, transaction_id, created_date, password FROM pay_now");

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                PayNowDTO payment = new PayNowDTO();
	                payment.setRoom_number(rs.getInt("room_number"));
	                payment.setBank_Name(rs.getString("bank_name"));
	                payment.setCard_Type(rs.getString("card_type"));
	                payment.setCard_Number(rs.getLong("card_number"));
	                payment.setUpi_Id(rs.getString("upi_id"));
	                payment.setPaymentAmount(rs.getDouble("payment_amount"));
	                payment.setCandidate(rs.getString("candidate"));
	                payment.setViewType(rs.getString("view_type"));
	                payment.setRoomviewType(rs.getString("roomview_type"));
	                payment.setBillType(rs.getString("bill_type"));
	                payment.setTransactionId(rs.getString("transaction_id"));
	                payment.setCreatedDate(rs.getTimestamp("created_date"));
	                payment.setPassword(rs.getString("password"));

	                payments.add(payment);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (connection != null) {
	                    connection.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return payments;
	    }
	
	  public static List<FeedbackDTO> getShowFeedback() {
	       
	        Connection connection = DBUtil.getController();
	        List<FeedbackDTO> feedbackList=new ArrayList<FeedbackDTO>();
	        
	        try {
	            PreparedStatement ps = connection.prepareStatement(
	                "select * from feedback_details"
	            );
	         
	        
	           

	            ResultSet rs = (ResultSet) ps.executeQuery();
	            while (rs.next()) {
	                FeedbackDTO feedback = new FeedbackDTO();
	                feedback.setName(rs.getString("name"));
	                feedback.setEmail(rs.getString("email"));
	                feedback.setExperience(rs.getString("experience"));
	                feedback.setRating(rs.getString("rating"));
	                feedback.setComments(rs.getString("comments"));
	                feedback.setCreatedDate(rs.getTimestamp("createdDate"));
	                
	                feedbackList.add(feedback);
	            }
	            
	            connection.close();

	                   
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return feedbackList;
	    }

	
	  
	  public static List<RoomDTO> getBookRoom() {
	        List<RoomDTO> availableRooms = new ArrayList<>();
	        Connection connection = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	       
	        try {
	            connection = DBUtil.getController();
	            ps = connection.prepareStatement(
	                "SELECT room_number, room_type, view, is_booked FROM rooms_type WHERE is_booked = 1"
	            );
	            rs = ps.executeQuery();

	            while (rs.next()) {
	                RoomDTO room = new RoomDTO();
	                room.setRoom_number(rs.getString("room_number"));
	                room.setRoomType(rs.getString("room_type"));
	                room.setView(rs.getString("view"));
	                room.setIsBooked(rs.getBoolean("is_booked"));
	                availableRooms.add(room);
	                
	               
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (ps != null) ps.close();
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return availableRooms;
	    }

}
