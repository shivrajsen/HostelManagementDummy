package co.hostelmanagement.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.hostelmanagement.dto.PayNowDTO;
import co.hostelmanagement.dto.PaymentDTO;
import co.hostelmanagement.dto.RoomDTO;
import co.hostelmanagement.dto.UserDTO;
import co.hostelmanagement.util.DBUtil;

public class PaymentController 
{
	
	
	 public static boolean insertPaymentDetails(PaymentDTO p) {
	        boolean isRoomInserted = false;
	        Connection connection = DBUtil.getController();
	        Date createdDate = new Date();
	        

	        try {
	            PreparedStatement ps = connection.prepareStatement(
	                "INSERT INTO paymentdetails (room_Number, bank_Name, card_Type, card_Number, upi_Id, createdDate) VALUES (?,?, ?, ?,?,?)"
	            );
	            ps.setInt(1, p.getRoom_number());
	            ps.setString(2, p.getBank_Name());
	            ps.setString(3, p.getCard_Type());
	            ps.setLong(4, p.getCard_Number());
	            ps.setString(5, p.getUpi_Id());
	          
	           
	            ps.setTimestamp(6, new Timestamp(createdDate.getTime()));

	            int rowsAffected = ps.executeUpdate();
	            isRoomInserted = rowsAffected > 0;

	            if (isRoomInserted) {
	                System.out.println(" Pay current successful.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return isRoomInserted;
	    }

	 
	 
	 public static boolean insertPayNowDetails(PayNowDTO n) {
	        boolean isRoomInserted = false;
	        Connection connection = DBUtil.getController();
	        Date createdDate = new Date();
	        

	        try {
	            PreparedStatement ps = connection.prepareStatement(
	                "INSERT INTO pay_now (room_number, bank_name, card_type, card_number, upi_Id, payment_amount,candidate ,view_type , roomview_type ,bill_type ,transaction_id, created_date, password  ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"
	            );
	            ps.setInt(1, n.getRoom_number());
	            ps.setString(2, n.getBank_Name());
	            ps.setString(3, n.getCard_Type());
	            ps.setLong(4, n.getCard_Number());
	            ps.setString(5, n.getUpi_Id());
	            ps.setDouble(6, n.getPaymentAmount());
	            ps.setString(7, n.getCandidate());
	            ps.setString(8, n.getViewType());
	            ps.setString(9, n.getRoomviewType());
	            ps.setString(10, n.getBillType());
	            ps.setString(11, n.getTransactionId());
	           
	            
	          
	           
	            ps.setTimestamp(12, new Timestamp(createdDate.getTime()));
	            ps.setString(13, n.getPass());
	            

	            int rowsAffected = ps.executeUpdate();
	            isRoomInserted = rowsAffected > 0;

	            if (isRoomInserted) {
	                System.out.println(" Pay Now successful.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return isRoomInserted;
	    }


	 public static boolean getLoginEmailPass(PayNowDTO l) {
	        boolean isSuccess = false;
	        Connection connection = DBUtil.getController();
	        
	        try {
	            PreparedStatement ps = connection.prepareStatement(
	                "select password from userhostel where  password=?"
	            );
	       
	            ps.setString(1, l.getPass());
	           

	            ResultSet rs = (ResultSet) ps.executeQuery();

	            isSuccess =rs.next();         
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return isSuccess;

	 }

	 
	 
	 public static List<PayNowDTO> getPaymentHistory(int roomNumber, String password) {
	        List<PayNowDTO> paymentList = new ArrayList<>();
	        Connection con = DBUtil.getController();
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	        try {
	           
	            String query = "SELECT * FROM pay_now WHERE room_number = ? AND password = ?";
	            ps = con.prepareStatement(query);
	            ps.setInt(1, roomNumber);  
	            ps.setString(2, password);

	            rs = ps.executeQuery();

	       
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

	                paymentList.add(payment);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           
	            if (rs != null) try { rs.close(); } catch (Exception e) { e.printStackTrace(); }
	            if (ps != null) try { ps.close(); } catch (Exception e) { e.printStackTrace(); }
	            if (con != null) try { con.close(); } catch (Exception e) { e.printStackTrace(); }
	        }

	        return paymentList;
	    }
	}

	 
	 

