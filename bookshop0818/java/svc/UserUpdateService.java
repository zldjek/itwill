package svc;

import java.sql.*;
import static db.JdbcUtil.*;
import dao.*;
import vo.*;

public class UserUpdateService {
	public boolean updateUser(UserDTO user) {
		boolean updateSuccess = false;
		UserDAO userDAO = UserDAO.getInstance();
		Connection con = getConnection();
		userDAO.setConnection(con);
		int update = userDAO.updateUser(user);
		if (update > 0) {
			updateSuccess = true;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return updateSuccess;
	}

}
