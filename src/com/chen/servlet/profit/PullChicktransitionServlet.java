package com.chen.servlet.profit;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.pojo.Stock;
import com.chen.pojo.UserInfo;
import com.chen.service.PullChickService;
import com.chen.service.StockService;

public class PullChicktransitionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1369198912196608977L;

	StockService stockService = new StockService();
	PullChickService pullChickService = new PullChickService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if (userInfo != null) {
			ArrayList<Stock> stocks = stockService.findAllStock(userInfo.getUsername());
			ArrayList<Stock> publicType = stockService.findAllStock(userInfo.getUsername());
			pullChickService.deleteAll();
			request.setAttribute("regard", stocks);
			request.setAttribute("allType", publicType);

			if (request.getAttribute("less") != null) {
				request.setAttribute("less", "less");
			}

			if (request.getAttribute("ull") != null) {
				request.setAttribute("ull", "null");
			}

			request.getRequestDispatcher("views/profit/PullChickens.jsp").forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if (userInfo != null) {
			ArrayList<Stock> stocks = stockService.findAllStock(userInfo.getUsername());
			ArrayList<Stock> publicType = stockService.findAllStock(userInfo.getUsername());
			pullChickService.deleteAll();
			request.setAttribute("regard", stocks);
			request.setAttribute("allType", publicType);

			if (request.getAttribute("less") != null) {
				request.setAttribute("less", "less");
			}

			request.getRequestDispatcher("views/profit/PullChickens.jsp").forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
