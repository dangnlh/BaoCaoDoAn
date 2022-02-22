package BaoCaoDoAn.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.MapperAccount;

@Repository
public class StudentDAO {

	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	//Student List
	public Account getStudentByAccount(Account account) {
	    String sql = "SELECT * FROM account WHERE role=" + account.getRole();
	    Account result =  jdbcTemplate.queryForObject(sql, new MapperAccount()) ;
		return result ;
	}
	public Account GetStudentByAccount(Account account) {
		try {

			System.out.println(account.getMail());
			System.out.println(account.getPassword());
		String sql = "Select * from account where role = " + account.getRole() ;
		
		Account result =  jdbcTemplate.queryForObject(sql, new MapperAccount()) ;
		if(result != null) {
			return result ;	
		}
		}catch (EmptyResultDataAccessException e ) {
			
		     return null;
		}
		return null ;	
	}

}
