package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.MapperAccount;

@Repository
public class HomeDAO {
	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	public List<Account> Login(){
		List<Account> list = new ArrayList<Account>();
		String sql = "Select * from account" ;
		list = jdbcTemplate.query(sql,new MapperAccount());
		return list;
		
	}
}
