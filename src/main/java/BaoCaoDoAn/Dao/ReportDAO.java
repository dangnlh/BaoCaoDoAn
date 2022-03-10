package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.MapperReport;

import BaoCaoDoAn.Entity.Report;

@Repository
public class ReportDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public Report getReport(int id) {
		Report result = null;
		List<Report> list = new ArrayList<Report>();
		String sql = "Select * from report where id = " + id;
		list = jdbcTemplate.query(sql, new MapperReport());
		if (!list.isEmpty()) {
			result = list.get(0);
		}
		return result;

	}

	public List<Report> getAllReport() {
		List<Report> list = new ArrayList<Report>();
		String sql = "Select * from report ";
		list = jdbcTemplate.query(sql, new MapperReport());
		return list;

	}

	public int addReport(Report report) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO report (name, timeCreate,timeSubmit,urlReport,project_id) " + "VALUES ('"
				+ report.getName() + "', '" + report.getTimeCreate() + "' " + ",'" + report.getTimeSubmit() + "', '"
				+ report.getUrlReport() + "'" + " ," + report.getProject_id() + ");");
		int insert = jdbcTemplate.update(sql.toString());
		return insert;
	}

	public int DeleteReport(String id) {

		String sql = "DELETE FROM report WHERE id = " + id + " ";
		int result = jdbcTemplate.update(sql);
		return result;

	}

	public int editReport(int id) {
		Report report = new Report();
		String sql = "UPDATE report SET name='" + report.getName() + "', timeCreate='" + report.getTimeCreate() + "'"
				+ ", timeSubmit='" + report.getTimeSubmit() + "' , project_id= " + report.getProject_id()
				+ " WHERE id= " + id;
		int result = jdbcTemplate.update(sql);
		return result;
	}

	public List<Report> getReportByProjectId(int projectId) {
		List<Report> list = new ArrayList<Report>();
		String sql = "SELECT * FROM baocaodoan.report where project_id  =" + projectId;
		list = jdbcTemplate.query(sql, new MapperReport());
		return list;

	}

	public int gradeReport(Double point, int reportId) {
		String sql = "UPDATE `baocaodoan`.`report` SET `point` = " + point + " WHERE (`id` = " + reportId + ");";
		int result = jdbcTemplate.update(sql);
		return result;
	}
	public void saveFileReportFile(String fileName, Integer reportId) {
		String sql = "UPDATE `baocaodoan`.`report` SET `urlReport` = ? WHERE (`id` = ?);";
		jdbcTemplate.update(sql, new Object[] { fileName, reportId });
	}
	
	public List<Report> getTimeSubmitReport(int group_id , int porject_id) {
		List<Report> list = new ArrayList<Report>();
		String sql = "SELECT * FROM baocaodoan.project as p,"
				+ "baocaodoan.report as r where p.group_id = "+group_id+" and p.id = "+porject_id+" ";
	 list = jdbcTemplate.query(sql, new MapperReport());
	 return list ;
	}
	

}
