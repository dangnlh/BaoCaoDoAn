package BaoCaoDoAn.Service.User;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.ScheduleReportDAO;
import BaoCaoDoAn.Entity.ScheduleReport;


@Service
public class ScheduleReportServiceImpl implements IScheduleReport{
	@Autowired
	private ScheduleReportDAO scheduleReportDAO ;
//	public List<ScheduleReport> getScheduleReport(int id) {
//		
//		return scheduleReportDAO.getScheduleReport(id);
//	}
	
	
public List<ScheduleReport> getAllScheduleReport() {	
		return scheduleReportDAO.getAllScheduleReport();
	}








public ScheduleReport AddScheduleReport(int id ,java.sql.Date timeReport, int account_id, int report_id) {
	ScheduleReport sr = scheduleReportDAO.AddScheduleReport(id ,timeReport , account_id, report_id);
	if(sr == null) {
		return null ;	}
	return sr;
}









}
