package com.chen.servlet.user;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.pojo.GoodsType;
import com.chen.pojo.UserInfo;
import com.chen.service.GoodsTypeService;
import com.chen.service.StockService;
import com.chen.service.UserInfoService;

public class RegisterConfirmServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6251910477133710364L;

	UserInfoService userInfoService = new UserInfoService();
	StockService stockService = new StockService();
	GoodsTypeService goodsTypeService = new GoodsTypeService();

	@Override
	protected void doGet(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("username") == null) {
			response.sendRedirect("views/user/Register.jsp");
		}
	}

	public static boolean isNumericzidai(String str) {
		Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]+");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			if (!userInfoService.CheckUserInfoUsername(request.getParameter("username"))
					&& !isNumericzidai(request.getParameter("username"))) {
				if (stockService.createStock(register.getUsername()) && userInfoService.insert(register)) {
					
					  GoodsType goodsType = new GoodsType();
					  goodsType.setGoodsType("水果");
					  goodsType.setUsername(register.getUsername());
					  goodsTypeService.insertType(goodsType);
					 
					request.setAttribute("success", "success");
					request.setAttribute("username", register.getUsername());
				} else {
					request.setAttribute("exist", "exist");
				}
			} else {
				request.setAttribute("exist", "exist");
			}
			request.getRequestDispatcher("views/user/Register.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/user/Register.jsp");
		}
	}
}
