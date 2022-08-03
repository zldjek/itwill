package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.*;

import dao.*;

public class OrderCancelService {

	public boolean CancelOrder(String cancelNum) {
		boolean cancelResult = false;
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		int cancelCount = orderDAO.cancelOrder(cancelNum);
		if(cancelCount > 0){
			commit(con);
			cancelResult = true;
		}
		else{
			rollback(con);
		}
		close(con);
		return cancelResult;
	}

}
