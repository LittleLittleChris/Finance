package com.chen.service;

import com.chen.dao.CityDao;
import com.chen.dao.InvoiceDao;
import com.chen.pojo.City;
import com.chen.pojo.GoodsType;
import com.chen.pojo.Invoice;

import java.util.ArrayList;

public class CityService {

	CityDao cityDao = new CityDao();

	/**
	 * 
	 * @param cityName
	 * @return
	 */
	public ArrayList<City> findChildrenByName(String cityName) {
		// TODO Auto-generated method stub
		return cityDao.findChildrenByName(cityName);
	}


}
