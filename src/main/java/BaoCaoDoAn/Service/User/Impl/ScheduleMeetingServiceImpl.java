package BaoCaoDoAn.Service.User.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.ScheduleMeetingDAO;
import BaoCaoDoAn.Entity.Meeting;
import BaoCaoDoAn.Entity.ScheduleMeeting;
import BaoCaoDoAn.Service.User.IScheduleMeetingService;
@Service
public class ScheduleMeetingServiceImpl implements IScheduleMeetingService {
	@Autowired
	private ScheduleMeetingDAO scheduleMeetingDAO;
	
	public List<ScheduleMeeting> GetDataAdmin() {
		return scheduleMeetingDAO.GetDataAmin();
	}

	
	public List<ScheduleMeeting> GetScheduleMeetingByProjectId(int id) {
		return scheduleMeetingDAO.GetScheduleMeetingByProjectId(id);
	}
	
	public void updateADMIN(ScheduleMeeting admin) {
		 scheduleMeetingDAO.updateAndSave(admin);
	}

	public void deleteADMIN(int id) {
		scheduleMeetingDAO.delete(id);
	}



	public List<Meeting> getMeetingByScheduleMeetingID(int id) {
		return scheduleMeetingDAO.GetMeetingByScheduleMeetingID(id);
	}

	
	
}

