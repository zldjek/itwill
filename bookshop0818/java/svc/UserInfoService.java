package svc;

import java.sql.*;
import static db.JdbcUtil.*;
import dao.*;
import vo.*;

public class UserInfoService {

	public UserDTO getUser(String viewId) {
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		UserDTO user = userDAO.selectUser(viewId);
		close(con);
		return user;
	}
}
