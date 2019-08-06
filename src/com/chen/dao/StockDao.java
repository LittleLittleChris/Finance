package com.chen.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.chen.pojo.Stock;
import com.chen.util.JDBCUtils;

public class StockDao {

	public boolean createStock(String username) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// set up connection
			conn = JDBCUtils.getConnection();
			// set up statement
			stmt = conn.createStatement();
			String createTable = "CREATE TABLE " + username + " (tare decimal(15,2) NOT NULL,"
					+ "suttle decimal(15,2) NOT NULL,price decimal(15,2) NOT NULL,chickType varchar(20) NOT NULL,"
					+ "PRIMARY KEY (`chickType`),UNIQUE KEY `chickType_UNIQUE` (`chickType`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;";
			int num = stmt.executeUpdate(createTable);
			System.out.print("新增用户sql：" + num);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
	}

	public ArrayList<Stock> findAllStock(String username) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Stock> list = new ArrayList<Stock>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String selectTable = "select * from " + username;
			rs = stmt.executeQuery(selectTable);
			while (rs.next()) {
				Stock stock = new Stock();
				stock.setChickType(rs.getString("chickType"));
				stock.setPrice(rs.getBigDecimal("price"));
				stock.setSuttle(rs.getBigDecimal("suttle"));
				stock.setTare(rs.getBigDecimal("tare"));
				list.add(stock);
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
	
	public boolean deleteOneData(Stock stock) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// set up connection
			conn = JDBCUtils.getConnection();
			// set up statement
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from ").append(stock.getUsername()).append(" where chickType='")
					.append(stock.getChickType()).append("'");
			int num = stmt.executeUpdate(sql.toString());
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
	
	public boolean insert(Stock Stock) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Boolean flag = false;
		try {
			// set up connection
			conn = JDBCUtils.getConnection();
			// set up statement
			stmt = conn.createStatement();
			String selectTable = "select * from " + Stock.getUsername();
			rs = stmt.executeQuery(selectTable);
			while (rs.next()) {
				System.out.print(Stock.getChickType() + rs.getString("chickType"));
				if (Stock.getChickType().equals(rs.getString("chickType"))) {
					flag = true;
					break;
				}
			}
			if (flag) {
				String sqlAdd = "update " + Stock.getUsername() + " set tare=tare+" + Stock.getTare()
						+ ",suttle=suttle+" + Stock.getSuttle() + ",price=" + Stock.getPrice() + " where chickType='"
						+ Stock.getChickType() + "'";
				int re = stmt.executeUpdate(sqlAdd.toString());
				if (re > 0) {
					return true;
				}
				return false;
			} else {
				String sql = "insert into " + Stock.getUsername() + "(chickType,price,tare,suttle) values('"
						+ Stock.getChickType() + "'," + Stock.getPrice() + "," + Stock.getTare() + ","
						+ Stock.getSuttle() + ")";
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

	public Stock backStockWithChickType(String username, String chickType) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// set up connection
			conn = JDBCUtils.getConnection();
			// set up statement
			stmt = conn.createStatement();
			String selectTable = "select * from " + username;
			rs = stmt.executeQuery(selectTable);
			while (rs.next()) {
				System.out.print(chickType + rs.getString("chickType"));
				if (chickType.equals(rs.getString("chickType"))) {
					Stock stock = new Stock();
					stock.setChickType(rs.getString("chickType"));
					stock.setPrice(rs.getBigDecimal("price"));
					stock.setSuttle(rs.getBigDecimal("suttle"));
					stock.setTare(rs.getBigDecimal("tare"));
					return stock;
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}

	public boolean pullChick(Stock Stock) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// set up connection
			conn = JDBCUtils.getConnection();
			// set up statement
			stmt = conn.createStatement();
			String sql = "update " + Stock.getUsername() + " set tare=tare-" + Stock.getTare() + ",suttle=suttle-"
					+ Stock.getSuttle() + " where chickType='" + Stock.getChickType() + "'";
			int re = stmt.executeUpdate(sql);
			if (re > 0) {
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
