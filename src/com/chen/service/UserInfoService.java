package com.chen.service;

import java.util.ArrayList;

import com.chen.dao.UserInfoDao;
import com.chen.pojo.UserInfo;

public class UserInfoService {

	UserInfoDao userInfoDao = new UserInfoDao();

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		ArrayList<UserInfo> userInfos = userInfoDao.findAll();
		for (UserInfo userInfo : userInfos) {
			if (userInfo.getUsername().equals(username) && userInfo.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	public UserInfo backUserInfo(String username) {
		// TODO Auto-generated method stub
		ArrayList<UserInfo> userInfos = userInfoDao.findAll();
		for (UserInfo userInfo : userInfos) {
			if (userInfo.getUsername().equals(username)) {
				return userInfo;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	public String BackAccountpName(String username) {
		ArrayList<UserInfo> userInfos = userInfoDao.findAll();
		for (UserInfo userInfo : userInfos) {
			if (userInfo.getUsername().equals(username)) {
				return userInfo.getpName();
			}
		}
		return null;
	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	public boolean CheckUserInfoUsername(String username) {
		// TODO Auto-generated method stub
		return userInfoDao.CheckuserInfoUsername(username);
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public int updatePassword(String username, String password) {
		// TODO Auto-generated method stub
		return userInfoDao.updatePassword(username, password);
	}

	/**
	 * 
	 * @param userInfo
	 * @return
	 */
	public boolean insert(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoDao.insert(userInfo);
	}
}
