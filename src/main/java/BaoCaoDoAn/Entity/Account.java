package BaoCaoDoAn.Entity;

public class Account {
	
	private int id ;
	private String name ;
	private String password ;
	private String mail ;
	private int phone ;
	private int role ;
	private int group_id ;
	private boolean isLeader ;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public boolean isLeader() {
		return isLeader;
	}
	public void setLeader(boolean isLeader) {
		this.isLeader = isLeader;
	}
	public Account() {
		super();
	}
	public Account(int id, String name, String password, String mail, int phone, int role, int group_id,
			boolean isLeader) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.mail = mail;
		this.phone = phone;
		this.role = role;
		this.group_id = group_id;
		this.isLeader = isLeader;
	}
	

	
}
