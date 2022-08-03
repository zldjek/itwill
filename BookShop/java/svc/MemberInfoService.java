package svc;

import java.sql.*;
import static db.JdbcUtil.*;
import dao.*;
import vo.*;

public class MemberInfoService {
	
	public MemberDTO getMemberInfo(String id) {
		
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		MemberDTO member = memberDAO.selectMemberInfo("id");
		close(con);
		return member;
	}
}
