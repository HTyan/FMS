package com.etc.fms.finance.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.fms.finance.dao.UserDao;
import com.etc.fms.finance.dao.impl.UserDaoImpl;
import com.etc.fms.user.entity.User;

public class UserSevice extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserSevice() {
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
			String loginname = req.getParameter("loginname") == null ? "" : req
					.getParameter("loginname");
			String username = req.getParameter("username") == null ? "" : req
					.getParameter("username");
			UserDao u = new UserDaoImpl();
			List<User> ulist = null;
			try {
				ulist = u.getUsers(loginname, username);
				reutrnPage = "jsp/user/userlist.jsp";
				req.setAttribute("ulist", ulist);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher(reutrnPage).forward(req, res);
		} else if (method != null && method.equals("del")) {
			int uid = Integer.parseInt(req.getParameter("uid"));
			UserDao u = new UserDaoImpl();
			int delsuc = 0;
			try {
				delsuc = u.delUser(uid);
				if (delsuc > 0) {
					UserDao uu = new UserDaoImpl();
					List<User> ulist = null;
					ulist = uu.getUsers(null, null);
					reutrnPage = "jsp/user/userlist.jsp";
					req.setAttribute("ulist", ulist);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher(reutrnPage).forward(req, res);
		} else if (method != null && method.equals("save")) {
			User u = new User();
			u.setUsername(req.getParameter("username")) ;
			u.setLoginname(req.getParameter("loginname")) ;
			u.setPassword(req.getParameter("password")) ;
			u.setGender(req.getParameter("gender")) ;
			u.setTel(req.getParameter("tel")) ;
			u.setAge(Integer.parseInt(req.getParameter("age"))) ;
			u.setRole("admin") ;
			UserDao ud = new UserDaoImpl();
			int delsuc = 0;
			try {
				delsuc = ud.saveUser(u);
				if (delsuc > 0) {
					UserDao uu = new UserDaoImpl();
					List<User> ulist = null;
					ulist = uu.getUsers(null, null);
					reutrnPage = "jsp/user/userlist.jsp";
					req.setAttribute("ulist", ulist);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher(reutrnPage).forward(req, res);
		}
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
