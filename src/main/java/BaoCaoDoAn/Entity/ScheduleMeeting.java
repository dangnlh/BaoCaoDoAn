package BaoCaoDoAn.Entity;

import java.sql.Date;

public class ScheduleMeeting {
	private int id;
	private String name ; 
	private Date timeMeeting;
	private int project_id;
	
	private int account_id;
	private String link_meeting ;
	private String content ;
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
	public Date getTimeMeeting() {
		return timeMeeting;
	}
	public void setTimeMeeting(Date timeMeeting) {
		this.timeMeeting = timeMeeting;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getLink_meeting() {
		return link_meeting;
	}
	public void setLink_meeting(String link_meeting) {
		this.link_meeting = link_meeting;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ScheduleMeeting() {
		super();
	}
	

	

}
