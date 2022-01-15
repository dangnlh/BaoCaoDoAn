package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.MapperAccount;
import BaoCaoDoAn.Entity.MapperProject;
import BaoCaoDoAn.Entity.Project;
@Repository

public class ProjectDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate ;
	public List<Project> getProject(int id) {
		List<Project> list = new ArrayList<Project>();
		String sql = "Select * from project where group_id = " + id ;
		 list =  jdbcTemplate.query(sql, new MapperProject()) ;
		return list ;
		
	
	}

}
