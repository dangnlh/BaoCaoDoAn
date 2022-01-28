package BaoCaoDoAn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Dao.ReportDAO;
import BaoCaoDoAn.Entity.Report;
import BaoCaoDoAn.Entity.ScheduleMeeting;
import BaoCaoDoAn.Entity.ScheduleReport;
import BaoCaoDoAn.Service.User.ReportServiceImpl;
import BaoCaoDoAn.Service.User.ScheduleReportServiceImpl;
@Controller
public class ReportController {
	@Autowired
	private ReportServiceImpl reportService ;

	@Autowired
	private ReportDAO reportDAO ;
	private ModelAndView mv = new ModelAndView() ;
	
	@RequestMapping(value = {"/editReport/{id}"})
	public ModelAndView report (@PathVariable String id) {


		mv.setViewName("user/editReport") ;
		mv.addObject("getReport" , reportService.getReport(Integer.parseInt(id))) ;
		return mv;
	
	}
	
	
	
	@RequestMapping(value = "/addreport", method = RequestMethod.POST)
	public String addReport( @ModelAttribute("report") Report report) {		
			mv.addObject("addReport" , reportService.addReport(report)) ;		
		return "redirect:/ScheduleReport";
		
	}
	
	@RequestMapping(value = {"/deleteReport/{id}"})
	public String DeleteReport (@PathVariable String id) {
		int result = reportDAO.DeleteReport(id);
	
		if(result > 0 ) {
			System.out.println("thanh cong");
			reportDAO.DeleteReport(id);
			
		}
	
		
		return "redirect:/ScheduleReport";
		
	}
	


}
