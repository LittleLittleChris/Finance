package com.chen.service;

import java.util.ArrayList;
import java.util.Date;

import com.chen.dao.WarehouseDao;
import com.chen.pojo.Warehouse;

public class WarehouseService {

	WarehouseDao warehouseDao = new WarehouseDao();

	/**
	 * 查詢最近添加貨物记录
	 * 
	 * @param username
	 * @return
	 */
	public ArrayList<Warehouse> findAllWithUsername(String username) {
		// TODO Auto-generated method stub
		return warehouseDao.findAllWithUsername(username);
	}

	/**
	 * 
	 * @param eDate
	 * @param username
	 * @return
	 */
	public ArrayList<Warehouse> findAllWithOneDate(Date start, String username) {
		// TODO Auto-generated method stub
		return warehouseDao.findAllWithOneDate(start, username);
	}

	/***
	 * 
	 * @param sDate
	 * @param eDate
	 * @param username
	 * @return
	 */
	public ArrayList<Warehouse> findAllWithDate(Date start, Date end, String username) {
		// TODO Auto-generated method stub
		return warehouseDao.findAllWithDate(start, end, username);
	}

	public boolean insert(Warehouse warehouse) {
		// TODO Auto-generated method stub
		return warehouseDao.insert(warehouse);
	}

}
