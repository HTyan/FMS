package com.etc.fms.company.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.etc.fms.company.service.ICompanyService;

@Controller
public class CompanyController {
	
	@Resource(name = "companyService")
	private ICompanyService companyService;

	public ICompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
	}
	
	/*public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String method = req.getParameter("method");
		String reutrnPage = "jsp/error/error.jsp";
		if (method != null && method.equals("query")) {
			String cname = req.getParameter("cname") == null ? "" : req
					.getParameter("cname");
			CompanyDao c = new CompanyDaoImpl();
			List<Company> list = null;
			try {
				list = c.getCompanys(cname);
				reutrnPage = "jsp/company/companylist.jsp";
				req.setAttribute("list", list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher(reutrnPage).forward(req, res);
		} else if (method != null && method.equals("del")) {
			int cid = Integer.parseInt(req.getParameter("cid"));
			CompanyDao c = new CompanyDaoImpl();
			FinanceDao f = new FinanceDaoImpl();
			int delsuc = 0;
			try {
				delsuc = c.delCompany(cid);
				f.delFinanceInfos(cid); // �����Ķ���Ҳɾ��
				if (delsuc > 0) {
					CompanyDao cc = new CompanyDaoImpl();
					List<Company> list = cc.getCompanys(null);
					reutrnPage = "jsp/company/companylist.jsp";
					req.setAttribute("list", list);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher(reutrnPage).forward(req, res);
		} else if (method != null && method.equals("save")) {
			Company c = new Company();
			c.setCname(req.getParameter("cname"));
			c.setType(req.getParameter("type"));
			c.setAddr(req.getParameter("addr"));
			c.setXy(Double.parseDouble(req.getParameter("xy")==null||req.getParameter("xy").trim().length()==0?"5000":req.getParameter("xy").trim())) ;
			CompanyDao cd = new CompanyDaoImpl();
			int delsuc = 0;
			try {
				delsuc = cd.saveCompany(c);
				if (delsuc > 0) {
					CompanyDao cc = new CompanyDaoImpl();
					List<Company> list = cc.getCompanys(null);
					reutrnPage = "jsp/company/companylist.jsp";
					req.setAttribute("list", list);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher(reutrnPage).forward(req, res);
		}
	}
*/

}
