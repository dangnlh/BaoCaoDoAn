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

import BaoCaoDoAn.Dao.ScheduleReportDAO;
import BaoCaoDoAn.Entity.Account;
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
	
//	@RequestMapping(value = {"dang-nhap/reportSchedule/byAccountID/{id}"})
//	public ModelAndView ScheduleReport (@PathVariable String id) {
//		mv.setViewName("user/scheduleReport");
//		mv.addObject("getScheduleReport" ,scheduleReportService.getScheduleReport(Integer.parseInt(id)) ) ;
//		return mv;
//		
//	}
	
	@Autowired 
	private ScheduleReportDAO scheduleReportDAO ;
	
	
	@RequestMapping(value = {"/dang-nhap"})
	public ModelAndView AllScheduleReport (Model model) {
		
		mv.setViewName("user/scheduleReport");
		mv.addObject("schduleReport" ,  new ScheduleReport()) ;
	
		mv.addObject("getAllReport" , reportService.getAllReport() ) ;
		mv.addObject("getAllScheduleReport" , scheduleReportDAO.getAllScheduleReport() ) ;
		return mv;
		
	}

}
