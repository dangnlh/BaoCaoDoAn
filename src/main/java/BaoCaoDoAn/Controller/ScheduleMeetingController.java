package BaoCaoDoAn.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Dao.ScheduleMeetingDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Meeting;
import BaoCaoDoAn.Entity.Project;
import BaoCaoDoAn.Entity.ScheduleMeeting;
import BaoCaoDoAn.Service.User.Impl.ScheduleMeetingServiceImpl;

@Controller
public class ScheduleMeetingController {
	@Autowired
	ScheduleMeetingServiceImpl scheduleMeetingServiceImpl;
	@Autowired
	ScheduleMeetingDAO scheduleMeetingDAO;
	private ModelAndView mv = new ModelAndView();

	@RequestMapping(value = {"/teacher_getScheduleMeeting/{id}"})
	public ModelAndView teacherGetScheduleMeetingByProjectId (@PathVariable int id) {
		
		List<ScheduleMeeting> result = scheduleMeetingServiceImpl.GetScheduleMeetingByProjectId(id) ;
		if(!result.isEmpty()) {
			mv.addObject("ScheduleMeetingByProjectId" , result) ;		
			mv.setViewName("user/teacher");
		}			
		return mv ;	
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
	public String doPostAddUser( @ModelAttribute("ScheduleMeeting2")  ScheduleMeeting admin, BindingResult result) {
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
}