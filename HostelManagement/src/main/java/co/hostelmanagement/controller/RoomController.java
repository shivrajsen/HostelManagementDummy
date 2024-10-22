package co.hostelmanagement.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.hostelmanagement.dto.RoomDTO;
import co.hostelmanagement.util.DBUtil;

public class RoomController {

	public static List<RoomDTO> checkAvailableRooms() {
		List<RoomDTO> roomDTO=new ArrayList<RoomDTO>();
		
	    Connection connection = DBUtil.getController();
	    try {
	        PreparedStatement ps = connection.prepareStatement(
	            "SELECT * FROM rooms_type WHERE is_booked = 0"
	        );
	       
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
                RoomDTO room = new RoomDTO();
                room.setRoom_number(rs.getString("room_number"));
                room.setRoomType(rs.getString("room_type"));
                room.setView(rs.getString("view"));
                room.setIsBooked(rs.getBoolean("is_booked"));
                roomDTO.add(room);
                
               
            }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (NumberFormatException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return roomDTO;
	}

    public static boolean insertRoomsDetails(RoomDTO r) {
        boolean isRoomInserted = false;
        Connection connection = DBUtil.getController();
        Date createdDate = new Date();

        try {
            PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO roomdetails (f_Name, contact, roomType, room, candidate, viewType, roomviewType, checkIn, checkOut, create_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, r.getName());
            ps.setLong(2, r.getContact());
            ps.setString(3, r.getRoomType());
            ps.setInt(4, r.getRoom());
            ps.setInt(5, r.getAndidate());
            ps.setString(6, r.getViewType());
            ps.setString(7, r.getRoomviewType());
            ps.setString(8, r.getCheckin());
            ps.setString(9, r.getCheckout());
            ps.setTimestamp(10, new Timestamp(createdDate.getTime()));

            int rowsAffected = ps.executeUpdate();
            isRoomInserted = rowsAffected > 0;

            if (isRoomInserted) {
                System.out.println("Room registration successful.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isRoomInserted;
    }

    public static List<RoomDTO> fetchRoomDetails() {
        List<RoomDTO> roomList = new ArrayList<>();
        Connection connection = DBUtil.getController();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT room_number, room_type, view, room_category FROM rooms_type");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RoomDTO room = new RoomDTO();
                room.setRoom_number(rs.getString("room_number"));
                room.setRoom_type(rs.getString("room_type"));
                room.setView(rs.getString("view"));
                room.setRoom_category(rs.getString("room_category"));
                roomList.add(room);
            }

            if (!roomList.isEmpty()) {
                System.out.println("Room details fetched successfully.");
            } else {
                System.out.println("No rooms found.");
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

        return roomList;
    }

    public static boolean bookRoom(String numRoom) {
        boolean isRoomBooked = false;
        Connection connection = DBUtil.getController();

        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE rooms_type SET is_booked = 1 WHERE room_number = ?");
            ps.setString(1, numRoom);

            int rowsAffected = ps.executeUpdate();
            isRoomBooked = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isRoomBooked;
    }
    
    public static List<RoomDTO> getAvailableRoomNumbers() {
        List<RoomDTO> availableRooms = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

       
        try {
            connection = DBUtil.getController();
            ps = connection.prepareStatement(
                "SELECT room_number, room_type, view, is_booked FROM rooms_type WHERE is_booked = 0"
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

    
    public static boolean isRoomAvailable(String roomNumber) {
        Connection connection = DBUtil.getController();
        try {
            PreparedStatement ps = connection.prepareStatement(
                "SELECT is_booked FROM rooms_type WHERE room_number = ?"
            );
            ps.setString(1, roomNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return !rs.getBoolean("is_booked");  
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false; 
    }
    
    public static List<RoomDTO> getBookRoomNumbers() {
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
