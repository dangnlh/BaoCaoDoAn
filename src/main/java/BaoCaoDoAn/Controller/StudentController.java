package BaoCaoDoAn.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Dto.AccountSearchCondition;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Service.User.Impl.GroupServiceImpl;
import BaoCaoDoAn.Service.User.Impl.StudentServiceImpl;

@Controller
public class StudentController {
	@Autowired
	StudentServiceImpl studentService;
	@Autowired
	GroupServiceImpl groupServiceImpl;
	private ModelAndView mv = new ModelAndView();

	@RequestMapping(value = "/studentList", method = RequestMethod.GET)
	public ModelAndView studentListAll(HttpServletRequest request) {
		List<Account> list = new ArrayList<Account>();
		list = studentService.getAccountList();
		mv.addObject("studentList", studentService.getAccountList());
		mv.addObject("accountSearch", new Account());
		mv.setViewName("/admin/studentAccount");
		/*
		 * mv.addObject("newAccount", new Account());
		 */
		return mv;
	}

	@RequestMapping(value = "/studentListByCondition", method = RequestMethod.GET)
	public ModelAndView studentListByCondition(HttpServletRequest request) {
		AccountSearchCondition condition = new AccountSearchCondition();
		String role = request.getParameter("role");
		condition.setRole(role);
		String name = request.getParameter("name");
		condition.setName(name);

		mv.addObject("studentList", studentService.getAccountListByCondition(condition));
		mv.setViewName("admin/studentAccount");

		return mv;
	}

	@RequestMapping(value = "/editStudentAccount", method = RequestMethod.GET)
	public ModelAndView editAdmin(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Account account = studentService.getAccountId(id);

		ModelAndView mv = new ModelAndView("/user/addAccount");

		mv.addObject("studentAcc1", account);
		mv.addObject("groups", groupServiceImpl.getGroupAdmin());
		return mv;
	}

	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	public String deleteAccount(@RequestParam Integer id) {
		studentService.deleteAccount(id);
		return "redirect:/studentList";
	}

	@RequestMapping(value = "/addAccountStudent", method = RequestMethod.GET)
	public ModelAndView doGetAddUser(Model model) {
		if (!model.containsAttribute("studentAcc1")) {
			model.addAttribute("studentAcc1", new Account());
		}
		mv.addObject("groups", groupServiceImpl.getGroupAdmin());
		mv.setViewName("/user/addAccount");
		return mv;
	}

	@RequestMapping(value = "/addAccountStudent", method = RequestMethod.POST)
	public ModelAndView doPostAddGroup(@Valid @ModelAttribute("studentAcc1") Account account, BindingResult result) {
		if (result.hasErrors()) {
			mv.setViewName("/user/addAccount");
			System.out.println("kiet");
		} else {
			if (account.getId() == 0) {
				studentService.addAccount(account);
				System.out.println("Insert");
				return new ModelAndView("redirect:/studentList");
				
			} else if (account.getId() > 0) {
				studentService.updateAccount(account);
				return new ModelAndView("redirect:/studentList");
			}
		}

		return mv;

	}

	@RequestMapping(value = "/searchAcc", method = RequestMethod.POST)
	public ModelAndView searchByName(@Valid @ModelAttribute("accountSearch") Account account , BindingResult result) {

		List<Account> list = new ArrayList<Account>();
		list = studentService.findAccountByName(account.getName());

		System.out.println(list);
		if (list.isEmpty() && result.hasErrors()) {
			mv.setViewName("/admin/studentAccount");
		} else {
			mv.setViewName("/admin/resultSearch");
			mv.addObject("resultSearch", list);
		}
		
		
//		mv.addObject("searchAcc2", studentService.findAccountByName("name"));

		/*
		 * mv.addObject("newAccount", new Account());
		 */
		return mv;
	}

//	@RequestMapping(value = "/userSearch", method = RequestMethod.POST)
//	public String searchAction(@ModelAttribute Account account, BindingResult result, @RequestParam String action, ModelMap model ) {
//		String work = action.toLowerCase().toString();
//		if (work.equals("search") && !account.getName().equals("")) {
//            model.put("userList", studentService.SearchAcc(account.getName()));
//        } else {
//            model.put("userList", studentService.SearchAcc(null));
//        }
//		return "studentAccount";
//	}

}
