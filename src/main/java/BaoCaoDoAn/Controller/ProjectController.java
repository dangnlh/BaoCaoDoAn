package BaoCaoDoAn.Controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Dao.AccountDAO;
import BaoCaoDoAn.Dao.ProjectDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Project;
import BaoCaoDoAn.Entity.Report;
import BaoCaoDoAn.Service.User.Impl.AccountServiceImpl;
import BaoCaoDoAn.Service.User.Impl.GroupServiceImpl;
import BaoCaoDoAn.Service.User.Impl.ProjectServiceImpl;

@Controller
public class ProjectController {
	@Autowired
	AccountDAO accountDao;
	@Autowired
	GroupServiceImpl groupServiceImpl;
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

	@RequestMapping(value = "/addProject", method = RequestMethod.GET)
	public ModelAndView doGetAddProject(Model model, HttpSession session) {
		if (!model.containsAttribute("ProjectUpdateAndInsert")) {
			model.addAttribute("ProjectUpdateAndInsert", new Project());
		}
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		mv.addObject("TIMENOW", date);

		mv.addObject("teacher", accountDao.getTeacherAdmin());
		mv.addObject("groups", groupServiceImpl.getGroupAdmin());
		mv.addObject("getAllProject", projectService.getAllProject());
		mv.setViewName("/admin/addProject");
		return mv;

	}

	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("ProjectUpdateAndInsert") Project project,
			BindingResult bindingResult) {
//		System.out.println(bindingResult);
		if (bindingResult.hasErrors()) {
			mv.setViewName("/admin/addProject");

		} else {
			projectService.addProject(project);
			return new ModelAndView("redirect:/AdminProject");
		}

		return mv;

	}

	@GetMapping(value = "/editProject/{id}")
	public ModelAndView getEditProject(@PathVariable("id") int id) {
		mv.addObject("getProjectbyId", projectService.getProjectById(id));
		mv.setViewName("/admin/editProject");
		mv.addObject("teacher", accountDao.getTeacherAdmin());
		mv.addObject("groups", groupServiceImpl.getGroupAdmin());
		return mv;

	}

	@PostMapping(value = "/editProject")
	public ModelAndView edit(@Valid @ModelAttribute("project") Project project, BindingResult bindingResult) {
		System.out.println("project id = " + project.getId());
		System.out.println("project  = " + project);
		if (bindingResult.hasErrors()) {
			mv.setViewName("/admin/editProject");

		} else {
			projectService.editProject(project.getId(), project);
			return new ModelAndView("redirect:/AdminProject");
		}

		return mv;

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
