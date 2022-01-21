package BaoCaoDoAn.Entity;

import java.util.Date;

public class ScheduleReport {
	private int id;
	private Date timeReport;
	private int account_id;
	private int report_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getTimeReport() {
		return timeReport;
	}
	public void setTimeReport(Date timeReport) {
		this.timeReport = timeReport;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getReport_id() {
		return report_id;
	}
	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}
	public ScheduleReport(int id, Date timeReport, int account_id, int report_id) {
		super();
		this.id = id;
		this.timeReport = timeReport;
		this.account_id = account_id;
		this.report_id = report_id;
	}
	public ScheduleReport() {
		super();
	}

	
	
	

	
}
