package com.chen.service;

import java.util.ArrayList;

import com.chen.dao.PullChickDao;
import com.chen.pojo.PullChickens;

public class PullChickService {

	PullChickDao pullChickDao = new PullChickDao();
	
	public void deleteAll() {
		// TODO Auto-generated method stub
		pullChickDao.deleteAll();
	}

	public ArrayList<PullChickens> findAll() {
		// TODO Auto-generated method stub
		return pullChickDao.findAll();
	}

	public void insert(PullChickens updatePullChickens) {
		// TODO Auto-generated method stub
		pullChickDao.insert(updatePullChickens);
	}
}
