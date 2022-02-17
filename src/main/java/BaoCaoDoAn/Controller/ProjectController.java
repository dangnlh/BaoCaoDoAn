package BaoCaoDoAn.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Dao.ProjectDAO;
import BaoCaoDoAn.Entity.Project;
import BaoCaoDoAn.Entity.Report;
import BaoCaoDoAn.Service.User.ProjectServiceImpl;

@Controller
public class ProjectController {
	@Autowired
	private ProjectServiceImpl projectService ;
	@Autowired
	private ProjectDAO projectDao ;
	private ModelAndView mv = new ModelAndView() ;
	
	@RequestMapping(value = {"/teacher_getProject/{id}"})
	public ModelAndView teacherGetProjectById (@PathVariable int id) {
		List<Project> result = projectService.getProject(id) ;
		if(!result.isEmpty()) {
			mv.addObject("projectById" , result) ;	
	
			mv.setViewName("user/teacher");
		}			
		return mv ;	
	}
	
	@RequestMapping(value = {"/Project"})
	public ModelAndView getAllProject (Project project ) {
	
		mv.addObject("getAllProject" , projectService.getAllProject()) ;
		mv.addObject("project", new Project());
		mv.setViewName("admin/adminproject");
		return mv;		
	}
	
	@RequestMapping(value = "/add-project", method = RequestMethod.POST)
	public ModelAndView addReport( @ModelAttribute("project") Project project) {		
			mv.addObject("addproject" ,projectService.addProject(project)) ;		
		return new ModelAndView("redirect:/Project") ;
		
	}
		
	@RequestMapping(value = {"/deleteProject/{id}"})
	public ModelAndView DeleteReport (@PathVariable int id) {
		int result = projectService.deleteProject(id) ;
	
		if(result > 0 ) {
			System.out.println("thanh cong");
			projectService.deleteProject(id) ;			
		}			
		return new ModelAndView("redirect:/Project") ;	
	}
	
	@RequestMapping(value = {"/edit/{id}"})
	public ModelAndView getEditProject (@PathVariable int id) {
	
		mv.addObject("getProjectByid" ,projectService.getProjectById(id) ) ;
		mv.setViewName("user/editProject");
		mv.addObject("project", new Project());
	
		return mv;
		
	}
//	@RequestMapping(path = "/edit-Project/", method = RequestMethod.POST  )
//	public ModelAndView editeport( @ModelAttribute("project") Project project , @PathVariable int id) {		
//		System.out.println("thanhcong");
//			mv.addObject("edit" ,projectService.editProject(id)) ;		
//		return new ModelAndView("redirect:/Project") ;
//		
//	}
//	
}
