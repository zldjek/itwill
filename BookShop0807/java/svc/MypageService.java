package svc;

import java.sql.*;

import dao.*;

import static db.JdbcUtil.*;
import vo.*;

public class MypageService {
	public boolean login(UserDTO user) {
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		boolean loginResult = false;
		String loginId = userDAO.selectLoginId(user);
		if (loginId != null) {
			loginResult = true;
		}
		close(con);
		return loginResult;
	}
}
