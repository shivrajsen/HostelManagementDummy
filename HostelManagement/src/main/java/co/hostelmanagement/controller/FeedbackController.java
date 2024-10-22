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
import co.hostelmanagement.dto.PaymentDTO;
import co.hostelmanagement.dto.UserDTO;
import co.hostelmanagement.util.DBUtil;

public class FeedbackController
{

	  public static boolean getLoginEmail(UserDTO l) {
	        boolean isSuccess = false;
	        Connection connection = DBUtil.getController();
	        
	        try {
	            PreparedStatement ps = connection.prepareStatement(
	                "select email from userhostel where email=? "
	            );
	            ps.setString(1, l.getEmail());
	        
	           

	            ResultSet rs = (ResultSet) ps.executeQuery();

	            isSuccess =rs.next();         
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return isSuccess;
	    }
	  
	  public static boolean insertFeedbackDetails(FeedbackDTO p) {
	        boolean isRoomInserted = false;
	        Connection connection = DBUtil.getController();
	        Date createdDate = new Date();
	        

	        try {
	            PreparedStatement ps = connection.prepareStatement(
	                "INSERT INTO feedback_details (name, email, experience, rating, comments, createdDate) VALUES (?,?, ?, ?,?,?)"
	            );
	            ps.setString(1, p.getName());
	            ps.setString(2, p.getEmail());
	            ps.setString(3, p.getExperience());
	            ps.setString(4, p.getRating());
	            ps.setString(5, p.getComments());
	          
	           
	            ps.setTimestamp(6, new Timestamp(createdDate.getTime()));

	            int rowsAffected = ps.executeUpdate();
	            isRoomInserted = rowsAffected > 0;

	            if (isRoomInserted) {
	                System.out.println(" Feedback successful.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return isRoomInserted;
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

	 
}
