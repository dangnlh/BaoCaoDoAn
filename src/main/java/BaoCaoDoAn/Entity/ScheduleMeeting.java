package BaoCaoDoAn.Entity;

import java.util.Date;

public class ScheduleMeeting {
	private Integer id;
	
	private Date timeMeeting;
	private int project_id;
	
	private int account_id;

	public ScheduleMeeting() {
		super();
	}

	public ScheduleMeeting(Integer id, Date timeMeeting, int project_id, int account_id) {
		super();
		this.id = id;
		this.timeMeeting = timeMeeting;
		this.project_id = project_id;
		this.account_id = account_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}
