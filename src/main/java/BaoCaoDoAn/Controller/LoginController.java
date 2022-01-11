package BaoCaoDoAn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Dao.HomeDAO;
import BaoCaoDoAn.Entity.MapperAccount;

@Controller
public class LoginController {
	@Autowired
	HomeDAO homeDao ;
 
	@RequestMapping(value = {"/" , "trang-chu"} )
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("user/login") ;
		mv.addObject("login" , homeDao.Login());
		return mv ;
	}
	
}
