package com.chen.servlet.profit;

import com.chen.pojo.*;
import com.chen.service.InvoiceService;
import com.chen.service.PullChickService;
import com.chen.service.StockService;
import com.chen.service.WarehouseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceConfirmServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6898945493512225173L;

	InvoiceService invoiceService = new InvoiceService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");


		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

		if (userInfo != null) {
			Invoice invoice = new Invoice();
			invoice.setCity_from(request.getParameter("city_from"));
			invoice.setCity_to(request.getParameter("city_to"));
			invoice.setBank_card_deposit(request.getParameter("bank_card_deposit"));
			invoice.setBank_card_name(request.getParameter("bank_card_name"));
			invoice.setBank_card_no(request.getParameter("bank_card_no"));
			invoice.setBank_card_deposit(request.getParameter("bank_card_deposit"));
			invoice.setCollection_payment(new BigDecimal(request.getParameter("collection_payment")));
			invoice.setItem_category(request.getParameter("item_category"));
			invoice.setItem_name(request.getParameter("item_name"));
			invoice.setItem_charge(new BigDecimal(request.getParameter("item_charge")));
			invoice.setItem_package(request.getParameter("item_package"));
			invoice.setItem_pay_method(request.getParameter("item_pay_method"));
			invoice.setItem_quantity(new BigDecimal(request.getParameter("item_quantity")));
			invoice.setItem_total(new BigDecimal(request.getParameter("item_total")));
			invoice.setItem_volume(new BigDecimal(request.getParameter("item_volume")));
			invoice.setItem_weight(new BigDecimal(request.getParameter("item_weight")));
			invoice.setOperator(request.getParameter("operator"));
			invoice.setRecipient(request.getParameter("recipient"));
			invoice.setRecipient_address(request.getParameter("recipient_address"));
			invoice.setRecipient_phone(request.getParameter("recipient_phone"));
			invoice.setSender(request.getParameter("sender"));
			invoice.setSender_address(request.getParameter("sender_address"));
			invoice.setSender_phone(request.getParameter("sender_phone"));
			invoiceService.insertInvoice(invoice);

			request.getRequestDispatcher("views/profit/PullChickConfirm.jsp").forward(request, response);
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
