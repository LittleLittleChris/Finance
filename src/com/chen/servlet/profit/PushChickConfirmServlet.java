package com.chen.servlet.profit;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.pojo.Stock;
import com.chen.pojo.UserInfo;
import com.chen.pojo.Warehouse;
import com.chen.service.StockService;
import com.chen.service.WarehouseService;

public class PushChickConfirmServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4537294304138971941L;

	StockService stockService = new StockService();
	WarehouseService warehouseService = new WarehouseService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if (userInfo != null && request.getParameter("chickType") != null)
		{
			
			String chickType = request.getParameter("chickType");
			BigDecimal tare = new BigDecimal(request.getParameter("tare"));
			BigDecimal suttle = new BigDecimal(request.getParameter("suttle"));
			BigDecimal price = new BigDecimal(request.getParameter("price"));

			Stock stock = new Stock();
			String username = userInfo.getUsername();
			Warehouse allHandleType = new Warehouse();
			allHandleType.setGoodsType(chickType);
			allHandleType.setDate(new java.sql.Date(new Date().getTime()));
			allHandleType.setHandleType(1);
			allHandleType.setPrice(price);
			allHandleType.setSuttle(suttle);
			allHandleType.setTare(tare);
			allHandleType.setUsername(username);
			stock.setPrice(price);
			stock.setSuttle(suttle);
			stock.setTare(tare);
			stock.setChickType(chickType);
			stock.setUsername(username);
			allHandleType.setRegion(request.getParameter("region"));
			if (warehouseService.insert(allHandleType) && stockService.insert(stock))
			{
				request.setAttribute("completePush", "yes");
				request.getRequestDispatcher("PushChick").forward(request, response);
			}
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}

}
