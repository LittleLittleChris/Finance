package com.chen.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.pojo.UserInfo;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7959273333569908935L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if (request.getParameter("username") != null && userInfo != null) {
			UserInfo register = new UserInfo();
			register.setAuthority(0);
			register.setPassword(request.getParameter("password"));
			register.setpName(request.getParameter("pName"));
			register.setUsername(request.getParameter("username"));
			register.setRegion(request.getParameter("region"));
			request.setAttribute("register", register);
			request.getRequestDispatcher("views/user/CompleteRegister.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/user/Register.jsp");
		}
	}

}
