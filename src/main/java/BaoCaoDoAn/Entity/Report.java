package BaoCaoDoAn.Entity;

import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

public class Report {
	private int id;
	private String name;
	
	@NotNull(message = "Not character, just number")
	@Max(value = 10,message = "must be less than or equal 10")
	@Min(value = 0,message = "must be equal or greater than 0")
	private Double point;
	private String comment;
	private Date timeCreate;
	private Date timeSubmit;
	private String urlReport;
	private int project_id;
	private int status;
	private String convertedStatus;
	
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
	public Double getPoint() {
		return point;
	}
	public void setPoint(Double point) {
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getConvertedStatus() {
		if(getStatus()==1) {
			convertedStatus = "Submitted";
		}else {
			convertedStatus = "Not Yet";
		}
		return convertedStatus;
	}
	public void setConvertedStatus(String convertedStatus) {
		this.convertedStatus = convertedStatus;
	}
	
	
	
}
