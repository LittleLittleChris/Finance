package com.chen.servlet.profit;

import com.chen.pojo.City;
import com.chen.pojo.Invoice;
import com.chen.pojo.UserInfo;
import com.chen.service.CityService;
import com.chen.service.InvoiceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

public class FormSubmit extends HttpServlet {

	CityService cityService = new CityService();

	/**
	 * 
	 */
	private static final long serialVersionUID = 6898945493512225175L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");


		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

		if (userInfo != null) {
			PrintWriter out = response.getWriter();
			String cityName = request.getParameter("cityName");
			ArrayList<City> cities = cityService.findChildrenByName(cityName);
			StringBuffer sb = new StringBuffer();
			for (City city : cities) {
				String name = city.getName();
				sb.append("<div class=\"div_city\" onclick=''>"+name+"</div>");
			}
			out.write(sb.toString());
			out.flush();
			out.close();
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
	}

}
