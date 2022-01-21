package BaoCaoDoAn.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Dao.ScheduleMeetingDAO;
import BaoCaoDoAn.Entity.ScheduleMeeting;
import BaoCaoDoAn.Service.User.AccountServiceImpl;
import BaoCaoDoAn.Service.User.ScheduleMeetingServiceImpl;

@Controller
public class ScheduleMeetingController {
	@Autowired
	ScheduleMeetingServiceImpl scheduleMeetingServiceImpl;
	@Autowired
	ScheduleMeetingDAO scheduleMeetingDAO;
	private ModelAndView mv = new ModelAndView();

	@RequestMapping(value = "/admin")
	public ModelAndView admin(Model model) {

		List<ScheduleMeeting> list = new ArrayList<ScheduleMeeting>();
		list = scheduleMeetingServiceImpl.GetDataAdmin();

		if (list != null) {
			mv.setViewName("/admin/admin");
			mv.addObject("admin", scheduleMeetingServiceImpl.GetDataAdmin());

		} else {
			mv.addObject("admin", "that bai");
		}

		return mv;

	}

	@RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
	public String doGetAddUser(Model model) {
		if (!model.containsAttribute("admin2")) {
			model.addAttribute("admin2", new ScheduleMeeting());
		}
		return "/admin/admin_form";
	}

	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public String doPostAddUser( @ModelAttribute("admin2")  ScheduleMeeting admin, BindingResult result) {
		System.out.println("SUCCESS");
		if (result.hasErrors()) {
			return "/admin/admin_form";
		}
		int count = 0;
		if (count > 0) {
			scheduleMeetingServiceImpl.updateADMIN(admin);
			mv.addObject("status", "thang cong");
		} else {
			scheduleMeetingServiceImpl.saveADMIN(admin);
			mv.addObject("status", "that bai");
		}
		return "/admin/admin";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editAdmin(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		ScheduleMeeting admin = scheduleMeetingDAO.get(id);

		ModelAndView model = new ModelAndView("/admin/admin_form");

		model.addObject("admin2", admin);

		return model;
	}

	@RequestMapping(value = "/deleteAdmin", method = RequestMethod.GET)
	public ModelAndView deleteAdmin(@RequestParam Integer id) {
		scheduleMeetingServiceImpl.deleteADMIN(id);

		return new ModelAndView("/admin/admin");
	}
}