package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.*;
import vo.*;

public class UserLoginProService {

	public boolean loginUser(UserDTO user) {
		System.out.println("loginUserProService 호출!");
		boolean isLoginSuccess = false;
		Connection con = getConnection();
		UserDAO dao = UserDAO.getInstance();
		dao.setConnection(con);
		isLoginSuccess = dao.selectLoginId(user);
		close(con);
		return isLoginSuccess;
	}

}
