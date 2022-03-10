package BaoCaoDoAn.Service.User.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.ReportDAO;
import BaoCaoDoAn.Dao.ScheduleReportDAO;
import BaoCaoDoAn.Entity.Report;
import BaoCaoDoAn.Entity.ScheduleMeeting;
import BaoCaoDoAn.Service.User.IReportService;

@Service
public class ReportServiceImpl implements IReportService {
	@Autowired
	private ReportDAO reportDao;
	@Autowired
	private ScheduleReportDAO sheduleReportDao;

	public Report getReport(int id) {
		return reportDao.getReport(id);
	}

	public List<Report> getAllReport() {

		return reportDao.getAllReport();
	}

	public int addReport(Report report) {

		return reportDao.addReport(report);
	}

	public int editReport(int id, Report report) {
		return reportDao.editReport(id, report);
	}

	public List<Report> getAllReportByProjecId(int reportId) {

		return reportDao.getReportByProjectId(reportId);
	}
	
	public int gradeReport(Double point, int reportId) {
		// TODO Auto-generated method stub
		return reportDao.gradeReport(point, reportId);
	}

	public boolean WriteReportFile(Report report) {
		reportDao.saveFileReportFile(report.getUrlReport(), report.getId());
		return true;
	}
	public void deleteReport(Report report) {
		//Delete Constraints of Report
		sheduleReportDao.DeleteScheduleReportByReportId(report.getId());
		//Delete Report
		reportDao.DeleteReport(report.getId());
	}
}
