package BaoCaoDoAn.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProject  implements RowMapper<Project> {

	public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
		Project project = new Project();
		project.setId(rs.getInt("id"));
		project.setName(rs.getString("name"));
		project.setUrlProject(rs.getString("url-Project"));
		project.setCreateTime(rs.getDate("create-time"));
		project.setGroup_id(rs.getInt("group_id"));
		return project;
	}

}
