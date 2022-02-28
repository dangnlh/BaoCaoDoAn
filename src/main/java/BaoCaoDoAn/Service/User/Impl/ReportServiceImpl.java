package BaoCaoDoAn.Service.User.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.ReportDAO;
import BaoCaoDoAn.Entity.Report;
import BaoCaoDoAn.Service.User.IReportService;

@Service
public class ReportServiceImpl implements IReportService{
@Autowired
	private ReportDAO reportDao ; 
	public Report getReport(int id) {		
		return reportDao.getReport(id);
	}
	public List<Report> getAllReport() {
		
		return reportDao.getAllReport();
	}
	public int addReport(Report report) {
		
		return reportDao.addReport(report);
	}
	public int editReport(int id) {
		
		return reportDao.editReport(id);
	}
public List<Report> getAllReportByProjecId(int reportId) {
	
		return reportDao.getReportByProjectId(reportId);
	}
public int gradeReport(Double point, int reportId) {
		// TODO Auto-generated method stub
		return reportDao.gradeReport(point, reportId);
	}
}
