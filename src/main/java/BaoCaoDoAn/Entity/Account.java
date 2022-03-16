package BaoCaoDoAn.Entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Account {
	
	private int id ;
	@Pattern(regexp = "[a-zA-Z ]{1,100}" , message = "Name is empty")

	private String name ;
	
	@Pattern(regexp = "[a-zA-Z ]{1,100}" , message = "Email is empty")
	private String mail ;
	@Pattern(regexp = "[a-zA-Z ]{1,100}" , message = "Password is empty")

	private String password ;
	

	private int group_id ;
	
	private int phone ;
	@NotEmpty
	private String role ;
	
	private Boolean isLeader ;
	private PointDetail pointDetailForReport;
	private int statusPoint;
	private String gender;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public String setMail(String mail) {
		return this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public String setPassword(String password) {
		return this.password = password;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Boolean getIsLeader() {
		return isLeader;
	}
	public void setIsLeader(Boolean isLeader) {
		this.isLeader = isLeader;
	}
	public PointDetail getPointDetailForReport() {
		return pointDetailForReport;
	}
	public void setPointDetailForReport(PointDetail pointDetailForReport) {
		this.pointDetailForReport = pointDetailForReport;
	}
	public int getStatusPoint() {
		return statusPoint;
	}
	public void setStatusPoint(int statusPoint) {
		this.statusPoint = statusPoint;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
