package com.etc.fms.finance.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.fms.finance.dao.UserDao;
import com.etc.fms.finance.dao.impl.UserDaoImpl;
import com.etc.fms.user.entity.User;

public class LoginService extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginService() {
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
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		HttpSession session = req.getSession();
		String reutrnPage = "jsp/error/error.jsp";
		if (method != null && method.equals("login")) {
			String loginname = req.getParameter("loginname");
			String password = req.getParameter("password");
			UserDao ud = new UserDaoImpl();
			User user = null;
			try {
				user = ud.getUser(loginname, password);
				if (user != null) {
					session.setAttribute("user", user);
					reutrnPage = "jsp/common/index.jsp";
				}else{
					req.setAttribute("res","错误的用户名或者密码！") ;
					reutrnPage = "jsp/login/login.jsp";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher(reutrnPage).forward(req, res);
		} else if (method != null && method.equals("logout")) {
			session.removeAttribute("user");
			reutrnPage = "jsp/login/login.jsp";
			res.sendRedirect(reutrnPage) ;
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
