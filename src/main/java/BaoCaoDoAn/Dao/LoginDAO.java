package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.MapperAccount;

@Repository
public class LoginDAO {
	@Autowired
	JdbcTemplate jdbcTemplate ;
	
//	public List<Account> Login(){
//		List<Account> list = new ArrayList<Account>();
//		String sql = " SELECT mail   FROM `account`  " ;
//		list = jdbcTemplate.query(sql,new MapperAccount());
//		return list;	
//	}
	
	public String validateUser(String mail , String password) {
		  try {
		String role = jdbcTemplate.queryForObject("SELECT role from account WHERE mail = ? AND password = ?"
				, String.class , mail, password) ;
		
		if(role.length()> 1) {
			return role;
		}
		  } catch (EmptyResultDataAccessException e) {
		     System.out.println("No record found in database  ");
		      return "";
		    }
	      return "";
	}
}
