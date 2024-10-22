package co.hostelmanagement.dto;

public class AddressDTO
{
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String permanent_Address;
	private String local_Address;
	private long adhar_Num;
	public String getPermanent_Address() {
		return permanent_Address;
	}
	public void setPermanent_Address(String permanent_Address) {
		this.permanent_Address = permanent_Address;
	}
	public String getLocal_Address() {
		return local_Address;
	}
	public void setLocal_Address(String local_Address) {
		this.local_Address = local_Address;
	}
	public long getAdhar_Num() {
		return adhar_Num;
	}
	public void setAdhar_Num(long adhar_Num) {
		this.adhar_Num = adhar_Num;
	}
	

}
