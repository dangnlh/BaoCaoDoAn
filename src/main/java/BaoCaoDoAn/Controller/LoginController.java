package BaoCaoDoAn.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import BaoCaoDoAn.Dao.LoginDAO;



@Controller
public class LoginController {
	@Autowired
	LoginDAO loginDao ;
	private ModelAndView mv = new ModelAndView() ;
	
	@RequestMapping(value = {"/", "/login"})
	public String getLoginPage() {
		return "login" ;
	}
	
	@PostMapping("/doLogin")
	public String checkUser(@RequestParam String mail , @RequestParam String password, Model model ) {
		String loginFlag = loginDao.validateUser(mail, password) ;
		System.out.println(loginFlag);
		if(loginFlag.equals("student") ) {
			model.addAttribute("message" , mail) ;	
			model.addAttribute("message2" , password) ;		
			return "user/student" ;	
		}
		
		if(loginFlag.equals("admin") ) {
			model.addAttribute("message" , mail) ;	
			model.addAttribute("message2" , password) ;		
			return "admin/admin" ;	
		}
		if(loginFlag.equals("teacher") ) {
			model.addAttribute("message" , mail) ;	
			model.addAttribute("message2" , password) ;		
			return "user/teacher" ;	
		}
		if(loginFlag.isEmpty() ) {
			model.addAttribute("message" , "that bai") ;	
			return "login" ;	
			}
		return "login" ;	
			
	
	
	
	
	}


}
