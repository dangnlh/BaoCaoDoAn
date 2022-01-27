package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.ReportDAO;
import BaoCaoDoAn.Entity.Report;

@Service
public class ReportServiceImpl implements IReportService{
@Autowired
	private ReportDAO reportDao ; 
	public List<Report> getReport(int id) {
		
		return reportDao.getReport(id) ;
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

}
