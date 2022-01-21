package BaoCaoDoAn.Entity;

import java.sql.Date;

public class Report {
	private int id;
	private String name;
	private double point;
	private String comment;
	private Date timeCreate;
	private Date timeSubmit;
	private String urlReport;
	private int project_id;
	
	
	
	public Report() {
		super();
	}
	public Report(int id, String name, double point, String comment, Date timeCreate, Date timeSubmit, String urlReport,
			int project_id) {
		super();
		this.id = id;
		this.name = name;
		this.point = point;
		this.comment = comment;
		this.timeCreate = timeCreate;
		this.timeSubmit = timeSubmit;
		this.urlReport = urlReport;
		this.project_id = project_id;
	}
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
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getTimeCreate() {
		return timeCreate;
	}
	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}
	public Date getTimeSubmit() {
		return timeSubmit;
	}
	public void setTimeSubmit(Date timeSubmit) {
		this.timeSubmit = timeSubmit;
	}
	public String getUrlReport() {
		return urlReport;
	}
	public void setUrlReport(String urlReport) {
		this.urlReport = urlReport;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	
	
}
