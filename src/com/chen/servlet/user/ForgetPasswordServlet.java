package com.chen.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chen.pojo.UserInfo;
import com.chen.service.UserInfoService;

/**
 * 找回密碼
 * 
 * @author chenguoji
 *
 */
public class ForgetPasswordServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4625598058967758983L;

	UserInfoService userInfoService = new UserInfoService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("index.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");
		if (userInfoService.CheckUserInfoUsername(username))// 查詢用戶名是否存在
		{
			UserInfo userInfo = userInfoService.backUserInfo(username);
			if (userInfo.getpName().equals(request.getParameter("pName"))
					&& userInfo.getRegion().equals(request.getParameter("region"))) {
				request.setAttribute("username", username);
			} else {
				request.setAttribute("username", "no");
			}
		} else {
			request.setAttribute("username", "no");
		}
		request.getRequestDispatcher("views/user/UpdatePassword.jsp").forward(request, response);
	}

}
