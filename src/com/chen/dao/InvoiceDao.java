package com.chen.dao;

import com.chen.pojo.GoodsType;
import com.chen.pojo.Invoice;
import com.chen.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class InvoiceDao {

	public boolean insertInvoice(Invoice invoice) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into invoice(create_time,username,price,) values('"
					+ invoice.getCreateTime() + "','"
					+ invoice.getSendTime()  + "','"
					+ invoice.getCity_from() + "','"
					+ invoice.getCity_from() + "','"
					+ invoice.getCity_from() + "','"
					+ invoice.getCity_from() + "','"
					+ invoice.getCity_from() + "','"
					+ invoice.getCity_from() + "','"
					+ invoice.getCity_from() + "','"
					+ invoice.getCity_from() + "','"
					+ invoice.getCity_from() + "','"
					+ invoice.getCity_from() + "','"
					+ invoice.getCity_from() + "','"
					+ invoice.getCity_from() + "','"
					+ invoice.getCity_from() + "','"
					+ invoice.getCity_from() + "','"
					+ invoice.getCity_from() + "','"
					+ invoice.getCity_from() + "','"
					+ invoice.getCity_from() + "','"

					+ "') ;";
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
			String sql = "select * from goodsType where username='" + username + "' order by id desc";
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

}
