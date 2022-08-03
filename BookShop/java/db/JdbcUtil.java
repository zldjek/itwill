package db;

import java.sql.*;

import javax.naming.*;
import javax.sql.*;

public class JdbcUtil {
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/mysql");
			con = ds.getConnection();
			con.setAutoCommit(false);
			System.out.println("connect succes");
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void close(Connection con) {
		try {
			con.close();
			System.out.println("con.close()");
		} catch (SQLException e) {
			System.out.println("DB연결오류" + e.getMessage());
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
			System.out.println("pstmt.close()");
		} catch (SQLException e) {
			System.out.println("SQL구문 오류" + e.getMessage());
			e.printStackTrace();
		}

	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
			System.out.println("rs.close()");
		} catch (SQLException e) {
			System.out.println("전달값 오류" + e.getMessage());
			e.printStackTrace();
		}
	}
	public static void commit(Connection con) {
		try {
			con.commit();
			System.out.println("commit success!");
		} catch (SQLException e) {
			System.out.println("commit 실패!");
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con) {
		try {
			con.rollback();
			System.out.println("rollback success!");
		} catch (SQLException e) {
			System.out.println("rollback 실패!");
			e.printStackTrace();
		}
	}
}
