package BaoCaoDoAn.Entity;

import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PointDetail {
	private Integer id;
	private Integer reportId;
	private Integer studentId;
	private Integer teacherId;
	private Date dateGrade;
	@NotNull(message = "Not character, just number")
	@Max(value = 10, message = "must be less than or equal 10")
	@Min(value = 0, message = "must be equal or greater than 0")
	private Double point;

	public PointDetail() {
		// TODO Auto-generated constructor stub
	}

	public PointDetail(Integer id, Integer reportId, Integer studentId, Integer teacherId, Date dateGrade, Double point) {
		super();
		this.id = id;
		this.reportId = reportId;
		this.studentId = studentId;
		this.teacherId = teacherId;
		this.dateGrade = dateGrade;
		this.point = point;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Date getDateGrade() {
		return dateGrade;
	}

	public void setDateGrade(Date dateGrade) {
		this.dateGrade = dateGrade;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

}
