package com.chen.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chen.service.UserInfoService;

public class UpdateUserInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -955135875993469947L;

	UserInfoService userInfoService = new UserInfoService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username != null || password != null) {
			if (userInfoService.updatePassword(username, password) > 0) {
				request.setAttribute("password", password);
				request.getRequestDispatcher("views/user/CompleteUpdatePassword.jsp").forward(request, response);
			} else {
				request.setAttribute("password", "notcomplete");
				request.getRequestDispatcher("views/user/CompleteUpdatePassword.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("views/user/UpdatePassword.jsp");
		}

	}
}
