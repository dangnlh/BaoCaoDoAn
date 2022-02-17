package BaoCaoDoAn.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Dao.ScheduleReportDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Group;
import BaoCaoDoAn.Entity.Project;
import BaoCaoDoAn.Entity.Report;
import BaoCaoDoAn.Entity.ScheduleReport;
import BaoCaoDoAn.Service.User.Impl.GroupServiceImpl;
import BaoCaoDoAn.Service.User.Impl.ProjectServiceImpl;
import BaoCaoDoAn.Service.User.Impl.ReportServiceImpl;
import BaoCaoDoAn.Service.User.Impl.ScheduleReportServiceImpl;

@Controller
public class ScheduleReportController {
	@Autowired
	private ScheduleReportServiceImpl scheduleReportService;
	@Autowired
	private ReportServiceImpl reportService;
	@Autowired
	private ProjectServiceImpl projectService;
	@Autowired
	private GroupServiceImpl groupService;
	private ModelAndView mv = new ModelAndView();

	@Autowired
	private ScheduleReportDAO scheduleReportDAO;

	@RequestMapping(value = { "/ScheduleReport" })
	public ModelAndView AllScheduleReport(Model model) {

		mv.setViewName("admin/adminschedulereport");
		mv.addObject("schedule", new ScheduleReport());
		mv.addObject("report", new Report());
		mv.addObject("getAllReport", reportService.getAllReport());
		mv.addObject("getAllScheduleReport", scheduleReportDAO.getAllScheduleReport());
		return mv;

	}

	@RequestMapping(value = "/new")

	public ModelAndView addScheduleReport(@ModelAttribute("schedule") ScheduleReport scheduleReport) {
		mv.setViewName("admin/adminAddScheduleReport");
//			mv.addObject("addSchedule" , scheduleReportDAO.addScheduleReport(scheduleReport) ) ;		
		return mv;

	}

	@RequestMapping(value = { "/deleteScheduleReport/{id}" })
	public String DeleteScheduleReport(@PathVariable String id) {
		int result = scheduleReportDAO.DeleteScheduleReport(id);
		System.out.println("deleteScheduleReprot " + result);
		if (result > 0) {
			System.out.println("thanh cong");
			scheduleReportDAO.DeleteScheduleReport(id);

		}

		return "redirect:/ScheduleReport";

	}

	@RequestMapping(value = "/teacher_viewReportSchedule")
	public ModelAndView viewReportSchedule(HttpSession session) {
		System.out.println("In View Report");
		Account teacher =(Account) session.getAttribute("InforAccount");
		
		System.out.println(teacher.getId());
		ModelAndView mv = new ModelAndView();
		List<Project> teachingProjects = projectService.getProjectByTeacherId(teacher.getId());
		
		System.out.println(teachingProjects.size());
		List<Group> groups = new ArrayList<Group>();
		for(Project tempProject:teachingProjects) {
			Group group = groupService.getGroupByProjectId(tempProject.getId());
			if(group!=null) {
				groups.add(group);
			}
		}
		mv.addObject("groupList",groups);
		mv.addObject("projectList",teachingProjects);
		mv.setViewName("user/teacher");
		return mv;
	}

}
