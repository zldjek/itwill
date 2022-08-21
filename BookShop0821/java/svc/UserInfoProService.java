package svc;

import java.sql.*;
import static db.JdbcUtil.*;
import dao.*;
import vo.*;

public class UserInfoProService {

	public UserDTO getUser(String viewId) {
		System.out.println("UserInfoProService 실행");
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		UserDTO user = userDAO.selectUser(viewId);
		close(con);
		return user;
	}
}
