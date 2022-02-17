package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import BaoCaoDoAn.Entity.MapperProject;
import BaoCaoDoAn.Entity.Project;

@Repository

public class ProjectDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	public List<Project> getProjectByGroup_id(int id) {
		List<Project> list = new ArrayList<Project>();
		String sql = "Select * from project where group_id = " + id ;
		 list =  jdbcTemplate.query(sql, new MapperProject()) ;
		return list ;

	}
	
	public List<Project> getProjectByid(int id) {
		List<Project> list = new ArrayList<Project>();
		String sql = "Select * from project where id = " + id ;
		 list =  jdbcTemplate.query(sql, new MapperProject()) ;
		return list ;

	}
	
	public List<Project> getAllProject() {
		List<Project> list = new ArrayList<Project>();
		String sql = "Select * from project  " ;
		list =  jdbcTemplate.query(sql, new MapperProject()) ;
		return list;
	}
	public int addProject(Project project) {
		StringBuffer sql = new StringBuffer();	
		sql.append("INSERT INTO project (name,urlProject,createTime,group_id) "
				+ "VALUES ('"+project.getName()+"', '"+project.getUrlProject()+"' "
				+ ",'"+project.getCreateTime()+"', "+project.getGroup_id()+" )");	
		int insert = jdbcTemplate.update(sql.toString()) ; 		
		return insert;
	}

	
	public int deleteProject( int id) {
		
		String sql = "DELETE FROM project WHERE id = "+id+" " ;
		int result = jdbcTemplate.update(sql); 
		return result;
		
	}
	
	public int editProject(int id) {
		Project project = new Project();
		StringBuffer sql = new StringBuffer();	
		sql.append("UPDATE project SET name = '"+project.getName()+"', urlProject = '"+project.getUrlProject()+"'"
				+ " , createTime ='"+project.getCreateTime()+"' WHERE id = "+id+" ");	
		int insert = jdbcTemplate.update(sql.toString()) ; 		
		return insert;
	}
	public List<Project> getProjectByTeacherId(int teacherId) {
		List<Project> list = new ArrayList<Project>();
		String sql = "Select * from project where teacher_id = " + teacherId ;
		 list =  jdbcTemplate.query(sql, new MapperProject()) ;
		return list ;
	}

}
