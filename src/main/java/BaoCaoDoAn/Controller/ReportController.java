package BaoCaoDoAn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Service.User.ReportServiceImpl;
@Controller
public class ReportController {
	@Autowired
	private ReportServiceImpl reportService ;
	
	private ModelAndView mv = new ModelAndView() ;
	@RequestMapping(value = {"dang-nhap/project/byGroupID/report/{id}"})
	public ModelAndView report (@PathVariable String id) {
		mv.setViewName("user/report");
		mv.addObject("getReport" , reportService.getReport(Integer.parseInt(id))) ;
		return mv;
	
	}
	
	

//	@RequestMapping(value = {"/dang-nhap/scheduleReport"})
//	public ModelAndView getAllReport () {
//		mv.setViewName("user/scheduleReport");
//		mv.addObject("getAllReport" , reportService.getAllReport() ) ;
//		return mv;
//		
//	}
}
