package svc;

import java.sql.*;

import dao.*;

import static db.JdbcUtil.*;
import vo.*;

public class UserUpdateViewService {
	public UserDTO getUser(String viewId) {
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		UserDTO user = userDAO.selectUser(viewId);
		close(con);
		return user;
	}
}
