package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import BaoCaoDoAn.Entity.MapperReport;

import BaoCaoDoAn.Entity.Report;

@Repository
public class ReportDAO {
	@Autowired
	JdbcTemplate jdbcTemplate ;
	public List<Report> getReport(int id) {
		List<Report> list = new ArrayList<Report>();
		String sql = "Select * from project where project_id = " + id ;
		 list =  jdbcTemplate.query(sql, new MapperReport()) ;
		return list ;
		
	
	}
	
	public List<Report> getAllReport() {
		List<Report> list = new ArrayList<Report>();
		String sql = "Select * from report "  ;
		 list =  jdbcTemplate.query(sql, new MapperReport()) ;
		return list ;
		
	
	}
}
