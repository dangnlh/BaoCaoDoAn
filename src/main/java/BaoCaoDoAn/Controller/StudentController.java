package BaoCaoDoAn.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import BaoCaoDoAn.Dao.AccountDAO;
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

	@Autowired
	AccountDAO accountDao;

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

		ModelAndView model = new ModelAndView("/user/addAccount");

		model.addObject("studentAcc1", account);

		return model;
	}

	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	public String deleteAccount(@RequestParam Integer id) {
		studentService.deleteAccount(id);
		return "redirect:/studentList";
	}

	@RequestMapping(value = "/addAccountStudent", method = RequestMethod.GET)
	public ModelAndView doGetAddUser(Model model, HttpSession session) {
		if (!model.containsAttribute("studentAcc1")) {
			model.addAttribute("studentAcc1", new Account());
		}
		mv.setViewName("/user/addAccount");
		mv.addObject("teacher", accountDao.getTeacherAdmin());
		mv.addObject("groups", groupServiceImpl.getGroupAdmin());
		mv.addObject("getAllStudent", studentService.getAccountList());
		return mv;
	}

	@RequestMapping(value = "/addAccountStudent", method = RequestMethod.POST)
	public ModelAndView doPostAddGroup(@Valid @ModelAttribute("studentAcc1") Account account, BindingResult result) {
		int isEmailExist = studentService.isEmailExist(account.getMail());

		if (result.hasErrors()) {
			mv.setViewName("/user/addAccount");
		} else if (isEmailExist >= 1) {
			mv.setViewName("/user/addAccount");
			mv.addObject("emailExist", "Your email has been already exists!");
		} else if (account.getId() == 0) {
			studentService.addAccount(account);
			System.out.println("Insert");
			return new ModelAndView("redirect:/studentList");
		} else if (account.getId() > 0) {
			studentService.updateAccount(account);
			return new ModelAndView("redirect:/studentList");
		}

		return mv;
	}

	@RequestMapping(value = "/searchAcc", method = RequestMethod.POST)
	public ModelAndView searchByName(@ModelAttribute("accountSearch") Account account) {
		List<Account> list = new ArrayList<Account>();
		list = studentService.findAccountByName(account.getName());

		System.out.println(list);
		if (list.isEmpty()) {
			mv.addObject("getAllStudent", studentService.getAccountList());
			mv.setViewName("/admin/studentAccount");
		} else {

			mv.setViewName("/admin/resultSearch");
			mv.addObject("resultSearch", list);
		}
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
