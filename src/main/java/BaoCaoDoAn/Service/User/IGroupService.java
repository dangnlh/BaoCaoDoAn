package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Group;
@Service
public interface IGroupService {
	@Autowired
	public List<Group> getGroupAdmin();
	
	@Autowired
	public void deleteStudentInGroup(int id);
	
	@Autowired
	public Account getGroupID(int accountId);
	
	@Autowired
	public List<Account> GetDataGroup(int id);
}
