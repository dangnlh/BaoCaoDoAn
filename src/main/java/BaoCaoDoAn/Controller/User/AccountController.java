package BaoCaoDoAn.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Service.User.InforServiceImpl;

@Controller
public class AccountController {
	@Autowired
	InforServiceImpl inforService ;
	@RequestMapping(value = {"/student"})
	public ModelAndView info () {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/student");
		mv.addObject("info" , inforService.getStudentInfo());
		return mv ;
	}
}
