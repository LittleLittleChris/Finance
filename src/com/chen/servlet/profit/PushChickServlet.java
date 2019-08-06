package com.chen.servlet.profit;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.pojo.GoodsType;
import com.chen.pojo.Stock;
import com.chen.pojo.UserInfo;
import com.chen.service.GoodsTypeService;
import com.chen.service.StockService;

public class PushChickServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7447432812057652503L;

	StockService stockService = new StockService();
	GoodsTypeService goodsTypeService = new GoodsTypeService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if (userInfo != null)
		{
			ArrayList<Stock> stocks = stockService.findAllStock(userInfo.getUsername());
			ArrayList<GoodsType> publicType = goodsTypeService.findAllWithUsername(userInfo.getUsername());
			
			request.setAttribute("regard", stocks);
			request.setAttribute("allType", publicType);
			request.getRequestDispatcher("views/profit/PushChickens.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("login.jsp");
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
			if (request.getAttribute("completePush") != null)
			{
				request.setAttribute("completePush", "yes");
			}
			
			if (request.getParameter("chick") != null)
			{
				String chickType = request.getParameter("chick");
				Stock stock = new Stock();
				stock.setChickType(chickType);
				stock.setUsername(userInfo.getUsername());
				stockService.deleteOneData(stock);
			}
			ArrayList<GoodsType> publicType = goodsTypeService.findAllWithUsername(userInfo.getUsername());
			ArrayList<Stock> allWithUsername = stockService.findAllStock(userInfo.getUsername());
			request.setAttribute("regard", allWithUsername);
			request.setAttribute("allType", publicType);
			request.getRequestDispatcher("views/profit/PushChickens.jsp").forward(request, response);
			
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}
}
