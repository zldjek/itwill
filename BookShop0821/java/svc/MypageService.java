package svc;

import java.sql.*;

import dao.*;

import static db.JdbcUtil.*;
import vo.*;

public class MypageService {
	public boolean id(UserDTO dto) {
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		boolean idCheck = false;
		idCheck = userDAO.checkUserid(dto);
		close(con);
		
		return idCheck;
	}
}
