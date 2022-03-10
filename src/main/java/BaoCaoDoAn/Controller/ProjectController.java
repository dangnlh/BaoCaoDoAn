package BaoCaoDoAn.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Dao.ProjectDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Project;
import BaoCaoDoAn.Entity.Report;
import BaoCaoDoAn.Service.User.Impl.AccountServiceImpl;
import BaoCaoDoAn.Service.User.Impl.ProjectServiceImpl;

@Controller
public class ProjectController {
	@Autowired
	private ProjectServiceImpl projectService;
	@Autowired
	private ProjectDAO projectDao;
	@Autowired
	private AccountServiceImpl accountService;
	private ModelAndView mv = new ModelAndView();

	@RequestMapping(value = { "/teacher_getProject/{id}" })
	public ModelAndView teacherGetProjectById(@PathVariable int id) {
		List<Project> result = projectService.getProjectByTeacherId(id);
		if (!result.isEmpty()) {
			mv.addObject("projectById", result);
			mv.setViewName("user/teacher/teacherProject");
		}
		return mv;
	}

	@RequestMapping(value = { "/AdminProject" })
	public ModelAndView getAllProject(Project project) {
		mv.setViewName("admin/adminproject");
		mv.addObject("getAllProject", projectService.getAllProject());
		mv.addObject("project", new Project());

		return mv;
	}

//	@RequestMapping(value = "/addProject")
//	public ModelAndView addProject() {
//		mv.setViewName("admin/addProject");
//		return mv;
//			
//		mv.addObject("addproject", projectService.addProject(project));
//		return new ModelAndView("redirect:/Project");
//
//	}

	@RequestMapping(value = "/addProject", method = RequestMethod.GET)
	public String doGetAddProject(Model model) {
		if (!model.containsAttribute("ProjectUpdateAndInsert")) {
			model.addAttribute("ProjectUpdateAndInsert", new Project());
		}
		return "admin/addProject";

	}

	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("ProjectUpdateAndInsert") Project project) {

		
			projectService.addProject(project);
		
		return new ModelAndView("redirect:/AdminProject");

	}

	@RequestMapping(value = "/editProject", method = RequestMethod.GET)
	public ModelAndView getEditProject(HttpServletRequest request) {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		Project project = projectService.getProjectById(id);
		mv.setViewName("/admin/editProject");
		
		mv.addObject("ProjectUpdateAndInsert", project);
		return mv; 
		
	}
	@RequestMapping(value = "/editProject", method = RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute("ProjectUpdateAndInsert") Project project) {

		
			projectService.editProject(project);

		
		return new ModelAndView("redirect:/AdminProject");

	}
	

	@RequestMapping(value = { "/deleteProject/{id}" })
	public ModelAndView DeleteReport(@PathVariable int id) {
		int result = projectService.deleteProject(id);

		if (result > 0) {
			System.out.println("thanh cong");
			projectService.deleteProject(id);
		}
		return new ModelAndView("redirect:/AdminProject");
	}

	@RequestMapping(value = "/studentProject")
	public ModelAndView getProject(HttpSession session) {
		Account student = (Account) session.getAttribute("InforAccount");
		Project project = projectService.getProjectByGroupId(student.getGroup_id());
		Account teacher = accountService.getAccountById(project.getTeacherId());
		mv.addObject("project", project);
		mv.addObject("teacher", teacher);
		mv.setViewName("user/student/studentProject");
		return mv;
	}

}
