package BaoCaoDoAn.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import BaoCaoDoAn.Dao.ReportDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Project;
import BaoCaoDoAn.Entity.Report;
import BaoCaoDoAn.Entity.ScheduleMeeting;
import BaoCaoDoAn.Entity.ScheduleReport;
import BaoCaoDoAn.Service.User.Impl.GroupServiceImpl;
import BaoCaoDoAn.Service.User.Impl.ProjectServiceImpl;
import BaoCaoDoAn.Service.User.Impl.ReportServiceImpl;
import BaoCaoDoAn.Service.User.Impl.ScheduleReportServiceImpl;

@Controller
public class ReportController {
	@Autowired
	GroupServiceImpl groupServiceImpl;
	@Autowired
	private ReportServiceImpl reportService;
	@Autowired
	private ProjectServiceImpl projectSerivce;
	@Autowired
	private ReportDAO reportDAO;
	private ModelAndView mv = new ModelAndView();

	@RequestMapping(value = { "/editReport/{id}" })
	public ModelAndView report(@PathVariable String id) {
		mv.setViewName("user/editReport");
		mv.addObject("getReport", reportService.getReport(Integer.parseInt(id)));
		return mv;

	}

	@RequestMapping(value = "/addreport", method = RequestMethod.POST)
	public String addReport(@ModelAttribute("report") Report report) {
		mv.addObject("addReport", reportService.addReport(report));
		return "redirect:/ScheduleReport";

	}

	@RequestMapping(value = { "/deleteReport/{id}" })
	public String DeleteReport(@PathVariable String id) {
		int result = reportDAO.DeleteReport(id);

		if (result > 0) {
			System.out.println("thanh cong");
			reportDAO.DeleteReport(id);

		}

		return "redirect:/ScheduleReport";

	}

	@GetMapping(value = "teacher_viewReport")
	public ModelAndView viewReport(HttpSession session) {
		Account teacher = (Account) session.getAttribute("InforAccount");
		ModelAndView mv = new ModelAndView();
		List<Project> managedProject = projectSerivce.getProjectByTeacherId(teacher.getId());
		
		List<Report> reports = new ArrayList<Report>();
		for (Project project : managedProject) {
			List<Report> reportsTemp = reportService.getAllReportByProjecId(project.getId());
			for (Report reportInner : reportsTemp) {
				reportInner.setGroup(groupServiceImpl.getGroupByProjectId(reportInner.getProject_id()));
				reports.add(reportInner);
				
			}
		}
		mv.addObject("reportList", reports);
		mv.setViewName("user/teacher/teacherReport");
		return mv;
	}

	@RequestMapping(value = "/teacher_grade/{reportId}")
	public ModelAndView getReportToGrade(@PathVariable int reportId, HttpSession session) {
		Account teacher = (Account) session.getAttribute("InforAccount");
		ModelAndView mv = new ModelAndView();
		if (teacher != null) {
			Report report = reportService.getReport(reportId);
			mv.addObject("report", report);
			mv.setViewName("user/teacher/grade");
		} else {
			// return error page, for later
		}
		return mv;
	}

	@PostMapping(value = "/processGrade")
	public String processGrade(@Valid @ModelAttribute("report") Report report, BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			System.out.println(theBindingResult);
			return "user/grade";
		} else {
			// do some work here
			reportService.gradeReport(report.getPoint(), report.getId());
			return "redirect:/teacher_viewReport";
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

}
