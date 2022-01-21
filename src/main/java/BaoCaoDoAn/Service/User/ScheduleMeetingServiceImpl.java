package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.ScheduleMeetingDAO;
import BaoCaoDoAn.Entity.ScheduleMeeting;
@Service
public class ScheduleMeetingServiceImpl implements IScheduleMeetingService {
	@Autowired
	private ScheduleMeetingDAO scheduleMeetingDAO;
	
	public List<ScheduleMeeting> GetDataAdmin() {
		return scheduleMeetingDAO.GetDataAmin();
	}

	public int saveADMIN(ScheduleMeeting admin) {
		return scheduleMeetingDAO.save(admin);
	}

	public int updateADMIN(ScheduleMeeting admin) {
		return scheduleMeetingDAO.update(admin);

	}

	public void deleteADMIN(int id) {
		scheduleMeetingDAO.delete(id);
	}

	
	
}
