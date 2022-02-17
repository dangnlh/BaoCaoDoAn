package BaoCaoDoAn.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperScheduleMeeting implements RowMapper<ScheduleMeeting> {

	public ScheduleMeeting mapRow(ResultSet rs, int rowNum) throws SQLException {
		ScheduleMeeting admin = new ScheduleMeeting();
		admin.setId(rs.getInt("id"));
		admin.setName(rs.getString("name"));
		admin.setTimeMeeting(rs.getDate("timeMeeting"));
		admin.setProject_id(rs.getInt("project_id"));
		admin.setAccount_id(rs.getInt("account_id"));
		admin.setLink_meeting(rs.getString("link_meeting"));
		admin.setContent(rs.getString("content"));
		return admin;
	}
	
}
