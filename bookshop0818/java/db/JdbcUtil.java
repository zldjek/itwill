package db;

import java.sql.*;

import javax.naming.*;
import javax.sql.*;
//모든 메서드를 인스턴스 생성없이 호출 가능하도록 static 으로 선언
public class JdbcUtil {
	//JDBC 연결 후 Connection 객체를 리턴하는 getConnection()메서드 정의
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			 //톰캣 컨텍스트 객체 가져오기
			Context initCtx = new InitialContext();
			 //context.xml 내의 <Resource> 태그 부분 가져오기
			//Context envCtx = (Context)initCtx.lookup("java:comp/env");
			//context.xml 내의 지정된 name 속성항목을 찾아 DataSource 객체(커넥션 풀) 반환
			//DataSource ds = (DataSource)envCtx.lookup("jdbc/MySQLDB");
			// 결합
			DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/MySQL8");
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
	//-----메서드오버로딩을 통한 close() 메서드 정의-----
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
