package BaoCaoDoAn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import javax.servlet.http.HttpSession;
import BaoCaoDoAn.Dao.AccountDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Service.User.AccountServiceImpl;

@Controller
public class AccountController {
	@Autowired
	AccountServiceImpl accountService ;
	private ModelAndView mv = new ModelAndView() ;
	
	@RequestMapping(value = {"/", "/login"})
	public ModelAndView Login() {
		mv.setViewName("/login");
		mv.addObject("account" , new Account());
		return mv ;
	}
	
	@RequestMapping(value =  "/dang-nhap", method = RequestMethod.POST)
	public String Login(@ModelAttribute("account") Account account ,  HttpSession session) {
		
	
		account  = accountService.CheckAccount(account) ;
		System.out.println(account);
		if(account != null ) {
			mv.addObject("status" , "login thanh cong") ;
			session.setAttribute("inforAccount", account);
				
		}else {
			mv.addObject("status" , "login that bai") ;
		}
		
//		System.out.println(account.getMail() +  "-" + account.getGroup_id());
		return "/user/student" ;
	}
	
	
//	@PostMapping("/doLogin")
//	public String checkUser(@RequestParam String mail , @RequestParam String password, Model model ) {
//		String loginFlag = loginDao.validateUser(mail, password) ;
//		System.out.println(loginFlag);
//		if(loginFlag.equals("student") ) {
//			model.addAttribute("message" , mail) ;	
//			model.addAttribute("message2" , password) ;		
//			return "user/student" ;	
//		}
//		
//		if(loginFlag.equals("admin") ) {
//			model.addAttribute("message" , mail) ;	
//			model.addAttribute("message2" , password) ;		
//			return "admin/admin" ;	
//		}
//		if(loginFlag.equals("teacher") ) {
//			model.addAttribute("message" , mail) ;	
//			model.addAttribute("message2" , password) ;		
//			return "user/teacher" ;	
//		}
//		if(loginFlag.isEmpty() ) {
//			model.addAttribute("message" , "that bai") ;	
//			return "login" ;	
//			}
//		return "login" ;	
//
//	}


}
