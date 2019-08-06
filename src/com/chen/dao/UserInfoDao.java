package com.chen.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.chen.pojo.UserInfo;
import com.chen.util.JDBCUtils;

public class UserInfoDao {

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public int updatePassword(String username, String password) {
		Connection conn = null;
		Statement stmt = null;
		int num;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "update userInfo set password='" + password + "' where username='" + username + "' ;";
			num = stmt.executeUpdate(sql);
			return num;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.release(stmt, conn);
		}
		return 0;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<UserInfo> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<UserInfo> list = new ArrayList<UserInfo>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from userInfo";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				UserInfo userInfo = new UserInfo();
				userInfo.setUsername(rs.getString("username"));
				userInfo.setPassword(rs.getString("password"));
				userInfo.setpName(rs.getString("pName"));
				userInfo.setRegion(rs.getString("region"));
				userInfo.setAuthority(rs.getInt("authority"));
				list.add(userInfo);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> BackVaryRegion() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select distinct region from userInfo";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString("region"));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	public boolean CheckuserInfoUsername(String username) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from userInfo";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (username.equals(rs.getString("username"))) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}

	/**
	 * 
	 * @param userInfo
	 * @return
	 */
	public boolean insert(UserInfo userInfo) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// set up connection
			conn = JDBCUtils.getConnection();
			// set up statement
			stmt = conn.createStatement();
			String sql = "insert into userInfo(username,password,pName,region,authority) values('"
					+ userInfo.getUsername() + "','" + userInfo.getPassword() + "','" + userInfo.getpName() + "','"
					+ userInfo.getRegion() + "'," + userInfo.getAuthority() + ") ;";
			System.out.print("新增用戶sql：" + sql);
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
}
