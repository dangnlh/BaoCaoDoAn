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

import BaoCaoDoAn.Dao.GroupDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Group;
import BaoCaoDoAn.Entity.Project;
import BaoCaoDoAn.Entity.ScheduleMeeting;
import BaoCaoDoAn.Service.User.GroupServiceImpl;

@Controller
public class GroupController {
	@Autowired
	GroupServiceImpl groupServiceImpl;
	@Autowired
	GroupDAO groupDAO;

	private ModelAndView mv = new ModelAndView();
//	@RequestMapping(value = {"/", "/group"})
//	public ModelAndView Login() {
//		mv.setViewName("/group");
//		return mv ;
//	}
	@RequestMapping(value="/teacherGroup/{id}")
	public ModelAndView TeacherGroup(@PathVariable int id ) {
		
		mv.setViewName("user/teacherGroup");
		mv.addObject("TeacherGroup" , groupDAO.FindGroupID(id));
		return mv ;
	}
	
	@RequestMapping(value = "/group/{id}")
	public ModelAndView group(@PathVariable int id, Account account) {
		List<Account> list = new ArrayList<Account>();
		list = groupServiceImpl.GetDataGroup(id);

		if (list != null) {
			mv.setViewName("/user/group");
			mv.addObject("Group2", groupServiceImpl.GetDataGroup(id));
		} else {
			mv.addObject("Group2", "that bai");
			groupServiceImpl.updateAccountInGroup(account);
		}

		return mv;
	}
	@RequestMapping(value = "/Project/{id}")
	public ModelAndView group(@PathVariable int id, Project project) {
		List<Project> list = new ArrayList<Project>();
		list = groupServiceImpl.GetProjectByGroupID(id);

		if (list != null) {
			mv.setViewName("/user/project");
			mv.addObject("getAllProject", groupServiceImpl.GetProjectByGroupID(id));
		} else {
			mv.addObject("getAllProject", "that bai");
			
		}

		return mv;
	}
	@RequestMapping(value = "/tags")
	public ModelAndView group() {
		List<Group> list1 = new ArrayList<Group>();
		list1 = groupServiceImpl.getGroupAdmin();
		
		if (list1 != null) {
			mv.setViewName("/admin/admin2");
			mv.addObject("groups", groupServiceImpl.getGroupAdmin());
		} else {
			mv.addObject("groups", "that bai");
		}

		return mv;

	}
	@RequestMapping(value="/ListGroup")
	public ModelAndView listGroup() {
		List<Group> list1 = new ArrayList<Group>();
		list1 = groupServiceImpl.getGroupAdmin();
		
		if (list1 != null) {
			List<Account> list = new ArrayList<Account>();
			list = groupServiceImpl.getStudent();
			mv.setViewName("/user/ListGroup");
			mv.addObject("group4", groupServiceImpl.getGroupAdmin());
			mv.addObject("group3",groupServiceImpl.getStudent());
		} else {
			mv.addObject("group4", "that bai");
		}

		return mv;
	}
	
	@RequestMapping(value = "/editAccount", method = RequestMethod.GET)
	public ModelAndView editAdmin(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Account account = groupServiceImpl.getGroupID(id);

		ModelAndView model = new ModelAndView("/user/editGroup");

		model.addObject("group3", account);

		return model;
	}



	@RequestMapping(value = "/addAccountInGroup", method = RequestMethod.GET)
	public String doGetAddUser(Model model) {
		if (!model.containsAttribute("group3")) {
			model.addAttribute("group3", new Account());
		}
		return "/user/editGroup";
	}

	@RequestMapping(value = "/addAccountInGroup", method = RequestMethod.POST)
	public String doPostAddUser(@ModelAttribute("group3") Account account, BindingResult result) {

		if (result.hasErrors()) {
			return "/user/editGroup";
		}
		if (account.getGroup_id() > 0) {
			groupServiceImpl.updateAccountInGroup(account);
		}else{
			groupServiceImpl.updateAccountInGroup(account);
		}

		return "redirect:/ListGroup";
		
	}
	@RequestMapping(value = "/deleteGroup", method = RequestMethod.GET)
	public String deleteGroup(@RequestParam Integer id) {
		groupServiceImpl.deleteGroup(id);
		return "redirect:/ListGroup";
	}

	@RequestMapping(value = "/AddGroup", method = RequestMethod.GET)
	public String doGetAddGroup(Model model) {
		if (!model.containsAttribute("group4")) {
			model.addAttribute("group4", new Group());
		}
		return "/user/AddGroup";
	}
	@RequestMapping(value = "/AddGroup", method = RequestMethod.POST)
	public String doPostAddGroup(@ModelAttribute("group4") Group group, BindingResult result) {
		
		if (result.hasErrors()) {
			return "/user/AddGroup";
		}
		if(group.getId()== 0) {
			groupServiceImpl.addGroup(group);
		}else if(group.getId()>0){
			groupServiceImpl.updateGroup(group);
		}
		
		return "redirect:/ListGroup";
		
	}
	@RequestMapping(value = "/editgroup", method = RequestMethod.GET)
	public ModelAndView editGroup(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));

		Group group = groupServiceImpl.findGroupById(id);

		ModelAndView model = new ModelAndView("/user/AddGroup");

		model.addObject("group4", group);

		return model;
	}

}
