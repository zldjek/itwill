package svc;

import java.sql.*;

import dao.*;

import static db.JdbcUtil.*;
import vo.*;

public class MypageService {
	public boolean login(MemberDTO member) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		boolean loginResult = false;
		String loginId = memberDAO.selectLoginId(member);
		if(loginId != null){
			loginResult = true;
		}
		close(con);
		return loginResult;
	}
}
