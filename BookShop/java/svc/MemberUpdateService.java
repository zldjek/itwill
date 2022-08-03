package svc;

import java.sql.*;
import static db.JdbcUtil.*;
import dao.*;
import vo.*;

public class MemberUpdateService {
	public boolean updateMember(MemberDTO member) {
		boolean updateSuccess = false;
		MemberDAO memberDAO = MemberDAO.getInstance();
		Connection con = getConnection();
		memberDAO.setConnection(con);
		int update = memberDAO.updateMember(member);
		if(update > 0){
			updateSuccess = true;
			commit(con);
		}
		else{
			rollback(con);
		}
		close(con);
		return updateSuccess;
	}

}

