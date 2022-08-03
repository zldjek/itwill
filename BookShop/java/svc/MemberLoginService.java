package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.*;
import vo.*;
public class MemberLoginService {

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








