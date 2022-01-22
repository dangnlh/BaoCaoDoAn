package BaoCaoDoAn.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Dao.GroupDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Group;
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

	@RequestMapping(value = "/group/{id}")
	public ModelAndView group(@PathVariable int id) {
		List<Account> list = new ArrayList<Account>();
		list = groupServiceImpl.GetDataGroup(id);

		if (list != null) {
			mv.setViewName("/user/group");
			mv.addObject("groups", groupServiceImpl.GetDataGroup(id));
		} else {
			mv.addObject("groups", "that bai");
		}

		return mv;
	}

	@RequestMapping(value = "/tags")
	public ModelAndView group() {
		List<Group> list1 = new ArrayList<Group>();
		list1 = groupServiceImpl.getGroupAdmin();

		if (list1 != null) {
			mv.setViewName("/admin/admin2");
			mv.addObject("group", groupServiceImpl.getGroupAdmin());
		} else {
			mv.addObject("group", "that bai");
		}

		return mv;

	}

	@RequestMapping(value = "/group/{id}/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteGroup(@PathVariable int groupID,@PathVariable int id,HttpServletRequest request) {
			
		List<Account> list = new ArrayList<Account>();
		list = groupServiceImpl.GetDataGroup(groupID);
		if(list!=null) {
			mv.setViewName("/group/{id}");
			mv.addObject("groups", groupServiceImpl.GetDataGroup(groupID));
			System.out.println("thanhcong");
			groupServiceImpl.deleteStudentInGroup(id);
		}else {
			mv.addObject("groups", "that bai");
		}
		return mv;
	}
//	@RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
//	public String doGetAddUser(Model model) {
//		if (!model.containsAttribute("admin2")) {
//			model.addAttribute("admin2", new Admin());
//		}
//		return "/admin/admin_form";
//	}
//
//	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
//	public String doPostAddUser( @ModelAttribute("admin2")  Admin admin, BindingResult result) {
//		System.out.println("SUCCESS");
//		if (result.hasErrors()) {
//			return "/admin/admin_form";
//		}
//		int count = 0;
//		if (count > 0) {
//			accountServiceImpl.updateADMIN(admin);
//			mv.addObject("status", "thang cong");
//		} else {
//			accountServiceImpl.saveADMIN(admin);
//			mv.addObject("status", "that bai");
//		}
//		return "/admin/admin";
////	}
}
