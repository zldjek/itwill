package dao;

import java.sql.*;
import static db.JdbcUtil.*;
import vo.*;

public class UserDAO {
	public static UserDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	private UserDAO() {
	}

	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}
	public String selectLoginId(UserDTO user) {
		
		String loginId = null;
		
		try {
			String sql = "SELECT user_id FROM user_info WHERE user_id=? AND user_passwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_passwd());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				loginId = rs.getString("user_id");
			}
		} catch (Exception e) {
			System.out.println(" 에러: " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return loginId;
	}
	
	public UserDTO selectUser(String id) {

		UserDTO user = null;

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

	public int insertUser(UserDTO user) {

		int insertCount = 0;

		try {
			String sql = "INSERT INTO user_info VALUES (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_name());
			pstmt.setString(3, user.getUser_passwd());
			pstmt.setString(4, user.getUser_address());
			pstmt.setString(5, user.getUser_phone());
			pstmt.setString(6, user.getUser_email());

			insertCount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateuser에러: " + e.getMessage());
		} finally {
			close(pstmt);
		}

		return insertCount;
	}

	public int deleteUser(String id) {

		int deleteCount = 0;

		try {
			String sql = "DELETE user_info WHERE user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			deleteCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("deleteuser 에러: " + e.getMessage());
		} finally {
			close(pstmt);
		}

		return deleteCount;
	}
}
