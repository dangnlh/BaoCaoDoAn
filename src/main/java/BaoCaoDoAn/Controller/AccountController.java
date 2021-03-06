package BaoCaoDoAn.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Dao.AccountDAO;
import BaoCaoDoAn.Dao.ScheduleReportDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.ScheduleReport;
import BaoCaoDoAn.Service.User.IProjectService;
import BaoCaoDoAn.Service.User.Impl.AccountServiceImpl;

@Controller
public class AccountController {
	@Autowired
	AccountServiceImpl accountService;
	@Autowired
	AccountDAO accountDao;
	@Autowired
	private ScheduleReportDAO scheduleReportDAO;
	@Autowired
	private IProjectService projectService;

	private ModelAndView mv = new ModelAndView();

	@RequestMapping(value = { "/", "/login" })
	public ModelAndView Login() {
		mv.setViewName("/loginpage");
		mv.addObject("account", new Account());
		mv.addObject("schduleReport", new ScheduleReport());
		mv.addObject("scheduleReportDAO", scheduleReportDAO.getAllScheduleReport());
		return mv;
	}

	@RequestMapping(value = "/trang-chu")
	public ModelAndView HomeTeacher(@ModelAttribute("account") Account account, HttpSession session) {
		mv.setViewName("/user/teacher");
		return mv;

	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView Login(@ModelAttribute("account") Account account, HttpSession session) {
		Account acc = accountService.CheckAccount(account);
		if (acc != null && acc.getRole().equals("student")) {
			session.setAttribute("InforAccount", accountDao.GetUserByAccount(account));
			mv.addObject("InforAccount", accountDao.GetUserByAccount(account));
			mv.setViewName("/user/student");
//			mv.addObject("statusLogin", "login thanh cong");
			mv.addObject("statusLogin", "");

		}
		if (acc != null && acc.getRole().equals("teacher")) {
			mv.setViewName("/user/teacher");
			session.setAttribute("InforAccount", accountDao.GetUserByAccount(account));
			mv.addObject("InforAccount", accountDao.GetUserByAccount(account));
//			mv.addObject("statusLogin", "login thanh cong");
			mv.addObject("statusLogin", "");
		}
		if (acc != null && acc.getRole().equals("admin")) {
			mv.setViewName("/admin/admin");
//			mv.addObject("statusLogin", "login thanh cong");
			mv.addObject("statusLogin", "");
		}

		else if (acc == null) {
			mv.setViewName("/loginpage");
			mv.addObject("statusLogin", "login failed");
		}
		return mv;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView DangKy() {
		mv.setViewName("/registrationpage");
		mv.addObject("account", new Account());
		return mv;
	}
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView DangKy(@ModelAttribute("account") Account account) {

		int count = accountService.AddAccount(account);

		

		if (count == 1) {
			mv.addObject("statusRegister", "????ng k?? th??nh c??ng");
		} else if (count == 2) {
			mv.addObject("statusRegister", "????ng k?? th???t b???i");
		}
		
		mv.setViewName("/registrationpage");
		return mv;

	}

	@RequestMapping(value = "/logout")
	public ModelAndView LogOut() {
		mv.setViewName("/loginpage");
		mv.addObject("statusLogin", " ");
		return mv;
	}

	@RequestMapping(value = "/studenthome")
	public ModelAndView StudentHome() {
		mv.setViewName("/user/student");

		return mv;
	}

	@RequestMapping(value = "/searchAccount")
	public ModelAndView searchAccount() {
		mv.setViewName("/loginpage");
		mv.addObject("account", new Account());
		mv.addObject("schduleReport", new ScheduleReport());
		mv.addObject("scheduleReportDAO", scheduleReportDAO.getAllScheduleReport());
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
