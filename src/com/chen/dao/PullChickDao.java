package com.chen.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.chen.pojo.PullChickens;
import com.chen.util.JDBCUtils;

/**
 * 出货
 * @author chenguoji
 *
 */
public class PullChickDao {

	public void deleteAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// set up connection
			conn = JDBCUtils.getConnection();
			// set up statement
			stmt = conn.createStatement();

			String sql = "delete from pullChick";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
	}

	public ArrayList<PullChickens> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<PullChickens> list = new ArrayList<PullChickens>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from pullChick";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				PullChickens PullChick = new PullChickens();
				PullChick.setChickType(rs.getString("chickType"));
				PullChick.setPrice(rs.getBigDecimal("price"));
				PullChick.setTare(rs.getBigDecimal("tare"));
				PullChick.setSuttle(rs.getBigDecimal("suttle"));
				PullChick.setSumWeight(rs.getBigDecimal("sumWeight"));
				PullChick.setSumPrice(rs.getBigDecimal("sumPrice"));
				list.add(PullChick);
			}
			if (list.size() == 0) {
				return null;
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

	public boolean insert(PullChickens PullChickens) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Boolean flag = false;
		try {
			// set up connection
			conn = JDBCUtils.getConnection();
			// set up statement
			stmt = conn.createStatement();
			String selectTable = "select * from pullChick";
			rs = stmt.executeQuery(selectTable);
			while (rs.next()) {
				System.out.print(PullChickens.getChickType() + rs.getString("chickType"));
				if (PullChickens.getChickType().equals(rs.getString("chickType"))) {
					flag = true;
					break;
				}
			}
			if (flag) {
				String sqlAdd = "update pullChick" + " set tare=tare+" + PullChickens.getTare() + ",suttle=suttle+"
						+ PullChickens.getSuttle() + ",price=price+" + PullChickens.getPrice() + ",sumPrice=sumPrice+"
						+ PullChickens.getSumPrice() + ",sumWeight=sumWeight+" + PullChickens.getSumWeight()
						+ " where chickType='" + PullChickens.getChickType() + "' ;";
				int re = stmt.executeUpdate(sqlAdd);
				if (re > 0) {
					return true;
				}
				return false;
			} else {
				String sql = "insert into pullChick (chickType,price,tare,suttle,sumWeight,sumPrice) values('"
						+ PullChickens.getChickType() + "'," + PullChickens.getPrice() + "," + PullChickens.getTare()
						+ "," + PullChickens.getSuttle() + "," + PullChickens.getSumWeight() + ","
						+ PullChickens.getSumPrice() + ") ;";
				int num = stmt.executeUpdate(sql);
				if (num > 0) {
					return true;
				}
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
	
}
