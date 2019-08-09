package com.chen.dao;

import com.chen.pojo.City;
import com.chen.pojo.GoodsType;
import com.chen.pojo.Invoice;
import com.chen.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CityDao {

	public ArrayList<City> findChildrenByName(String cityName) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<City> list = new ArrayList<City>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from city c1\n" +
					"left join city c2 on c1.parent_id=c2.id\n" +
					"where c2.name like '%"+ cityName +"%' order by c1.id desc";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
			while (rs.next()) {
				City city = new City();
				city.setName(rs.getString("name"));
				city.setId(rs.getInt("id"));
				list.add(city);
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
