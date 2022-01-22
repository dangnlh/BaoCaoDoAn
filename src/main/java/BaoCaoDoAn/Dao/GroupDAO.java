package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Group;
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
	
	public List<Group> getGroupAdmin() {
		List<Group> listGroup = new ArrayList<Group>();
		String sql = "SELECT * FROM `group` ";
		listGroup = _jdbcTemplate.query(sql, new MapperGroup());
		return listGroup;
	}

	public int addGroup(Group group) {
		String sql = "INSERT INTO group (id,name) VALUES (?,?)";
		int count = _jdbcTemplate.update(sql, new Object[] { group.getId(), group.getName() });
		return count;
	}

	public int updateGroup(Group group) {
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
