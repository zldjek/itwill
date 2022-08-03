package svc;

import java.sql.*;
import static db.JdbcUtil.*;
import dao.*;

public class MemberDeleteService {
	public boolean deleteMyInfo(String deleteId) {
		boolean deleteResult = false;
		Connection con = getConnection();
		MemberDAO userDAO = MemberDAO.getInstance();
		userDAO.setConnection(con);
		int deleteCount = userDAO.deleteMyInfo(deleteId);
		if(deleteCount > 0){
			commit(con);
			deleteResult = true;
		}
		else{
			rollback(con);
		}
		close(con);
		return deleteResult;
	}

}


