package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Dto.AccountSearchCondition;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Group;
import BaoCaoDoAn.Entity.MapperAccount;
import BaoCaoDoAn.Entity.MapperGroup;

@Repository
public class StudentDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	JdbcTemplate _jdbcTemplate;

	// Student List
	public List<Account> getStudentByAccount(Account account) {
		List<Account> list = new ArrayList<Account>();
		String sql = "SELECT * FROM account WHERE role=" + account.getRole();
		list = jdbcTemplate.query(sql, new MapperAccount());
		return list;
	}

	public Account GetStudentByAccount(Account account) {
		try {

			System.out.println(account.getMail());
			System.out.println(account.getPassword());
			String sql = "SELECT * FROM `account` WHERE role LIKE 'student' " + account.getRole();

			Account result = jdbcTemplate.queryForObject(sql, new MapperAccount());
			if (result != null) {
				return result;
			}
		} catch (EmptyResultDataAccessException e) {

			return null;
		}
		return null;
	}

	public List<Account> getAccountListByCondition(AccountSearchCondition condition) {
		List<Account> list = new ArrayList<Account>();

		String sql = "SELECT * FROM account ";
		String strCondition = "";
		if (condition != null) {
			sql += "Where ";
			if (condition.getRole() != null) {
				strCondition += " role = '" + condition.getRole() + "'";
			}
			if (strCondition != "") {
				strCondition += " AND ";
			}
			if (condition.getNamne() != null) {
				strCondition += " name like '" + condition.getNamne() + "%'";
			}
			sql += strCondition;
		}

		list = jdbcTemplate.query(sql, new MapperAccount());
		return list;
	}

	// student list by account
	public List<Account> getStudentList() {
		List<Account> list = new ArrayList<Account>();
		String sql = "SELECT * FROM account WHERE role= 'student'";
		list = jdbcTemplate.query(sql, new MapperAccount());
		return list;
	}

	public void delete(int id) {
		String sql = " DELETE FROM `account` WHERE id=? ";
		_jdbcTemplate.update(sql, id);
	}

//	public int updateAccount(Account account) {
//		String sql = "UPDATE `account` SET `name`=?, `group_id`=?, `phone=`?, `isLeader`=?, `gender`=? WHERE id=?";
//		int count = _jdbcTemplate.update(sql, group.getName(), group.getId());
//		return count;
//	}

	public List<Account> FindAccountbyName(String name) {
		List<Account> list = new ArrayList<Account>();
		String sql = "SELECT * FROM `account` WHERE name like '%" + name + "%' ";
		list = jdbcTemplate.query(sql, new MapperAccount());
		return list;
	}

	public List<Account> listAcc(String name) {
		String SQL = "select * from account where name like ?";
		List<Account> accounts = jdbcTemplate.query(SQL, new Object[] { "%" + name + "%" }, new MapperAccount());
		return accounts;
	}

	public int addAccountStudent(Account account) {
		String sql = " INSERT INTO `account` (`id`, `name`, `mail`, `password`, `group_id`, `phone`, `role`, `isLeader`, `gender`) VALUES (?,?,?,?,?,?,?,?,?)";

		int count = _jdbcTemplate.update(sql,
				new Object[] { account.getId(), account.getName(), account.getMail(), account.getPassword(),
						account.getGroup_id(), account.getPhone(), account.getRole(), account.getIsLeader(),
						account.getGender() });
		return count;
	}

	public int updateStudentAccount(Account account) {
		String sql = " UPDATE `account` SET `name` = ? , `mail` = ? , `password` = ? ,`group_id` = ? , `phone` = ? , `role` = ? , `isLeader` = ? , `gender` = ? WHERE id = ?";
		int count = _jdbcTemplate.update(sql, account.getName(), account.getMail(), account.getPassword(),
				account.getGroup_id(), account.getPhone(), account.getRole(), account.getIsLeader(),
				account.getGender(), account.getId());
		return count;
	}

	public Account get(int id) {
		String sql = "SELECT * FROM account WHERE id=" + id;
		Account result = _jdbcTemplate.queryForObject(sql, new MapperAccount());
		return result;
	}

	public Group FindAccountName(String name) {
		String sql = "SELECT * FROM `account` WHERE name LIKE \"?%\" " + name;
		Group result = _jdbcTemplate.queryForObject(sql, new MapperGroup());
		return result;
	}
}
