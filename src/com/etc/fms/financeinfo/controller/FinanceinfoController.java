package com.etc.fms.financeinfo.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.etc.fms.company.entity.Company;
import com.etc.fms.company.service.ICompanyService;
import com.etc.fms.financeinfo.entity.FBaoBiao;
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
	 * 通过ID查找
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "saveFinanceInfo", method = RequestMethod.GET)
	public ModelAndView getCheckById(int id) {
		/*FinanceInfo checked = financeinfoService.saveFinanceinfo(f);*/
		ModelAndView mv = new ModelAndView();
		/*mv.addObject("checked", checked);*/
		mv.setViewName("showChecked");
		return mv;
	}
/*	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String method = req.getParameter("method");
		String reutrnPage = "jsp/error/error.jsp";
		if (method != null && method.equals("queryC")) {
			CompanyDao c = new CompanyDaoImpl();
			List<Company> list = null;
			try {
				list = c.getCompanys(null);
				reutrnPage = "jsp/finance/financeAdd.jsp";
				req.setAttribute("list", list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher(reutrnPage).forward(req, res);
		} else if (method != null && method.equals("query")) {
			int cid = Integer.parseInt(req.getParameter("cid") == null
					|| req.getParameter("cid").trim() == "" ? "0" : req
					.getParameter("cid"));
			String begintime = req.getParameter("ftime");
			String endtime = req.getParameter("ytime");
			FinanceDao fi = new FinanceDaoImpl();
			List<FinanceInfo> list = null;
			try {
				list = fi.getFinanceInfolist(cid, begintime, endtime);
				CompanyDao c = new CompanyDaoImpl();
				List<Company> clist = c.getCompanys(null);
				long curtime = DUtil.getTime(null);
				for (FinanceInfo f : list) {
					if (DUtil.getTime(f.getYtime()) < curtime) {
						if (f.getSishou() < f.getYishou()) {
							// 非正常状态
							f.setFlag(1);
						}
					}

				}
				reutrnPage = "jsp/finance/financelist.jsp";
				req.setAttribute("list", list);
				req.setAttribute("clist", clist);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher(reutrnPage).forward(req, res);
		} else if (method != null && method.equals("report")) {
			int cid = Integer.parseInt(req.getParameter("cid") == null
					|| req.getParameter("cid").trim() == "" ? "0" : req
					.getParameter("cid"));
			String begintime = req.getParameter("ftime");
			String endtime = req.getParameter("ytime");
			FinanceDao fi = new FinanceDaoImpl();
			List<FBaoBiao> list = null;
			try {
				list = fi.getFinanceBBlist(cid, begintime, endtime);
				CompanyDao c = new CompanyDaoImpl();
				List<Company> clist = c.getCompanys(null);
				double x1 = 0;
				double x2 = 0;
				for (FBaoBiao f : list) {
					for (Company cy : clist) {
						if (f.getCid() == cy.getCid()) {
							f.setCname(cy.getCname());
							break;
						}
					}
					x1 += f.getYs();
					x2 += f.getSh();
				}
				req.setAttribute("x1", x1);
				req.setAttribute("x2", x2);
				reutrnPage = "jsp/finance/financereport.jsp";
				req.setAttribute("list", list);
				req.setAttribute("clist", clist);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher(reutrnPage).forward(req, res);
		} else if (method != null && method.equals("save")) {
			FinanceInfo f = new FinanceInfo();
			f.setCid(Integer.parseInt(req.getParameter("cid")));
			f.setCno(req.getParameter("cno"));
			f.setFname(req.getParameter("fname"));
			f.setDes(req.getParameter("des"));
			f.setFtime(req.getParameter("ftime"));
			f.setYtime(req.getParameter("ytime"));
			double ys = Double.parseDouble(req.getParameter("ys") == null
					|| req.getParameter("ys").trim() == "" ? "0" : req
					.getParameter("ys"));
			double ss = Double.parseDouble(req.getParameter("ss") == null
					|| req.getParameter("ss").trim() == "" ? "0" : req
					.getParameter("ss"));
			f.setYishou(ys);
			f.setSishou(ss);
			FinanceDao fi = new FinanceDaoImpl();
			int savlsuc = 0;
			try {
				savlsuc = fi.saveFinanceInfo(f);
				CompanyDao c = new CompanyDaoImpl();

				if (savlsuc > 0) {
					List<Company> list = null;
					list = c.getCompanys(null);
					req.setAttribute("list", list);
					reutrnPage = "jsp/finance/financeAdd.jsp";
					req.setAttribute("result", "success");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher(reutrnPage).forward(req, res);
		} else if (method != null && method.equals("queryD")) {
			CompanyDao c = new CompanyDaoImpl();
			List<Company> list = null;
			try {
				list = c.getCompanys(null);
				reutrnPage = "jsp/finance/huokuanAdd.jsp";
				req.setAttribute("list", list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher(reutrnPage).forward(req, res);
		} else if (method != null && method.equals("update")) {
			FinanceInfo f = new FinanceInfo();
			f.setCid(Integer.parseInt(req.getParameter("cid")));
			String cno = req.getParameter("cno").trim();
			f.setCno(cno);
			f.setDes(req.getParameter("des"));
			f.setFtime(req.getParameter("ftime"));
			f.setYtime(req.getParameter("ytime"));
			double ss = Double.parseDouble(req.getParameter("ss") == null
					|| req.getParameter("ss").trim() == "" ? "0" : req
					.getParameter("ss"));
			f.setSishou(ss);
			try {
				FinanceDao fi = new FinanceDaoImpl();
				FinanceInfo ff = null;
				int savlsuc = 0;
				ff = fi.getFinanceInfo(cno);
				if (ff == null) {
					req.setAttribute("result", "查不到对应的账单！");
				} else {
					fi = new FinanceDaoImpl();
					savlsuc = fi.updateFinance(f);
					if (savlsuc > 0) {
						double ys = ff.getYishou();
						double temp = ys - ss;
						CompanyDao cd = new CompanyDaoImpl();
						Company c = cd.getCompany(f.getCid());
						double xy = c.getXy();
						if ((xy - temp) >= 0) {
							xy = xy - temp;
						} else {
							xy = 0;
						}
						cd = new CompanyDaoImpl();
						cd.updateCompany(f.getCid(), xy);
						cd = new CompanyDaoImpl();
						List<Company> list = cd.getCompanys(null);
						reutrnPage = "jsp/finance/huokuanAdd.jsp";
						req.setAttribute("list", list);
						req.setAttribute("result", "success");
					} else {
						req.setAttribute("result", "查不到对应的账单！");
						CompanyDao cd = new CompanyDaoImpl();
						List<Company> list = cd.getCompanys(null);
						reutrnPage = "jsp/finance/huokuanAdd.jsp";
						req.setAttribute("list", list);
					}
				}

			} catch (Exception e) {
				req.setAttribute("result", "查不到对应的账单！");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher(reutrnPage).forward(req, res);
		}
	}*/
}
