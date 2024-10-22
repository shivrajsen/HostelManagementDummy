package co.hostelmanagement.controller;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.hostelmanagement.dto.AddressDTO;
import co.hostelmanagement.dto.RoleDTO;
import co.hostelmanagement.dto.RoomDTO;
import co.hostelmanagement.dto.UserDTO;
import co.hostelmanagement.util.DBUtil;



public class Controller {

	    public static List<RoleDTO> fetchRoleDetails() {
	        List<RoleDTO> roleList = new ArrayList();
	        Connection connection = DBUtil.getController();
	        
	        try {
	            PreparedStatement ps = connection.prepareStatement(
	                    "SELECT role_id, role_name, role_description FROM role_details"
	            );

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                int roleId = rs.getInt("role_id");
	                String roleName = rs.getString("role_name");
	                String roleDescription = rs.getString("role_description");

	                RoleDTO r = new RoleDTO();
	                r.setRole_id(roleId);
	                r.setRole_name(roleName);
	                r.setRole_description(roleDescription);
	                
	                roleList.add(r);
	            }

	            if (!roleList.isEmpty()) {
	                System.out.println("Roles fetched successfully.");
	            } else {
	                System.out.println("No roles found.");
	            }

	        } catch (SQLException s) {
	            s.printStackTrace();    
	        } finally {
	            try {
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        return roleList;
	    }

	  
	
	public static boolean insertRegisterAddr(AddressDTO a) {
		boolean isSucces = false;
		Connection connection = DBUtil.getController();

		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO address_details ( id,adhar_num, permanent_address, local_address ) VALUES (?, ?, ?,?)");
			ps.setLong(1, a.getId());
			ps.setLong(2, a.getAdhar_Num());
			ps.setString(3, a.getPermanent_Address());
			ps.setString(4, a.getLocal_Address());
			
			 

			int rowsAffected = ps.executeUpdate();
			isSucces = rowsAffected > 0;

			if (isSucces) {

				try {
					System.out.println("Registration Successful");
				} catch (Exception e) {
					System.out.println("Email not sent.");
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isSucces;
	}

	public static boolean insertRegisterUser(UserDTO u) {
		boolean isSuccess = false;
		Connection connection = DBUtil.getController();
		Date createdDate = new Date();
		Long id = DBUtil.generateEventId();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO userhostel  (id , f_Name, l_Name, email, password, occupation,alternate_no, contact_no,dob, status, create_by, role_id,  create_at) VALUES (?,?,?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)");
			ps.setLong(1, id);
			ps.setString(2, u.getF_Name());
			ps.setString(3, u.getL_Name());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getPassword());
			ps.setString(6, u.getOccupation());
			
			ps.setLong(7, u.getAlternate_no());

			ps.setLong(8, u.getContect_no());
			ps.setString(9, u.getDob());
			ps.setString(10, u.getStatus());
			ps.setString(11, u.getCreated_by());
			ps.setInt(12, u.getRole_id());
			ps.setTimestamp(13, new Timestamp(createdDate.getTime()));

			int rowsAffected = ps.executeUpdate();
			isSuccess = rowsAffected > 0;

			if (isSuccess) {

				try {
					System.out.println("Registration Successful");
				} catch (Exception e) {
					System.out.println("Email not sent.");
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	
	
	  public static boolean emailExists(String email) {
	        boolean exists = false;
	        Connection connection = DBUtil.getController();
	        String query = "SELECT COUNT(*) FROM userhostel WHERE email = ?";
	        try {
	        
	             PreparedStatement stmt = connection.prepareStatement(query);
	            stmt.setString(1, email);
	            ResultSet rs = stmt.executeQuery();
	                if (rs.next() && rs.getInt(1) > 0) 
	                {
	                    exists = true;
	                }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return exists;
	    }
	  
	  
	  public static boolean getLoginEmailPass(UserDTO l) {
	        boolean isSuccess = false;
	        Connection connection = DBUtil.getController();
	        
	        try {
	            PreparedStatement ps = connection.prepareStatement(
	                "select email, password from userhostel where email=? and password=?"
	            );
	            ps.setString(1, l.getEmail());
	            ps.setString(2, l.getPassword());
	           

	            ResultSet rs = (ResultSet) ps.executeQuery();

	            isSuccess =rs.next();         
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return isSuccess;
	    }

	  public static boolean updateForgotPass(UserDTO u)
	  {
		  boolean isForgot=false;
		  Connection con = DBUtil.getController();
		  try {
			
					  PreparedStatement ps = con.prepareStatement("UPDATE userhostel SET password=? WHERE email=?");
					

			 
			  ps.setString(1, u.getPassword()); 
		        ps.setString(2, u.getEmail()); 
	           
	           

				int rowsAffected = ps.executeUpdate();
				isForgot = rowsAffected > 0;

				if (isForgot) {

					try {
						System.out.println("Forgot  Successful");
					} catch (Exception e) {
						System.out.println("Email not sent.");
						e.printStackTrace();
					}
				}
		    
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return isForgot;
		  
		  
		
		  
	  }
	  
	  
	  
	  
}
