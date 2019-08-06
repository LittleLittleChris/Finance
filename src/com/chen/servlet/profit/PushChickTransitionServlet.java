package com.chen.servlet.profit;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.pojo.PullChickens;
import com.chen.pojo.UserInfo;
import com.chen.pojo.Warehouse;
import com.chen.service.PullChickService;

public class PushChickTransitionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4676839021120294449L;
	
	PullChickService pullChickService = new PullChickService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		ArrayList<PullChickens> pullChickens = pullChickService.findAll();//出货
		if (userInfo != null && pullChickens != null)
		{
			request.setAttribute("pullChickens", pullChickens);
			request.getRequestDispatcher("views/profit/PullChickConfirm.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("views/index.jsp");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if (userInfo != null)
		{
			String chickType = request.getParameter("chickType");
			BigDecimal tare = new BigDecimal(request.getParameter("tare"));
			BigDecimal suttle = new BigDecimal(request.getParameter("suttle"));
			BigDecimal price = new BigDecimal(request.getParameter("price"));
		    String username = userInfo.getUsername();
		    Warehouse allHandleType = new Warehouse();
			allHandleType.setGoodsType(chickType);
			allHandleType.setDate(new java.sql.Date(new Date().getTime()));
			allHandleType.setHandleType(1);
			allHandleType.setPrice(price);
			allHandleType.setSuttle(suttle);
			allHandleType.setTare(tare);
			allHandleType.setUsername(username);
			allHandleType.setRegion(userInfo.getRegion());
			request.setAttribute("allHandle", allHandleType);
			request.getRequestDispatcher("views/profit/PushChickConfirm.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}
	
}
