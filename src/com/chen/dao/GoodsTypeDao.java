package com.chen.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.chen.pojo.GoodsType;
import com.chen.util.JDBCUtils;

public class GoodsTypeDao {

	public boolean insertType(GoodsType goodsType) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// set up connection
			conn = JDBCUtils.getConnection();
			// set up statement
			stmt = conn.createStatement();
			ArrayList<GoodsType> all = findAllWithUsername(goodsType.getUsername());
			for (GoodsType a : all) {
				if (goodsType.getGoodsType().equals(a.getGoodsType())) {
					return false;
				}
			}
			String sql = "insert into goodsType(goodsType,username,price) values('"
					+ goodsType.getGoodsType() + "','" + goodsType.getUsername()  + "','" + goodsType.getPrice() + "') ;";
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
	
	public ArrayList<GoodsType> findAllWithUsername(String username) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<GoodsType> list = new ArrayList<GoodsType>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from goodsType order by id desc";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				GoodsType goodsType = new GoodsType();
				goodsType.setGoodsType(rs.getString("goodsType"));
				goodsType.setUsername(rs.getString("username"));
				goodsType.setPrice(Double.parseDouble(rs.getString("price")));
				goodsType.setId(rs.getInt("id"));
				list.add(goodsType);
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

	public boolean deleteOneChickType(String username, String chickType) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String delete = "delete from goodsType where username='" + username + "' and" + " goodsType='"
					+ chickType + "'";
			if (stmt.executeUpdate(delete) > 0)
				return true;
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.release(stmt, conn);
		}
		return false;
	}
}
