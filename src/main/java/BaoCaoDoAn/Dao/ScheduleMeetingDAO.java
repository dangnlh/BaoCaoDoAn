package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.ScheduleMeeting;
import BaoCaoDoAn.Entity.MapperScheduleMeeting;

@Repository
public class ScheduleMeetingDAO {
	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	public List<ScheduleMeeting> GetDataAmin(){
		List<ScheduleMeeting> list = new ArrayList<ScheduleMeeting>();
		String sql = "SELECT * FROM schedulemeeting";
		list = jdbcTemplate.query(sql, new MapperScheduleMeeting());
		return list;
	}
	//add
	public int save(ScheduleMeeting admin) {
		String sql = "INSERT INTO schedulemeeting (timeMeeting,project_id,account_id) VALUES (?,?,?)";
		int count = jdbcTemplate.update(sql,new Object[] {admin.getTimeMeeting(),admin.getProject_id(),admin.getAccount_id()});
		return count;
	}
	//delete
	public void delete(int id) {
	    String sql = "DELETE FROM schedulemeeting WHERE id=?";
	    jdbcTemplate.update(sql, id);
	}
	//Update
	public int update(ScheduleMeeting admin) {
	        // update
	        String sql = "UPDATE schedulemeeting SET timeMeeting=?, project_id=?, account_id=? "
	                    + "WHERE id=?";
	        int count = jdbcTemplate.update(sql, admin.getTimeMeeting(),admin.getProject_id(),admin.getAccount_id(),admin.getId());
	        return count;
	 
	}
	
	public ScheduleMeeting get(int adminId) {
	    String sql = "SELECT * FROM schedulemeeting WHERE id=" + adminId;
	    ScheduleMeeting result =  jdbcTemplate.queryForObject(sql, new MapperScheduleMeeting()) ;
		return result ;
	}
}
