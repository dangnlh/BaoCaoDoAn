package BaoCaoDoAn.Service.User;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.ScheduleReportDAO;

import BaoCaoDoAn.Entity.ScheduleReport;


@Service
public class ScheduleReportServiceImpl implements IScheduleReport{
	@Autowired
	private ScheduleReportDAO scheduleReportDAO ;

	
public List<ScheduleReport> getAllScheduleReport() {	
		return scheduleReportDAO.getAllScheduleReport();
	}



public int addScheduleReport(ScheduleReport scheduleReport) {
	
	return scheduleReportDAO.addScheduleReport(scheduleReport);
}



}
