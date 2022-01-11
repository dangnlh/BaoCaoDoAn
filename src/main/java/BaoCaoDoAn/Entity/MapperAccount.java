package BaoCaoDoAn.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperAccount implements RowMapper<Account> {

	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account acc = new Account();
		acc.setId(rs.getInt("id"));
		acc.setName(rs.getString("name"));
		acc.setPassword(rs.getString("password"));
		acc.setMail(rs.getString("mail"));
		acc.setPhone(rs.getInt("phone"));
		acc.setRole(rs.getInt("role"));
		acc.setGroup_id(rs.getInt("group_id"));
		acc.setLeader(rs.getBoolean("isLeader"));
		return acc;
	}
	
}