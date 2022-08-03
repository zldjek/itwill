package dao;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import static db.JdbcUtil.*;
import vo.*;

public class MemberDAO {
	public static MemberDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
		if(instance == null){
			instance = new MemberDAO();
		}
		return instance;
	}
	public String selectLoginId(MemberDTO member){
		
		String loginId = null;
		
		
		try{
			String sql="SELECT member_id FROM member_info WHERE member_id=? AND member_passwd=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_passwd());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				loginId = rs.getString("member_id");
			}
		}catch(Exception e){
			System.out.println(" 에러: " + e.getMessage());			
		}finally{
			close(rs);
			close(pstmt);
		}
		
		return loginId;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	public MemberDTO selectMemberInfo(String id) {
		
		MemberDTO member = null;
		
		try  {
			String sql = "SELECT * FROM member_info WHERE member_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
				if(rs.next()) {
					member = new MemberDTO();
					member.setMember_id(rs.getString("member_id"));
					member.setMember_name(rs.getString("member_name"));
					member.setMember_passwd(rs.getString("member_passwd"));
					member.setMember_address(rs.getString("member_address"));
					member.setMember_phone(rs.getString("member_phone"));
					member.setMember_email(rs.getString("member_email"));
					
					System.out.println("회원정보저장완료!");
				}
				System.out.println("SQL구문실행완료!");
			} catch(Exception e) {
				System.out.println("selectMyInfo 에러: " + e.getMessage());			
			} finally {
				close(rs);
				close(pstmt);
		}
		
		return member;
	}
	public int updateMember(MemberDTO member) {
		
		int insertCount = 0;
		
		try {
			String sql="INSERT INTO MEMBER1 VALUES (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_name());
			pstmt.setString(3, member.getMember_passwd());
			pstmt.setString(4, member.getMember_address());
			pstmt.setString(5, member.getMember_phone());
			pstmt.setString(6, member.getMember_email());
			
			insertCount = pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("updateMember에러: " + e.getMessage());			
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	public int deleteMyInfo(String id) {
		
		int deleteCount = 0;

		try {
			String sql = "DELETE user_info WHERE member_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			deleteCount = pstmt.executeUpdate();
		
		} catch(Exception e) {
			System.out.println("deleteMember 에러: " + e.getMessage());	
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
}
