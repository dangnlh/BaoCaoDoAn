package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import BaoCaoDoAn.Entity.MapperScheduleReport;

import BaoCaoDoAn.Entity.ScheduleReport;

@Repository
public class ScheduleReportDAO {

	
	@Autowired
	JdbcTemplate jdbcTemplate ;
	
//	public List<ScheduleReport> getScheduleReport(int id) {
//		List<ScheduleReport> list = new ArrayList<ScheduleReport>();
//		String sql = "Select * from schedulereport where account_id = " + id ;
//		 list =  jdbcTemplate.query(sql, new MapperScheduleReport()) ;
//		return list ;
//	}
//	
	
	public List<ScheduleReport> getAllScheduleReport() {
		List<ScheduleReport> list = new ArrayList<ScheduleReport>();
		String sql = "Select * from schedulereport" ;
		 list =  jdbcTemplate.query(sql, new MapperScheduleReport()) ;
		 
		return list ;
	}
	
	public ScheduleReport AddScheduleReport( int id , Date timeReport , int account_id , int report_id) {
		ScheduleReport scheduleReport = new ScheduleReport();
		String sql = "INSERT INTO schedulereport (id , timeReport, account_id , report_id) " + 
				" VALUES ("+id+", "+timeReport+", "+account_id+", "+report_id+");" ;
		scheduleReport =  jdbcTemplate.queryForObject(sql, new MapperScheduleReport()) ;
		 
		return scheduleReport ;
	}
	
}
