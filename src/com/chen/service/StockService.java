package com.chen.service;

import java.util.ArrayList;

import com.chen.dao.StockDao;
import com.chen.pojo.Stock;

public class StockService {
	
	StockDao stockDao = new StockDao();

	public boolean createStock(String username) {
		// TODO Auto-generated method stub
		return stockDao.createStock(username);
	}

	public ArrayList<Stock> findAllStock(String username) {
		// TODO Auto-generated method stub
		return stockDao.findAllStock(username);
	}

	public void deleteOneData(Stock stock) {
		// TODO Auto-generated method stub
		stockDao.deleteOneData(stock);
	}

	public boolean insert(Stock stock) {
		// TODO Auto-generated method stub
		return stockDao.insert(stock);
	}

	public Stock backStockWithChickType(String username, String chickType) {
		// TODO Auto-generated method stub
		return stockDao.backStockWithChickType(username, chickType);
	}

	public boolean pullChick(Stock nowStock) {
		// TODO Auto-generated method stub
		return stockDao.pullChick(nowStock);
	}

}
