package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	private static String url = "jdbc:oracle:thin://localhost:1521/orcl";
	private static String username = "orcl";
	private static String password = "orcl";
	static {
		try { 
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

	public static void release(ResultSet rs, PreparedStatement ps,
			Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Connection  con = getConnection();
		System.out.println(con);
	}
}
