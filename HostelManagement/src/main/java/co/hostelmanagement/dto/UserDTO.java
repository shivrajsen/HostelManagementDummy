package co.hostelmanagement.dto;

public class UserDTO 
{

	private String f_Name;
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String l_Name;
	private String fathers_Name;
	private String mothers_Name;
	private long contect_no;
	private long alternate_no;
	private String occupation;
	private String  email;
	private String password;
	private String dob;
	private String status;
	private String created_by;
	private int role_id;
	
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getF_Name() {
		return f_Name;
	}
	public void setF_Name(String f_Name) {
		this.f_Name = f_Name;
	}
	public String getL_Name() {
		return l_Name;
	}
	public void setL_Name(String l_Name) {
		this.l_Name = l_Name;
	}
	public String getFathers_Name() {
		return fathers_Name;
	}
	public void setFathers_Name(String fathers_Name) {
		this.fathers_Name = fathers_Name;
	}
	public String getMothers_Name() {
		return mothers_Name;
	}
	public void setMothers_Name(String mothers_Name) {
		this.mothers_Name = mothers_Name;
	}
	public long getContect_no() {
		return contect_no;
	}
	public void setContect_no(long contect_no) {
		this.contect_no = contect_no;
	}
	public long getAlternate_no() {
		return alternate_no;
	}
	public void setAlternate_no(long alternate_no) {
		this.alternate_no = alternate_no;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	
	
	
}
