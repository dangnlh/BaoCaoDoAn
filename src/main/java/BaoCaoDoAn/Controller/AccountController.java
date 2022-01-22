package BaoCaoDoAn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import BaoCaoDoAn.Dao.AccountDAO;
import BaoCaoDoAn.Dao.ScheduleReportDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.ScheduleReport;
import BaoCaoDoAn.Service.User.AccountServiceImpl;
import BaoCaoDoAn.Service.User.ReportServiceImpl;
import BaoCaoDoAn.Service.User.ScheduleReportServiceImpl;

@Controller
public class AccountController {
	@Autowired
	AccountServiceImpl accountService ;
	
	@Autowired 
	private ScheduleReportDAO scheduleReportDAO ;
	
	private ModelAndView mv = new ModelAndView() ;
	
	@RequestMapping(value = {"/", "/login"})
	public ModelAndView Login() {
		mv.setViewName("/loginpage");
		mv.addObject("account" , new Account());
		mv.addObject("schduleReport" ,  new ScheduleReport()) ;
		mv.addObject("scheduleReportDAO" , scheduleReportDAO.getAllScheduleReport());
		return mv ;
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value =  "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView Login(@ModelAttribute("account") Account account ,  HttpSession session) {
		
		Account acc = accountService.CheckAccount(account) ;
	

		if(acc != null && acc.getRole().equals("student")) {	
		    mv.setViewName("/user/student");
			mv.addObject("statusLogin" , "login thanh cong");
		
		}if(acc != null && acc.getRole().equals("teacher")) {			
			mv.setViewName("/user/teacher");					
			mv.addObject("statusLogin" , "login thanh cong");

		}if(acc != null && acc.getRole().equals("admin")) {			
			mv.setViewName("/admin/admin2");					
			mv.addObject("statusLogin" , "login thanh cong");

		}
		
		else if(acc == null){
			mv.setViewName("/loginpage");
			mv.addObject("statusLogin" , "login failed");
		}	
			return mv ;
	}
	
	@RequestMapping(value =  "/dang-ky", method = RequestMethod.GET)
		public ModelAndView DangKy() {
			mv.setViewName("/registrationpage");
			mv.addObject("account" , new Account()) ;
			return mv ;
		}
	@RequestMapping(value =  "/dang-ky", method = RequestMethod.POST)
	public ModelAndView DangKy(@ModelAttribute("account") Account account) {
		
		int count = accountService.AddAccount(account) ;
		System.out.println(count);
		
		if(count == 1   ) {
			mv.addObject("statusRegister" , "Ä�Äƒng KÃ­ thÃ nh CÃ´ng") ;
		}else if(count == 2 ) {
			mv.addObject("statusRegister" , "Ä�Äƒng KÃ­ tháº¥t báº¡i") ;
		}
		System.out.println("thanhcong");
		mv.setViewName("/registrationpage");
		return mv;
		
	}

//	@Autowired
//	private ScheduleReportServiceImpl  scheduleReportService ;
//	@RequestMapping(value =  "/dang-nhap", method = RequestMethod.POST)
//	
//	
//	public String AddScheduleReport(
//			@ModelAttribute("schduleReport") ScheduleReport schduleReport) {
//		
//		schduleReport =  scheduleReportService.AddScheduleReport(schduleReport.getId() ,(Date) schduleReport.getTimeReport(),
//				schduleReport.getAccount_id(), schduleReport.getReport_id()) ;
//		
//		
//		if(schduleReport != null) {
//			return "/user/AddSchedule" ;
//		}else {
//			mv.addObject("success" , "Add fail") ;
//		}
//		
//		return "/user/student" ;
//	
//	}
	
}
