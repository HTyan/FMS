package com.etc.fms.financeinfo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

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

	/**
	 * Õ®π˝ID≤È’“
	 * 
	 * @param id
	 * @return
	 */
	/*@RequestMapping(value = "getCheckById", method = RequestMethod.GET)
	public ModelAndView getCheckById(int id) {
		Checked checked = checkedService.selectByPrimaryKey(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("checked", checked);
		mv.setViewName("showChecked");
		return mv;
	}*/
}
