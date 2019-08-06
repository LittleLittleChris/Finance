package com.chen.servlet.profit;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.pojo.GoodsType;
import com.chen.pojo.PullChickens;
import com.chen.pojo.Stock;
import com.chen.pojo.UserInfo;
import com.chen.service.GoodsTypeService;
import com.chen.service.PullChickService;
import com.chen.service.StockService;

public class PullChickServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -378641339143690161L;
	
	StockService stockService = new StockService();
	PullChickService pullChickService = new PullChickService();
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
			ArrayList<Stock> publicType = stockService.findAllStock(userInfo.getUsername());
			ArrayList<GoodsType> goodsTypes = goodsTypeService.findAllWithUsername(userInfo.getUsername());
			pullChickService.deleteAll();
			request.setAttribute("regard", stocks);
			request.setAttribute("allType", publicType);
			request.setAttribute("goodsTypes" ,goodsTypes);

			
			request.getRequestDispatcher("views/profit/PullChickens.jsp").forward(request, response);
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
			String chickType = request.getParameter("chickType");
			BigDecimal tare = new BigDecimal(request.getParameter("tare"));
			BigDecimal suttle = new BigDecimal(request.getParameter("suttle"));
			BigDecimal price = new BigDecimal(request.getParameter("price"));
			
			PullChickens updatePullChickens = new PullChickens();
			updatePullChickens.setChickType(chickType);
			updatePullChickens.setTare(tare);
			updatePullChickens.setPrice(price);
			updatePullChickens.setSuttle(suttle);
			updatePullChickens.setSumPrice(suttle.multiply(price));
			updatePullChickens.setSumWeight(tare.add(suttle));
			pullChickService.insert(updatePullChickens);

			ArrayList<Stock> stocks = stockService.findAllStock(userInfo.getUsername());
			ArrayList<Stock> publicType = stockService.findAllStock(userInfo.getUsername());
			ArrayList<PullChickens> pullChickens = pullChickService.findAll();
			request.setAttribute("regard", stocks);
			request.setAttribute("allType", publicType);
			request.setAttribute("pullChickens", pullChickens);
			
			request.getRequestDispatcher("views/profit/PullChickens.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}
}
