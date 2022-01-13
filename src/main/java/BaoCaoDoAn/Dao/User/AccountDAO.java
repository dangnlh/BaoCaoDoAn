package BaoCaoDoAn.Dao.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.MapperAccount;

@Repository
public class AccountDAO {
	@Autowired
	public JdbcTemplate _jdbcTemplate;

	public List<Account> GetStudentInfo() {
		List<Account> list = new ArrayList<Account>();
		String sql = " SELECT *   FROM `account`  ";
		list = _jdbcTemplate.query(sql, new MapperAccount());
		return list;
	}
}
