package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.*;
import vo.*;

public class UserLoginService {

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
