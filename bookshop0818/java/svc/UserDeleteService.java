package svc;

import java.sql.*;
import static db.JdbcUtil.*;
import dao.*;
import vo.*;

public class UserDeleteService {
	public boolean deleteUser(UserDTO deleteId) {
		boolean deleteResult = false;
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		int deleteCount = userDAO.deleteUser(deleteId);
		if (deleteCount > 0) {
			commit(con);
			deleteResult = true;
		} else {
			rollback(con);
		}
		close(con);
		return deleteResult;
	}

}
