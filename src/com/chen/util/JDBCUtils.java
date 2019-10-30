package com.chen.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/***
 * 
 * JDBC链接数据库
 * 
 * @author chenguoji
 *
 */
public class JDBCUtils {

	static String className = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://db.speedclub.xyz:3306/financesystem?useUnicode=true&characterEncoding=utf8&useSSL=false";
	static String user = "root";// 用户名
	static String password = "110110119";// 密码

	// connect to MYSQL,database name is userInfo
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(className);
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	// release SQL connection
	public static void release(Statement stmt, Connection conn) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void release(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		release(stmt, conn);
	}
}
