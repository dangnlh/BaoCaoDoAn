package BaoCaoDoAn.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperGroup implements RowMapper<Groups> {

	public Groups mapRow(ResultSet rs, int rowNum) throws SQLException {
		Groups group = new Groups();
		group.setId(rs.getInt("id"));
		group.setName(rs.getString("name"));
		
		return group;
	}
}
