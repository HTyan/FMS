package com.etc.fms.admin.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.etc.fms.admin.service.impl.AdminService;
import com.etc.fms.user.entity.User;

@Controller
@SessionAttributes("exitUser")
public class AdminController {
	ModelAndView mv = new ModelAndView();

	@Resource(name = "adminService")
	private AdminService adminService;

	@RequestMapping("loginPage")
	// 前台过来，做转发到登录页面
	public String loginPage() {

		return "/login/admin_login";
	}

	@RequestMapping("admin_login")
	// 用户登录校验
	public String admin_login(User user, ModelMap model) {
		User exitUser = adminService.selByNameAndPwd(user);
		if (exitUser != null) {

			model.addAttribute("exitUser", exitUser);
			return "/common/admin_index";
		}

		return "/login/admin_login";// 没有该用户重新登录
	}

	@RequestMapping("queryAllUser")
	@ResponseBody
	// 查询所有用户
	public ModelAndView queryAllUser() {
		//创建modelAndView 用来传输结果和 跳转 视图
		ModelAndView mv =new ModelAndView("/user/userlist");
		
		List<User> list = (List<User>) adminService.queryAllUser();
		if (list.size() > 0) {
			mv.addObject("list", list);
			
			return mv;
		}
		mv.addObject("list", null);
		return mv;
	}

	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(Integer uid) {
		ModelAndView mv =new ModelAndView("/user/userlist");
		adminService.deleteByPrimaryKey(uid);
		List<User> list = (List<User>) adminService.queryAllUser();
		if (list.size() > 0) {
			mv.addObject("list", list);
			
			return mv;
		}
		mv.addObject("list", null);
		return mv;
		
		
	}
}
