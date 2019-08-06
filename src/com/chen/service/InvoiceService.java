package com.chen.service;

import com.chen.dao.GoodsTypeDao;
import com.chen.dao.InvoiceDao;
import com.chen.pojo.GoodsType;
import com.chen.pojo.Invoice;

import java.util.ArrayList;

public class InvoiceService {
	
	InvoiceDao invoiceDao = new InvoiceDao();
	
	/**
	 * 
	 * @param invoice
	 */
	public void insertInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		invoiceDao.insertInvoice(invoice);
	}
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public ArrayList<GoodsType> findAllWithUsername(String username) {
		// TODO Auto-generated method stub
		return invoiceDao.findAllWithUsername(username);
	}


}
