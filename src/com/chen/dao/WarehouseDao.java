package com.chen.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.chen.pojo.Warehouse;
import com.chen.util.JDBCUtils;

public class WarehouseDao {

	/**
	 * 新增货物
	 * 
	 * @param warehouse
	 * @return
	 */
	public boolean insert(Warehouse warehouse) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// set up connection
			conn = JDBCUtils.getConnection();
			// set up statement
			stmt = conn.createStatement();
			String sql = "insert into warehouse (goodsType,date,tare,suttle,price,handleType,username,region) values('"
					+ warehouse.getGoodsType() + "','" + new java.sql.Date(new Date().getTime()) + "',"
					+ warehouse.getTare() + "," + warehouse.getSuttle() + "," + warehouse.getPrice() + ","
					+ warehouse.getHandleType() + ",'" + warehouse.getUsername() + "','" + warehouse.getRegion() + "') ;";
			System.out.print("新增货物sql:" + sql);
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

	/**
	 * 搜索
	 * 
	 * @param start
	 * @param end
	 * @param username
	 * @return
	 */
	public ArrayList<Warehouse> findAllWithDate(Date start, Date end, String username) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Warehouse> list = new ArrayList<Warehouse>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();

			String sql = "select * from warehouse where username='" + username + "' and date>='"
					+ new java.sql.Date(start.getTime()) + "' and date<='" + new java.sql.Date(end.getTime())
					+ "' order by date desc";
			rs = stmt.executeQuery(sql);
			System.out.print("搜索sql：" + sql);
			while (rs.next()) {
				Warehouse warehouse = new Warehouse();
				warehouse.setGoodsType(rs.getString("goodsType"));
				warehouse.setDate(rs.getDate("date"));
				warehouse.setId(rs.getInt("id"));
				warehouse.setRegion(rs.getString("region"));
				warehouse.setTare(rs.getBigDecimal("tare"));
				warehouse.setSuttle(rs.getBigDecimal("suttle"));
				warehouse.setPrice(rs.getBigDecimal("price"));
				warehouse.setUsername(rs.getString("username"));
				warehouse.setHandleType(rs.getInt("handleType"));
				list.add(warehouse);
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
	 * 搜索 出货 记录
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public ArrayList<Warehouse> findAllWithStartToEnd(Date start, Date end) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Warehouse> list = new ArrayList<Warehouse>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from warehouse where handleType=-1 and date>='" + new java.sql.Date(start.getTime())
					+ "' and date<='" + new java.sql.Date(end.getTime()) + "' order by date desc";
			rs = stmt.executeQuery(sql);
			System.out.println("搜索出货sql:" + sql);
			while (rs.next()) {
				boolean flag = true;
				Warehouse warehouse = new Warehouse();
				warehouse.setGoodsType(rs.getString("goodsType"));
				warehouse.setDate(rs.getDate("date"));
				warehouse.setId(rs.getInt("id"));
				warehouse.setRegion(rs.getString("region"));
				warehouse.setTare(rs.getBigDecimal("tare"));
				warehouse.setSuttle(rs.getBigDecimal("suttle"));
				warehouse.setPrice(rs.getBigDecimal("price"));
				warehouse.setUsername(rs.getString("username"));
				warehouse.setHandleType(rs.getInt("handleType"));
				warehouse.setSumPrice(warehouse.getSuttle().multiply(warehouse.getPrice()));
				for (Warehouse Warehouse2 : list) {
					if (warehouse.getRegion().equals(Warehouse2.getRegion())
							&& warehouse.getDate().equals(Warehouse2.getDate())) {
						Warehouse2.setSumPrice(Warehouse2.getSumPrice().add(warehouse.getSumPrice()));
						flag = false;
					}
				}
				if (flag) {
					list.add(warehouse);
				}
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
	 * 搜索当前店铺下的商品
	 * 
	 * @param start
	 * @param username
	 * @return
	 */
	public ArrayList<Warehouse> findAllWithOneDate(Date start, String username) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Warehouse> list = new ArrayList<Warehouse>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from warehouse where username='" + username + "' and date='"
					+ new java.sql.Date(start.getTime()) + "' order by date desc";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Warehouse warehouse = new Warehouse();
				warehouse.setGoodsType(rs.getString("goodsType"));
				warehouse.setDate(rs.getDate("date"));
				warehouse.setId(rs.getInt("id"));
				warehouse.setRegion(rs.getString("region"));
				warehouse.setTare(rs.getBigDecimal("tare"));
				warehouse.setSuttle(rs.getBigDecimal("suttle"));
				warehouse.setPrice(rs.getBigDecimal("price"));
				warehouse.setUsername(rs.getString("username"));
				warehouse.setHandleType(rs.getInt("handleType"));
				list.add(warehouse);
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
	 * 搜索当前登录用户商品记录
	 * 
	 * @param username
	 * @return
	 */
	public ArrayList<Warehouse> findAllWithUsername(String username) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Warehouse> list = new ArrayList<Warehouse>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from warehouse where username='" + username + "' order by date desc limit 10";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Warehouse warehouse = new Warehouse();
				warehouse.setGoodsType(rs.getString("goodsType"));
				warehouse.setDate(rs.getDate("date"));
				warehouse.setId(rs.getInt("id"));
				warehouse.setRegion(rs.getString("region"));
				warehouse.setTare(rs.getBigDecimal("tare"));
				warehouse.setSuttle(rs.getBigDecimal("suttle"));
				warehouse.setPrice(rs.getBigDecimal("price"));
				warehouse.setUsername(rs.getString("username"));
				warehouse.setHandleType(rs.getInt("handleType"));
				list.add(warehouse);
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
	public ArrayList<Warehouse> findAllLimitTen() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Warehouse> list = new ArrayList<Warehouse>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from warehouse order by date desc limit 10";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Warehouse Warehouse = new Warehouse();
				Warehouse.setGoodsType(rs.getString("goodsType"));
				Warehouse.setDate(rs.getDate("date"));
				Warehouse.setId(rs.getInt("id"));
				Warehouse.setRegion(rs.getString("region"));
				Warehouse.setTare(rs.getBigDecimal("tare"));
				Warehouse.setSuttle(rs.getBigDecimal("suttle"));
				Warehouse.setPrice(rs.getBigDecimal("price"));
				Warehouse.setUsername(rs.getString("username"));
				Warehouse.setHandleType(rs.getInt("handleType"));
				list.add(Warehouse);
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

	public ArrayList<Warehouse> findAllWithUsernameAndDate(String username) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Warehouse> list = new ArrayList<Warehouse>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			System.out.print(username);

			String sql = "select * from Warehouse where username='" + username + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Warehouse Warehouse = new Warehouse();
				Warehouse.setGoodsType(rs.getString("goodsType"));
				Warehouse.setDate(rs.getDate("date"));
				Warehouse.setId(rs.getInt("id"));
				Warehouse.setTare(rs.getBigDecimal("tare"));
				Warehouse.setSuttle(rs.getBigDecimal("suttle"));
				Warehouse.setRegion(rs.getString("region"));
				Warehouse.setPrice(rs.getBigDecimal("price"));
				Warehouse.setUsername(rs.getString("username"));
				Warehouse.setHandleType(rs.getInt("handleType"));
				list.add(Warehouse);
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

	public ArrayList<Warehouse> findAllWithSql(String sql) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Warehouse> list = new ArrayList<Warehouse>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Warehouse Warehouse = new Warehouse();
				Warehouse.setGoodsType(rs.getString("goodsType"));
				Warehouse.setDate(rs.getDate("date"));
				Warehouse.setId(rs.getInt("id"));
				Warehouse.setRegion(rs.getString("region"));
				Warehouse.setTare(rs.getBigDecimal("tare"));
				Warehouse.setSuttle(rs.getBigDecimal("suttle"));
				Warehouse.setPrice(rs.getBigDecimal("price"));
				Warehouse.setUsername(rs.getString("username"));
				Warehouse.setHandleType(rs.getInt("handleType"));
				list.add(Warehouse);
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
