package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Entity.ScheduleMeeting;
@Service
public interface IScheduleMeetingService {
	@Autowired
	public List<ScheduleMeeting> GetDataAdmin();
	
	@Autowired
	public int updateADMIN(ScheduleMeeting admin);

	@Autowired
	public int saveADMIN(ScheduleMeeting admin);
	
	@Autowired
	public void deleteADMIN(int id);
}
