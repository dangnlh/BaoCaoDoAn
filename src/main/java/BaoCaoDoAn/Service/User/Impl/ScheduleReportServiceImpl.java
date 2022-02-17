package BaoCaoDoAn.Service.User.Impl;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.ScheduleReportDAO;

import BaoCaoDoAn.Entity.ScheduleReport;
import BaoCaoDoAn.Service.User.IScheduleReport;


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
public List<ScheduleReport> getAllScheduleReportByReportId(int reportId) {
	// TODO Auto-generated method stub
	
	return null;
}
public List<ScheduleReport> getAllScheduleReportByReportId() {
	// TODO Auto-generated method stub
	return null;
}
public List<ScheduleReport> getAllScheduleReportByTeacherId(int accountId) {
	// TODO Auto-generated method stub
	return scheduleReportDAO.getScheduleReportByAccountId(accountId);
}

}
