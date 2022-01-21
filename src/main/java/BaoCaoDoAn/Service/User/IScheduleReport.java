package BaoCaoDoAn.Service.User;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import BaoCaoDoAn.Entity.ScheduleReport;

@Service
public interface IScheduleReport {
//	@Autowired
//	public List<ScheduleReport> getScheduleReport(int id) ;
	@Autowired
	public List<ScheduleReport> getAllScheduleReport()  ;
		
	@Autowired
	public ScheduleReport AddScheduleReport(int id , Date timeReport , int account_id , int report_id)  ;
	
}
