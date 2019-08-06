package com.chen.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.pojo.UserInfo;
import com.chen.pojo.Warehouse;
import com.chen.service.UserInfoService;
import com.chen.service.WarehouseService;

/**
 * 
 * @author chenguoji
 *
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4441439929741971883L;

	private WarehouseService warehouseService = new WarehouseService();

	UserInfoService userInfoService = new UserInfoService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		if (session.getAttribute("userInfo") != null) {
			UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
			ArrayList<Warehouse> all = warehouseService.findAllWithUsername(userInfo.getUsername());
			request.setAttribute("allRegard", all);
			request.getRequestDispatcher("main/Home.jsp").forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		if (session.getAttribute("userInfo") != null && username == null)// 搜索
		{
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date sDate = null;
			java.util.Date eDate = null;
			ArrayList<Warehouse> all = null;
			UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
			if (request.getParameter("startDate") != null && request.getParameter("endDate") != null) {
				if (!request.getParameter("startDate").equals("") && !request.getParameter("endDate").equals("")) {
					try {
						eDate = sdf.parse(endDate);
						sDate = sdf.parse(startDate);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (sDate.before(eDate)) {
						request.setAttribute("sDate", new java.sql.Date(sDate.getTime()).toString());
						request.setAttribute("eDate", new java.sql.Date(eDate.getTime()).toString());
						all = warehouseService.findAllWithDate(sDate, eDate, userInfo.getUsername());
					} else if (sDate.equals(eDate)) {
						request.setAttribute("oneDate", new java.sql.Date(sDate.getTime()).toString());
						all = warehouseService.findAllWithOneDate(sDate, userInfo.getUsername());
					} else {
						request.setAttribute("errorTime", "erroeTime");
						all = warehouseService.findAllWithUsername(userInfo.getUsername());
					}
				} else if (!request.getParameter("startDate").equals("")
						&& request.getParameter("endDate").equals("")) {
					try {
						sDate = sdf.parse(startDate);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					request.setAttribute("oneDate", new java.sql.Date(sDate.getTime()).toString());
					all = warehouseService.findAllWithOneDate(sDate, userInfo.getUsername());
				} else if (request.getParameter("startDate").equals("")
						&& !request.getParameter("endDate").equals("")) {
					try {
						eDate = sdf.parse(startDate);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					request.setAttribute("oneDate", new java.sql.Date(eDate.getTime()).toString());
					all = warehouseService.findAllWithOneDate(eDate, userInfo.getUsername());
				}
			} else {
				all = warehouseService.findAllWithUsername(userInfo.getUsername());
			}
			request.setAttribute("allRegard", all);
			request.getRequestDispatcher("views/index.jsp").forward(request, response);
		} else {// 登錄
			if (userInfoService.login(username, password)) {
				UserInfo userInfo = new UserInfo();
				userInfo = userInfoService.backUserInfo(username);
				session.setAttribute("userInfo", userInfo);
				ArrayList<Warehouse> all = warehouseService.findAllWithUsername(username);
				request.setAttribute("allRegard", all);
				request.getRequestDispatcher("views/index.jsp").forward(request, response);
			} else {
				session.removeAttribute("userInfo");
				request.setAttribute("error", "用户名和密码错误，登录失败！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}

}
