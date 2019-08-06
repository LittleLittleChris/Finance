package com.chen.service;

import java.util.ArrayList;

import com.chen.dao.GoodsTypeDao;
import com.chen.pojo.GoodsType;

public class GoodsTypeService {
	
	GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
	
	/**
	 * 
	 * @param goodsType
	 */
	public void insertType(GoodsType goodsType) {
		// TODO Auto-generated method stub
		goodsTypeDao.insertType(goodsType);
	}
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public ArrayList<GoodsType> findAllWithUsername(String username) {
		// TODO Auto-generated method stub
		return goodsTypeDao.findAllWithUsername(username);
	}
	
	/**
	 * 
	 * @param username
	 * @param parameter
	 */
	public void deleteOneChickType(String username, String parameter) {
		// TODO Auto-generated method stub
		goodsTypeDao.deleteOneChickType(username, parameter);
	}

}
