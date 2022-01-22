package BaoCaoDoAn.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperScheduleMeeting implements RowMapper<ScheduleMeeting> {

	public ScheduleMeeting mapRow(ResultSet rs, int rowNum) throws SQLException {
		ScheduleMeeting admin = new ScheduleMeeting();
		admin.setId(rs.getInt("id"));
		admin.setTimeMeeting(rs.getDate("timeMeeting"));
		admin.setProject_id(rs.getInt("project_id"));
		admin.setAccount_id(rs.getInt("account_id"));
		
		
		return admin;
	}
	
}
