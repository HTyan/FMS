package com.etc.fms.finance.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.fms.company.entity.Company;
import com.etc.fms.finance.dao.CompanyDao;
import com.etc.fms.finance.dao.FinanceDao;
import com.etc.fms.finance.dao.impl.CompanyDaoImpl;
import com.etc.fms.finance.dao.impl.FinanceDaoImpl;

public class CompanyService extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CompanyService() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void service(HttpServletRequest req, HttpServletResponse res)
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

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
