package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Entity.Account;

@Service
public interface IInforService {
		@Autowired
		public List<Account> getStudentInfo() ;
}
