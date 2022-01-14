package BaoCaoDoAn.Dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.MapperAccount;



@Repository
public class AccountDAO {
	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	public Account GetUserByAccount(Account account) {
		String sql = "Select * from account where mail = '"+account.getMail()+"' " ;
		Account result =  jdbcTemplate.queryForObject(sql, new MapperAccount()) ;
		return result ;
		
		
	}
	
//	public String validateUser(String mail , String password) {
//		  try {
//		String role = jdbcTemplate.queryForObject("SELECT role from account WHERE mail = ? AND password = ?"
//				, String.class , mail, password) ;
//		
//		if(role.length()> 1) {
//			return role;
//		}
//		  } catch (EmptyResultDataAccessException e) {
//		     System.out.println("No record found in database  ");
//		      return "";
//		    }
//	      return "";
//	}
}
