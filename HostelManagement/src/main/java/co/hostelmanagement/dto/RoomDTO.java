package co.hostelmanagement.dto;

public class RoomDTO
{

	private String name;
	private Long contact;
	private String roomType;
	private int room;
	private int andidate;
	private String viewType;
	private String roomviewType;
	private String checkin;
	private String checkout;
	
	private String room_number;
	private String room_type;
	private String view;
	private String room_category;
	private boolean isBooked;
	
	
	public boolean isBooked() {
		return isBooked;
	}
	public void setIsBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	public String getRoom_number() {
		return room_number;
	}
	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public String getRoom_category() {
		return room_category;
	}
	public void setRoom_category(String room_category) {
		this.room_category = room_category;
	}
	public String getName() {
		return name;
	}
	public String getRoomviewType() {
		return roomviewType;
	}
	public void setRoomviewType(String roomviewType) {
		this.roomviewType = roomviewType;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getAndidate() {
		return andidate;
	}
	public void setAndidate(int andidate) {
		this.andidate = andidate;
	}
	public String getViewType() {
		return viewType;
	}
	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
}
