package jp.co.sss.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	public static Connection getConnection() {
		java.sql.Connection con = null;
		java.sql.Statement stmt = null;
		ResultSet rset = null;
		// URLの指定
//		String url = "jdbc:postgresql://localhost:5432/postgres";
		String url = "jdbc:postgresql://localhost:5432/jsp_sample";
		// ユーザネームの指定
		String user = "postgres";
//		String user = "pizza_manager";
		// パスワードの設定
		String pass = "Sakaedesu1O18";
//		String pass = "sytemsss";
		try {
			Class.forName("org.postgresql.Driver");
			// PostgreSQLへ接続
			con = DriverManager.getConnection(
					url,
					user,
					pass
				);
			// 自動コミットOFF
			con.setAutoCommit(false);
			// SELECT文の実行
//			stmt = con.createStatement();
//			String sql = "SELECT 1";
//			rset = stmt.executeQuery(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement ps, Connection con) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
