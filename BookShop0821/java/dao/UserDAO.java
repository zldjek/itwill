package dao;

import java.sql.*;

import static db.JdbcUtil.*;
import vo.*;

public class UserDAO {
	// 멤버변수 선언 및 인스턴스 생성
	private static UserDAO instance = new UserDAO();
	// 생성자
	private UserDAO() {}

	public static UserDAO getInstance() {
		return instance;
	}
	private Connection con;
	public void setConnection(Connection con) {
		this.con = con;
	}
	// 로그인
	public boolean selectLoginId(UserDTO user) {
		System.out.println("selectLoginId 실행");
		boolean isLoginSuccess = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user_info WHERE user_id=? AND user_passwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_passwd());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				isLoginSuccess = true;
			}
		} catch (Exception e) {
			System.out.println(" selectLoginId 로그인에러: " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return isLoginSuccess;
	}
	// 내정보
	public UserDTO selectUser(String id) {

		UserDTO user = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user_info WHERE user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserDTO();
				user.setUser_id(rs.getString("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_passwd(rs.getString("user_passwd"));
				user.setUser_address(rs.getString("user_address"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_email(rs.getString("user_email"));
			}
			System.out.println("SQL구문실행완료!");
		} catch (Exception e) {
			System.out.println("selectUser 에러: " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}

		return user;
	}
	// 내정보 수정
	public int updateUser(UserDTO user) {

		int insertCount = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = "UPDATE user_info SET user_name,user_passwd=?,user_address=?,user_phone=?,user_email? WHERE user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_name());
			pstmt.setString(3, user.getUser_passwd());
			pstmt.setString(4, user.getUser_address());
			pstmt.setString(5, user.getUser_phone());
			pstmt.setString(6, user.getUser_email());

			insertCount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateUser에러: " + e.getMessage());
		} finally {
			close(pstmt);
		}

		return insertCount;
	}
	// 회원탈퇴
	public int deleteUser(UserDTO dto) {

		int deleteCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user_info WHERE user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getUser_passwd());

			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				if(dto.getUser_passwd().equals(rs.getString("passwd"))) { // 패스워드가 일치할 경우
					sql = "DELETE FROM user_info WHERE user_passwd=?";
					PreparedStatement pstmt2 = con.prepareStatement(sql);
					pstmt2.setString(1, dto.getUser_id());
					pstmt2.setString(2, dto.getUser_passwd());
					pstmt2.close();
					deleteCount = pstmt2.executeUpdate();
				}
			}
		} catch (Exception e) {
			System.out.println("deleteuser 에러: " + e.getMessage());
		} finally {
			close(pstmt);
		}

		return deleteCount;
	}
	// 마이페이지
	public boolean checkUserid(UserDTO dto) {
		System.out.println("checkUserid 호출");
		boolean userChecked  = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user_info WHERE user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userChecked = true;
			}
		} catch (SQLException e) {
			System.out.println("마이페이지 SQL 구문 오류 : " + e.getMessage());
			e.printStackTrace();
		}
		return userChecked;
	}
}
