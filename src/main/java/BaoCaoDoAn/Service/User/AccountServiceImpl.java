package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.AccountDAO;
import BaoCaoDoAn.Entity.Account;



@Service
public class AccountServiceImpl implements IAccountService{
	@Autowired
	private AccountDAO accountDao ;
	
	
	public Account CheckAccount(Account account) {

		account = accountDao.GetUserByAccount(account) ;
		
		if(account == null) {
		
			return null ;
		}
		return account;
	}


	


}
