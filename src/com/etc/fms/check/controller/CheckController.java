package com.etc.fms.check.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.etc.fms.check.entity.Checked;
import com.etc.fms.check.service.ICheckedService;

@Controller
public class CheckController {

	@Resource(name = "checkedService")
	private ICheckedService checkedService;

	public ICheckedService getCheckedService() {
		return checkedService;
	}

	public void setCheckedService(ICheckedService checkedService) {
		this.checkedService = checkedService;
	}

	/**
	 * 通过ID查找
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getCheckById", method = RequestMethod.GET)
	public ModelAndView getBlogById(int id) {
		Checked checked = checkedService.selectChecked(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("checked", checked);
		mv.setViewName("showChecked");
		return mv;
	}
	
/*	*//**
	 * 查找全部
	 * @return
	 *//*
	@RequestMapping(value = "getBlogAll", method = RequestMethod.GET)
	public ModelAndView getBlogByAll() {
		List<Blog> list = blogService.selectAllBlog();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("showBlog");
		return mv;
	}
	
	*//**
	 * 添加单条信息
	 * @param blog
	 * @return
	 *//*
	@RequestMapping(value = "addBlog", method = RequestMethod.POST)
	public ModelAndView AddBlog(Blog blog) {

		boolean add= blogService.addBlog(blog);
		ModelAndView mv = new ModelAndView();
		mv.addObject("add", add);
		mv.setViewName("showBlog");
		return mv;
	}
	*//**
	 * 删除单条信息
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = "deleteBlog", method = RequestMethod.GET)
	public ModelAndView DeleteBlog(int id) {

		boolean delete= blogService.deleteBlog(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("delete", delete);
		mv.setViewName("showBlog");
		return mv;
	}
	
	*//**
	 * 修改单条信息
	 * @param blog
	 * @return
	 *//*
	@RequestMapping(value = "updateBlog", method = RequestMethod.POST)
	public ModelAndView UpdateBlog(Blog blog) {

		boolean update= blogService.updateBlog(blog);
		ModelAndView mv = new ModelAndView();
		mv.addObject("update", update);
		mv.setViewName("showBlog");
		return mv;
	}
	*/
	

}
