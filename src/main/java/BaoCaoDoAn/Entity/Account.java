package BaoCaoDoAn.Entity;

public class Account {
	
	private int id ;
	private String name ;
	private String mail ;
	private String password ;
	private int group_id ;
	private int phone ;
	private String role ;
	private Boolean isLeader ;
	private PointDetail pointDetailForReport;
	private int statusPoint;
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
	
	
	
}
