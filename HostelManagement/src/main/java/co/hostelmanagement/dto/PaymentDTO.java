package co.hostelmanagement.dto;

public class PaymentDTO {
	private int room_number;
	private String bank_Name;
	private String card_Type;
	private long card_Number;
	private String upi_Id;
	  private double paymentAmount;
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	private int number_Room;
	
	
	public int getRoom_number() {
		return room_number;
	}
	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}
	public int getNumber_Room() {
		return number_Room;
	}
	public void setNumber_Room(int number_Room) {
		this.number_Room = number_Room;
	}
	public String getBank_Name() {
		return bank_Name;
	}
	public void setBank_Name(String bank_Name) {
		this.bank_Name = bank_Name;
	}
	public String getCard_Type() {
		return card_Type;
	}
	public void setCard_Type(String card_Type) {
		this.card_Type = card_Type;
	}
	public long getCard_Number() {
		return card_Number;
	}
	public void setCard_Number(long card_Number) {
		this.card_Number = card_Number;
	}
	public String getUpi_Id() {
		return upi_Id;
	}
	public void setUpi_Id(String upi_Id) {
		this.upi_Id = upi_Id;
	}

}
