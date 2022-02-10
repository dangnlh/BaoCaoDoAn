package BaoCaoDoAn.Controller;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Dao.ReportDAO;
import BaoCaoDoAn.Dao.ScheduleReportDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Report;
import BaoCaoDoAn.Entity.ScheduleReport;
import BaoCaoDoAn.Service.User.ReportServiceImpl;
import BaoCaoDoAn.Service.User.ScheduleReportServiceImpl;

@Controller
public class ScheduleReportController {
	@Autowired
	private ScheduleReportServiceImpl  scheduleReportService ;
	
	@Autowired
	private ReportServiceImpl reportService ;
	
	private ModelAndView mv = new ModelAndView() ;

	@Autowired 
	private ScheduleReportDAO scheduleReportDAO ;
	

	@RequestMapping(value = {"/ScheduleReport"})
	public ModelAndView AllScheduleReport (Model model) {
	
		
		mv.setViewName("admin/adminschedulereport");
		mv.addObject("schedule" , new ScheduleReport()) ;
		mv.addObject("report", new Report());
		mv.addObject("getAllReport" , reportService.getAllReport() ) ;
		mv.addObject("getAllScheduleReport" , scheduleReportDAO.getAllScheduleReport() ) ;
		return mv;
		
	}

	@RequestMapping(value = "/addSchedule", method = RequestMethod.POST)
	
	public String addScheduleReport( @ModelAttribute("schedule") ScheduleReport scheduleReport ) {		
		
			mv.addObject("addSchedule" , scheduleReportDAO.addScheduleReport(scheduleReport) ) ;		
		return "redirect:/ScheduleReport";
		
	}
	
	@RequestMapping(value = {"/deleteScheduleReport/{id}"})
	public String DeleteScheduleReport (@PathVariable String id) {
		int result = scheduleReportDAO.DeleteScheduleReport(id);
		System.out.println("deleteScheduleReprot " + result);
		if(result > 0 ) {
			System.out.println("thanh cong");
			scheduleReportDAO.DeleteScheduleReport(id) ;
			
		}
	
		
		return "redirect:/ScheduleReport";
		
	}

}
