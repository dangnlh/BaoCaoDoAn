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
import BaoCaoDoAn.Entity.MapperScheduleMeeting;
import BaoCaoDoAn.Entity.ScheduleMeeting;

@Repository
public class GroupDAO {
	@Autowired
	JdbcTemplate _jdbcTemplate;

	public List<Account> getStudent(){
		List<Account> list = new ArrayList<Account>();
		String sql = "SELECT * FROM account Where role = 'student' ORDER BY group_id";
		list = _jdbcTemplate.query(sql, new MapperAccount());
		return list;
	}
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

	public int addAccountInGroup(Group group) {
		String sql = "INSERT INTO `group` (`id`, `name`) VALUES (?,?)";
		int count = _jdbcTemplate.update(sql, new Object[] { group.getId(), group.getName()});
		return count;
	}
	public int updateGroup(Group group) {
		String sql = "UPDATE `group` SET `name`=? WHERE id=?";
		int count = _jdbcTemplate.update(sql,group.getName(),group.getId());
		return count;
	}
	
	public int updateGroupInAccount(Account accout_group) {
		String sql = "UPDATE account SET group_id=? WHERE id=?";
		int count = _jdbcTemplate.update(sql, accout_group.getGroup_id(),accout_group.getId());
		return count;
	}

	public Account get(int accountId) {
	    String sql = "SELECT * FROM account WHERE id=" + accountId;
	    Account result =  _jdbcTemplate.queryForObject(sql, new MapperAccount()) ;
		return result ;
	}
	public Group FindGroupID(int groupID) {
	    String sql = "SELECT * FROM `group` WHERE id = " + groupID;
	    Group result =  _jdbcTemplate.queryForObject(sql, new MapperGroup()) ;
		return result ;
	}
	//delete
	public void delete(int id) {
	    String sql = "DELETE FROM `group` WHERE id=?";
	    _jdbcTemplate.update(sql, id);
	}
}
