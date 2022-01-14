package BaoCaoDoAn.Service.User;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Entity.Account;

@Service
public interface IAccountService {
	
		@Autowired
		public Account CheckAccount(Account account) ;
}
