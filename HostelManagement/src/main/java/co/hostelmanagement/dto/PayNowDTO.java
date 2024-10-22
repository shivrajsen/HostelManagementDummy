package co.hostelmanagement.dto;

import java.sql.Timestamp;

public class PayNowDTO 
{

	private int room_number;
	private String bank_Name;
	private String card_Type;
	private long card_Number;
	private String upi_Id;
	private String pass;
	private Timestamp  CreatedDate;
	private String password;
	
	  public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		CreatedDate = createdDate;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	private double paymentAmount;
		private String candidate;
		private String viewType;
		private String roomviewType;
		private String billType;
		private String transactionId;
		public int getRoom_number() {
			return room_number;
		}
		public void setRoom_number(int room_number) {
			this.room_number = room_number;
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
		public double getPaymentAmount() {
			return paymentAmount;
		}
		public void setPaymentAmount(double paymentAmount) {
			this.paymentAmount = paymentAmount;
		}
		public String getCandidate() {
			return candidate;
		}
		public void setCandidate(String candidate) {
			this.candidate = candidate;
		}
		public String getViewType() {
			return viewType;
		}
		public void setViewType(String viewType) {
			this.viewType = viewType;
		}
		public String getRoomviewType() {
			return roomviewType;
		}
		public void setRoomviewType(String roomviewType) {
			this.roomviewType = roomviewType;
		}
		public String getBillType() {
			return billType;
		}
		public void setBillType(String billType) {
			this.billType = billType;
		}
		public String getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(String transactionId2) {
			this.transactionId = transactionId2;
		}
		
		
		
}
