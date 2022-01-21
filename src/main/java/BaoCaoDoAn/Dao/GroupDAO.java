package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Groups;
import BaoCaoDoAn.Entity.MapperAccount;
import BaoCaoDoAn.Entity.MapperGroup;

@Repository
public class GroupDAO {
	@Autowired
	JdbcTemplate _jdbcTemplate;

	public List<Account> GetGroup(int id) {
		List<Account> list = new ArrayList<Account>();
		String sql = "SELECT * FROM account where group_id = " + id;
		list = _jdbcTemplate.query(sql, new MapperAccount());
		return list;
	}
	
	public List<Groups> getGroupAdmin() {
		List<Groups> listGroup = new ArrayList<Groups>();
		String sql = "SELECT * FROM `group` ";
		listGroup = _jdbcTemplate.query(sql, new MapperGroup());
		return listGroup;
	}

	public int addGroup(Groups group) {
		String sql = "INSERT INTO group (id,name) VALUES (?,?)";
		int count = _jdbcTemplate.update(sql, new Object[] { group.getId(), group.getName() });
		return count;
	}

	public int updateGroup(Groups group) {
		String sql = "UPDATE group SET id=?,name=? WHERE id=?";
		int count = _jdbcTemplate.update(sql, group.getId(), group.getName());
		return count;
	}
	public void delete(int id) {
	    String sql = "DELETE FROM account WHERE id=?";
	    _jdbcTemplate.update(sql, id);
	    
	}
	public Account get(int accountId) {
	    String sql = "SELECT * FROM account WHERE group_id=" + accountId;
	    Account result =  _jdbcTemplate.queryForObject(sql, new MapperAccount()) ;
		return result ;
	}
	public List<Account> GetGroup1(int id) {
		List<Account> list = new ArrayList<Account>();
		String sql = "SELECT * FROM account where group_id = " + id;
		list = _jdbcTemplate.query(sql, new MapperAccount());
		return list;
	}
	
}
