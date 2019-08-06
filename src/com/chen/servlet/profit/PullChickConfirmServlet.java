package com.chen.servlet.profit;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.pojo.PullChickens;
import com.chen.pojo.Stock;
import com.chen.pojo.UserInfo;
import com.chen.pojo.Warehouse;
import com.chen.service.PullChickService;
import com.chen.service.StockService;
import com.chen.service.WarehouseService;

public class PullChickConfirmServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6898945493512225173L;

	StockService stockService = new StockService();
	PullChickService pullChickService = new PullChickService();
	WarehouseService warehouseService = new WarehouseService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");

		boolean stock = true;
		BigDecimal sumPriceBigDecimal = new BigDecimal(0);
		BigDecimal sumWeightBigDecimal = new BigDecimal(0);
		BigDecimal priceBigDecimal = new BigDecimal(0);
		BigDecimal tareBigDecimal = new BigDecimal(0);
		BigDecimal suttBigDecimal = new BigDecimal(0);

		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		ArrayList<PullChickens> pullChicks = pullChickService.findAll();

		if (userInfo != null) {
			if (pullChicks != null) {
				for (PullChickens pullChickens : pullChicks) {
					Stock stocks = stockService.backStockWithChickType(userInfo.getUsername(),
							pullChickens.getChickType());
					if (stocks.getSuttle().compareTo(pullChickens.getSuttle()) >= 0
							&& stocks.getTare().compareTo(pullChickens.getTare()) >= 0) {
						stock = true;
					} else {
						stock = false;
						break;
					}
				}

				if (stock) {
					for (PullChickens pullChickens : pullChicks) {
						sumPriceBigDecimal = sumPriceBigDecimal.add(pullChickens.getSumPrice());
						sumWeightBigDecimal = sumWeightBigDecimal.add(pullChickens.getSumWeight());
						priceBigDecimal = priceBigDecimal.add(pullChickens.getPrice());
						tareBigDecimal = tareBigDecimal.add(pullChickens.getTare());
						suttBigDecimal = suttBigDecimal.add(pullChickens.getSuttle());
						Stock nowStock = new Stock();
						nowStock.setChickType(pullChickens.getChickType());
						nowStock.setSuttle(pullChickens.getSuttle());
						nowStock.setTare(pullChickens.getTare());
						nowStock.setUsername(userInfo.getUsername());
						if (stockService.pullChick(nowStock)) {
							Warehouse allHandleType = new Warehouse();
							allHandleType.setGoodsType(pullChickens.getChickType());
							allHandleType.setHandleType(-1);
							allHandleType.setPrice(pullChickens.getPrice());
							allHandleType.setRegion(userInfo.getRegion());
							allHandleType.setSuttle(pullChickens.getSuttle());
							allHandleType.setTare(pullChickens.getTare());
							allHandleType.setUsername(userInfo.getUsername());
							warehouseService.insert(allHandleType);
						}
						System.out.print("price" + priceBigDecimal);
					}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					SimpleDateFormat normal = new SimpleDateFormat("yyyy-MM-dd");

					request.setAttribute("priceBigDecimal", priceBigDecimal);
					request.setAttribute("tareBigDecimal", tareBigDecimal);
					request.setAttribute("priceBigDecimal", priceBigDecimal);
					request.setAttribute("suttleBigDecimal", suttBigDecimal);
					request.setAttribute("sumWeight", sumWeightBigDecimal);
					request.setAttribute("sumPrice", sumPriceBigDecimal);

					request.setAttribute("normalTime", normal.format(new Date()));
					request.setAttribute("nowTime", sdf.format(new Date()));
					request.setAttribute("pullChicks", pullChicks);
					pullChickService.deleteAll();
					request.getRequestDispatcher("views/profit/PullChickConfirm.jsp").forward(request, response);
				} else {
					request.setAttribute("less", "less");
					pullChickService.deleteAll();
					request.getRequestDispatcher("PullChicktransition").forward(request, response);
				}
			} else {
				request.setAttribute("ull", "null");
				request.getRequestDispatcher("PullChicktransition").forward(request, response);
			}

		} else {
			response.sendRedirect("login.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
	}

}
