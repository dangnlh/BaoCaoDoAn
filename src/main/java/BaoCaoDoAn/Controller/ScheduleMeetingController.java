package BaoCaoDoAn.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import BaoCaoDoAn.Dao.ScheduleMeetingDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Group;
import BaoCaoDoAn.Entity.Meeting;
import BaoCaoDoAn.Entity.Project;
import BaoCaoDoAn.Entity.ScheduleMeeting;
import BaoCaoDoAn.Service.User.Impl.GroupServiceImpl;
import BaoCaoDoAn.Service.User.Impl.ProjectServiceImpl;
import BaoCaoDoAn.Service.User.Impl.ScheduleMeetingServiceImpl;

@Controller
public class ScheduleMeetingController {
	@Autowired
	private ProjectServiceImpl projectService;
	@Autowired
	ScheduleMeetingServiceImpl scheduleMeetingServiceImpl;
	@Autowired
	ScheduleMeetingDAO scheduleMeetingDAO;
	@Autowired
	private GroupServiceImpl groupService;
	private ModelAndView mv = new ModelAndView();

	@RequestMapping(value = { "/teacher_viewScheduleMeeting" })
	public ModelAndView teacherGetScheduleMeetingByProjectId(HttpSession session) {
		System.out.println("hello");
		Account teacher = (Account) session.getAttribute("InforAccount");
//		List<project_scheduleMeeting> result = scheduleMeetingServiceImpl.GetScheduleMeetingByProjectId(teacher.getId()) ;

		List<Project> project = projectService.getProjectByTeacherId(teacher.getId());
		System.out.println("project" + project);
		for (Project project2 : project) {
			List<ScheduleMeeting> scheduleMeeting = scheduleMeetingServiceImpl
					.GetScheduleMeetingByProjectId(project2.getId());
			project2.setScheduleMeeting(scheduleMeeting);

		}
		mv.addObject("projects", project);
		mv.setViewName("user/teacher/ScheduleMeeting");
//		if(!scheduleMeeting.isEmpty()) {
//			mv.addObject("ScheduleMeetingByProjectId" , result) ;		
//			mv.setViewName("user/teacher/ScheduleMeeting");
//		}			
		return mv;
	}

	@RequestMapping(value = "/ScheduleMeeting")
	public ModelAndView admin(Model model) {

		List<ScheduleMeeting> list = new ArrayList<ScheduleMeeting>();
		list = scheduleMeetingServiceImpl.GetDataAdmin();

		if (list != null) {
			mv.setViewName("/admin/adminschedulemeeting");
			mv.addObject("ScheduleMeeting", scheduleMeetingServiceImpl.GetDataAdmin());

		} else {
			mv.addObject("ScheduleMeeting", "that bai");
		}

		return mv;

	}

	@RequestMapping(value = "/ScheduleMeeting/{id}")
	public ModelAndView group(@PathVariable int id, Meeting meeting) {
		List<Meeting> list = new ArrayList<Meeting>();
		list = scheduleMeetingServiceImpl.getMeetingByScheduleMeetingID(id);

		if (list != null) {
			mv.setViewName("/user/Meeting");
			mv.addObject("ScheduleMeeting3", scheduleMeetingServiceImpl.getMeetingByScheduleMeetingID(id));
		} else {
			mv.addObject("ScheduleMeeting3", "that bai");
		}

		return mv;
	}

	@RequestMapping(value = "/addScheduleMeeting", method = RequestMethod.GET)
	public String doGetAddUser(Model model) {
		if (!model.containsAttribute("ScheduleMeeting2")) {
			model.addAttribute("ScheduleMeeting2", new ScheduleMeeting());
		}
		return "/user/ScheduleMeetingFrom";
	}

	@RequestMapping(value = "/addScheduleMeeting", method = RequestMethod.POST)
	public String doPostAddUser(@ModelAttribute("ScheduleMeeting2") ScheduleMeeting admin, BindingResult result) {
		System.out.println("SUCCESS");
		if (result.hasErrors()) {
			return "/user/ScheduleMeetingFrom";
		}
		scheduleMeetingDAO.updateAndSave(admin);
		return "redirect:/ScheduleMeeting";
	}

