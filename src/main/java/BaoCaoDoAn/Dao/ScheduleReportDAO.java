package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.MapperScheduleReport;
import BaoCaoDoAn.Entity.Report;
import BaoCaoDoAn.Entity.ScheduleReport;

@Repository
public class ScheduleReportDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

//	public List<ScheduleReport> getScheduleReport(int id) {
//		List<ScheduleReport> list = new ArrayList<ScheduleReport>();
//		String sql = "Select * from schedulereport where account_id = " + id ;
//		 list =  jdbcTemplate.query(sql, new MapperScheduleReport()) ;
//		return list ;
//	}
//	

	public List<ScheduleReport> getAllScheduleReport() {
		List<ScheduleReport> list = new ArrayList<ScheduleReport>();
		String sql = "Select * from schedulereport";
		list = jdbcTemplate.query(sql, new MapperScheduleReport());

		return list;
	}

	public List<ScheduleReport> getScheduleReportByReportId(int i) {
		List<ScheduleReport> list = new ArrayList<ScheduleReport>();
		String sql = "Select * from schedulereport WHERE report_id=" + i;
		list = jdbcTemplate.query(sql, new MapperScheduleReport());
		return list;
	}

	public int addScheduleReport(ScheduleReport scheduleReport) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO schedulereport (timeReport, report_id) " + " VALUES ('" + scheduleReport.getTimeReport()
				+ "', " + scheduleReport.getReport_id() + ");");
		int insert = jdbcTemplate.update(sql.toString());

		return insert;
	}

	public int DeleteScheduleReport(String id) {

		String sql = "DELETE FROM schedulereport WHERE id = " + id + " ";
		int result = jdbcTemplate.update(sql);
		return result;

	}

	public List<ScheduleReport> getScheduleReportByAccountId(int accountId) {
		List<ScheduleReport> list = new ArrayList<ScheduleReport>();
		String sql = "Select * from schedulereport WHERE account_id=" + accountId;
		list = jdbcTemplate.query(sql, new MapperScheduleReport());
		return list;
	}

	public List<ScheduleReport> getScheduleReportByTeacherId(int teacherId) {
		List<ScheduleReport> list = new ArrayList<ScheduleReport>();
		String sql = "SELECT * \r\n"
				+ "FROM baocaodoan.schedulereport\r\n"
				+ "WHERE report_id IN (SELECT r.id\r\n"
				+ "FROM baocaodoan.project as p,baocaodoan.report as r \r\n"
				+ "where p.teacher_id ="+teacherId+"  and p.id = r.project_id)\r\n"
				+ "order by timeReport;";
		list = jdbcTemplate.query(sql, new MapperScheduleReport());
		return list;
	}
	
	public List<ScheduleReport> getScheduleReportBygroupId(int groupId) {
		List<ScheduleReport> list = new ArrayList<ScheduleReport>();
		String sql = "SELECT * \r\n"
				+ "FROM baocaodoan.schedulereport\r\n"
				+ "WHERE report_id IN (SELECT r.id\r\n"
				+ "FROM baocaodoan.project as p,baocaodoan.report as r \r\n"
				+ "where p.group_id =" + groupId + "  and p.id = r.project_id)\r\n"
				+ "order by timeReport;";
		list = jdbcTemplate.query(sql, new MapperScheduleReport());
		return list;
	}
}
