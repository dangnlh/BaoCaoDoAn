package BaoCaoDoAn.Dao;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.MapperAccount;



@Repository
public class AccountDAO {
	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	public Account GetUserByAccount(Account account) {
		try {
//			 String mail = account.getMail() ;
//			 String pass = account.getPassword() ;
//			 System.out.println("mail :" + mail);
//			 System.out.println("pass :" + pass);
//		
//		        if (pass.isEmpty()) {
//		         pass = account.setPassword("");
//		         System.out.println("set password: " +pass);
//		        } 
//		        if(mail.isEmpty()) {
//		        	mail = account.setMail("");
//		
//		        }
			System.out.println(account.getMail());
			System.out.println(account.getPassword());
		String sql = "Select * from account where mail = '"+account.getMail()+"' and password =  '"+account.getPassword()+"' " ;
		
		Account result =  jdbcTemplate.queryForObject(sql, new MapperAccount()) ;
		if(result != null) {
			return result ;	
		}
		}catch (EmptyResultDataAccessException e ) {
			
		     return null;
		}
		return null ;	
	}

	
	public int AddAccount(Account account) {	
		StringBuffer sql = new StringBuffer();		
					sql.append("INSERT INTO account (name, mail,password,phone,role,isLeader) "
							+ "VALUES ('"+account.getName()+"', '"+account.getMail()+"'"
							+ ",'"+account.getPassword()+"', '"+account.getPhone()+"'"
							+ " ,'"+account.getRole()+"',"+account.getIsLeader()+");");								
		int insert = jdbcTemplate.update(sql.toString()) ; 					
		return insert;
		
	}
	
	public SqlRowSet Checkmail() {
		
		
		String sql = "SELECT mail FROM `account`  " ;
		SqlRowSet acc = jdbcTemplate.queryForRowSet(sql) ;
		return 	 acc;
	
		
	
	}
}