	@RequestMapping(value = "/editScheduleMeeting", method = RequestMethod.GET)
	public ModelAndView editAdmin(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		ScheduleMeeting admin = scheduleMeetingDAO.get(id);

		ModelAndView model = new ModelAndView("/user/ScheduleMeetingFrom");

		model.addObject("ScheduleMeeting2", admin);

		return model;
	}

	@RequestMapping(value = "/deleteScheduleMeeting", method = RequestMethod.GET)
	public ModelAndView deleteAdmin(@RequestParam Integer id) {
		scheduleMeetingServiceImpl.deleteADMIN(id);

		return new ModelAndView("redirect:/ScheduleMeeting");
	}

	@RequestMapping(value = "/studentMeeting")
	public ModelAndView viewStudentMeeting(@ModelAttribute("message") String message, HttpSession session) {
		Account student = (Account) session.getAttribute("InforAccount");
		Group group = groupService.getGroupByAccountId(student.getId());
		Project projectOfGroup = projectService.getProjectByGroupId(group.getId());

		List<ScheduleMeeting> listScheduleMeeting = scheduleMeetingServiceImpl
				.GetScheduleMeetingByProjectId(projectOfGroup.getId());
//		for(ScheduleMeeting s:listScheduleMeeting) {
//			System.out.println(s.getId());
//		}
		if (listScheduleMeeting.size() != 0) {
			mv.addObject("scheduleMeetingList", listScheduleMeeting);
		}
		mv.setViewName("/user/student/studentMeeting");
		return mv;
	}

	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public String upload(@RequestParam CommonsMultipartFile file, HttpServletRequest request,
			RedirectAttributes redirAttr, HttpSession session) {
		Account student = (Account) session.getAttribute("InforAccount");
		boolean studentAuthority = student.getIsLeader();
		String path = session.getServletContext().getRealPath("/meetingContent");
		String filename = file.getOriginalFilename();
		String extendtionOfFile = FilenameUtils.getExtension(filename);
		System.out.println(path);
		if (studentAuthority == true) {
			if (extendtionOfFile.equals("doc") || extendtionOfFile.equals("docx") || extendtionOfFile.equals("txt")
					|| extendtionOfFile.equals("wpd") || extendtionOfFile.equals("odt")
					|| extendtionOfFile.equals("pdf")) {
				System.out.println("VALID TYPE");
				try {
					byte barr[] = file.getBytes();
					System.out.println("VALID TYPE");
					BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
					bout.write(barr);
					bout.flush();
					bout.close();
					redirAttr.addFlashAttribute("message",
							"You successfully uploaded '" + file.getOriginalFilename() + "'");
					String scheduleId = request.getParameter("scheduleMeetingId");
					System.out.println("Schedule ID:" + scheduleId);
					// Save file in to DB
					ScheduleMeeting scheduleToSave = new ScheduleMeeting();
					scheduleToSave.setId(Integer.parseInt(scheduleId));
					scheduleToSave.setContent(filename);
					scheduleMeetingServiceImpl.WriteMeetingContentFile(scheduleToSave);
					return "redirect:/studentMeeting";
				} catch (Exception e) {
					System.out.println(e);
				}

			} else {
				redirAttr.addFlashAttribute("message", "File Type Not Valid");
				System.out.println("Not valid");
			}
		} else {
			redirAttr.addFlashAttribute("message", "You dont have authority to upload, just leader!");
			System.out.println("Not author");
		}

		return "redirect:/uploadMeeting";
	}

	@RequestMapping("/uploadMeeting/{schedule_id}")
	public ModelAndView showUploadPage(@PathVariable int schedule_id, @ModelAttribute("message") String message) {
		mv.setViewName("/user/student/uploadFile");
		mv.addObject("scheduleId", schedule_id);
		return mv;
	}
}
