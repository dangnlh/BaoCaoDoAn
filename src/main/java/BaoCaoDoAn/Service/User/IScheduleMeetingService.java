package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dto.project_scheduleMeeting;
import BaoCaoDoAn.Entity.Meeting;
import BaoCaoDoAn.Entity.ScheduleMeeting;
@Service
public interface IScheduleMeetingService {
	@Autowired
	public List<ScheduleMeeting> GetDataAdmin();
	
	@Autowired
	public List<project_scheduleMeeting> GetScheduleMeetingByProjectId(int id);
	
	@Autowired
	public void updateADMIN(ScheduleMeeting admin);

	
	@Autowired
	public List<Meeting> getMeetingByScheduleMeetingID(int id);
	@Autowired
	public void deleteADMIN(int id);
}

