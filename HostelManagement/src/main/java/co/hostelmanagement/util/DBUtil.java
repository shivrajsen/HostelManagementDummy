package co.hostelmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import co.hostelmanagement.dto.AddressDTO;


public class DBUtil 
{
	private static Connection con;

	public static Connection getController() {
		try {
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GAPORTAL", "root", "root");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	  public static Long generateEventId() {
	        Long id = null;
	        Statement statement = null;
	        ResultSet rs = null;
	        Connection con = getController();

	        try {
	           
	        	 AddressDTO a=new  AddressDTO();
	          
	            statement = con.createStatement();
	            rs = statement.executeQuery("SELECT MAX(id) FROM userhostel ");

	            Long maxEventId = 1L	; // Default value
	            if (rs.next()) {
	                maxEventId = rs.getLong(1);
	            }
	           id = ++maxEventId;
	          
		        a.setId(id);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (IllegalStateException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            // Close resources to prevent leaks
	            try {
	                if (rs != null) rs.close();
	                if (statement != null) statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	       

	        return id;
	    }

}
