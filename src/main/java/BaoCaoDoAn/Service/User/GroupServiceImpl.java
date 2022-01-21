package BaoCaoDoAn.Service.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.GroupDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Groups;
@Service
public class GroupServiceImpl implements IGroupService {
	@Autowired
	private GroupDAO groupdao;
	
	public List<Groups> getGroupAdmin() {
		return groupdao.getGroupAdmin();
	}

	public void deleteStudentInGroup(int id) {
		 groupdao.delete(id);
	}

	public Account getGroupID(int accountId) {
		return groupdao.get(accountId);
	}
	public List<Account> GetDataGroup(int id) {
		List<Account> list = new ArrayList<Account>();
		list = groupdao.GetGroup(id);
		if (list == null) {

			return null;
		}
		return list;
	}
}
