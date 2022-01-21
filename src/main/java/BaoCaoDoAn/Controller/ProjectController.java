package BaoCaoDoAn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Service.User.ProjectServiceImpl;

@Controller
public class ProjectController {
	@Autowired
	private ProjectServiceImpl projectService ;
	
	private ModelAndView mv = new ModelAndView() ;
	@RequestMapping(value = {"dang-nhap/project/byGroupID/{id}"})
	public ModelAndView project (@PathVariable String id) {
		mv.setViewName("user/project");
		mv.addObject("getProject" , projectService.getProject(Integer.parseInt(id))) ;
		return mv;
		
	}
	
	
	
}
