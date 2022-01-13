package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.User.AccountDAO;
import BaoCaoDoAn.Entity.Account;
@Service
public class InforServiceImpl implements IInforService{
	@Autowired
	private AccountDAO accountDao ;
	public List<Account> getStudentInfo() {
		
		return accountDao.GetStudentInfo();
	}

}
