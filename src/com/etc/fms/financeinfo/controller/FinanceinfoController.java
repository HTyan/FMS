package com.etc.fms.financeinfo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.etc.fms.company.service.ICompanyService;
import com.etc.fms.financeinfo.entity.FinanceInfo;
import com.etc.fms.financeinfo.service.IFinanceService;

@Controller
public class FinanceinfoController {

	@Resource(name = "financeinfoService")
	private IFinanceService financeinfoService;

	public IFinanceService getFinanceinfoService() {
		return financeinfoService;
	}

	public void setFinanceinfoService(IFinanceService financeinfoService) {
		this.financeinfoService = financeinfoService;
	}

	@Resource(name = "companyService")
	private ICompanyService companyService;

	public ICompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
	}

	/**
	 * 查找所有
	 * 
	 * @param Query
	 * @return
	 */
	@RequestMapping(value = "FinanceQuery", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView FinanceQuery() {
		// 创建modelAndView 用来传输结果和 跳转 视图
		ModelAndView mv = new ModelAndView("/index");
		
		List<FinanceInfo> list = (List<FinanceInfo>) financeinfoService
				.queryFinanceInfolist();
		if (list.size() > 0) {
			mv.addObject("list", list);
			return mv;
		}
	/*	request.setAttribute("list", list);*/
		mv.addObject("list", null);
		/*request.setAttribute("admin1", list);*/
		return mv;
	}

}
