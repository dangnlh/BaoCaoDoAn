package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import BaoCaoDoAn.Entity.Report;

@Service
public interface IReportService {
	
	@Autowired
	public List<Report> getReport(int id) ;
	
	@Autowired
	public List<Report> getAllReport() ;
	
	@Autowired
	public int addReport(Report report);
	
	@Autowired
	public int editReport(int id);
	
}
