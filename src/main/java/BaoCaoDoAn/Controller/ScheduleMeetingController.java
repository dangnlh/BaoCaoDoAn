package BaoCaoDoAn.Controller;

import java.awt.datatransfer.StringSelection;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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
import jdk.internal.joptsimple.internal.Strings;

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
		String path = session.getServletContext().getRealPath("/meetingContent");
		System.out.println("REAL PATH:" + path);
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
		String message = "";
		String scheduleId = request.getParameter("scheduleMeetingId");
		Account student = (Account) session.getAttribute("InforAccount");
		boolean studentAuthority = student.getIsLeader();
		String path = session.getServletContext().getRealPath("/meetingContent");
		String filename = file.getOriginalFilename();
		String extendtionOfFile = FilenameUtils.getExtension(filename);
		System.out.println(path);
		ScheduleMeeting scheduleMeeting = scheduleMeetingServiceImpl
				.getScheduleMeetingByID(Integer.parseInt(scheduleId));
		boolean dateCheck = true;
		if (scheduleMeeting.getUp() == 1) {
			Date submitedDate = new Date(scheduleMeeting.getSubmitDate().getTime());
			String[] timeLine = scheduleMeeting.getSubmitTime().split(":");
			Calendar calendarT = Calendar.getInstance();
			calendarT.setTime(submitedDate);
			calendarT.add(Calendar.HOUR_OF_DAY, Integer.parseInt(timeLine[0]));
			calendarT.add(Calendar.MINUTE, Integer.parseInt(timeLine[1]));
			submitedDate = calendarT.getTime();
			Date now = new Date();
			int nowThanSubmitDate = now.compareTo(submitedDate);
			if (nowThanSubmitDate > 0) {
				long difference = now.getTime() - submitedDate.getTime();
				long differenceInDay = TimeUnit.MILLISECONDS.toDays(difference);
				long differenceInMinutes = TimeUnit.MILLISECONDS.toMinutes(difference);
				if (differenceInMinutes > 15 || differenceInDay > 1) {
					message = "Out of date to edit file";
					dateCheck = false;
				}
			}

		}

		if (studentAuthority == true && dateCheck == true) {
			if (extendtionOfFile.equals("doc") || extendtionOfFile.equals("docx") || extendtionOfFile.equals("txt")
					|| extendtionOfFile.equals("wpd") || extendtionOfFile.equals("odt")
					|| extendtionOfFile.equals("pdf")) {
				try {
					byte barr[] = file.getBytes();
					System.out.println("VALID TYPE");
					BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
					bout.write(barr);
					bout.flush();
					bout.close();
					message = "You successfully uploaded '" + file.getOriginalFilename();
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
				message = "File Type Not Valid";
				System.out.println("Not valid");
			}
		} else if (studentAuthority == false) {
			message = "You dont have authority to upload, just leader!";
			System.out.println("Not author");
		}
		redirAttr.addFlashAttribute("message", message);
		return "redirect:/uploadMeeting/" + scheduleId;
	}

	@RequestMapping("/uploadMeeting/{schedule_id}")
	public ModelAndView showUploadPage(@PathVariable int schedule_id, @ModelAttribute("message") String message) {
		mv.setViewName("/user/student/uploadFile");
		mv.addObject("scheduleId", schedule_id);
		// check upload yet!
		ScheduleMeeting scheduleMeeting = scheduleMeetingServiceImpl.getScheduleMeetingByID(schedule_id);
		String uploadMessage = "";
		Date now = new Date();
		Date meetingDate = new Date(scheduleMeeting.getTimeMeeting().getTime());
		String[] timeLineMeeting = scheduleMeeting.getTime().split(":");
		Calendar calendarM = Calendar.getInstance();
		calendarM.setTime(meetingDate);
		calendarM.add(Calendar.HOUR_OF_DAY, Integer.parseInt(timeLineMeeting[0]));
		calendarM.add(Calendar.MINUTE, Integer.parseInt(timeLineMeeting[1]));
		meetingDate = calendarM.getTime();

		int nowThanMeetingDate = now.compareTo(meetingDate);

		if (nowThanMeetingDate < 0) {
			uploadMessage = "Cannot upload file because date have not arrived!";
		} else {
			System.out.println("scheduleMeeting.getContent():" + scheduleMeeting.getContent());
			String contentOfFile = scheduleMeeting.getContent();
			contentOfFile = Optional.ofNullable(contentOfFile).orElse("");
			if (!contentOfFile.isEmpty()) {
				mv.addObject("filename", contentOfFile);
				uploadMessage = "You submitted a file:";
				// check for edit upload filed afer upload

				Date submitedDate = new Date(scheduleMeeting.getSubmitDate().getTime());
				String[] timeLine = scheduleMeeting.getSubmitTime().split(":");
				Calendar calendarT = Calendar.getInstance();
				calendarT.setTime(submitedDate);
				calendarT.add(Calendar.HOUR_OF_DAY, Integer.parseInt(timeLine[0]));
				calendarT.add(Calendar.MINUTE, Integer.parseInt(timeLine[1]));
				submitedDate = calendarT.getTime();

				// compare date for prepare to compare time

				int nowThanSubmitDate = now.compareTo(submitedDate);
				if (nowThanSubmitDate > 0) {
					long difference = now.getTime() - submitedDate.getTime();
					long differenceInDay = TimeUnit.MILLISECONDS.toDays(difference);
					long differenceInMinutes = TimeUnit.MILLISECONDS.toMinutes(difference);
					if (differenceInMinutes > 15 || differenceInDay > 1) {
						uploadMessage = "Over to update the file:";
					} else {
						uploadMessage = "You upload a file:";
					}
				}

			}
		}
		System.out.println("MESSAGE:" + uploadMessage);
		mv.addObject("upload_message", uploadMessage);
		return mv;
	}
}
