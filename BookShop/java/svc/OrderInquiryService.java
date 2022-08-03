package svc;

import java.sql.*;
import static db.JdbcUtil.*;
import dao.*;
import vo.*;

public class OrderInquiryService {

	public boolean inquiryOrder(OrderDTO order) {
		
		boolean inquirySuccess = false;
		OrderDAO orderDAO = OrderDAO.getInstance();
		Connection con = getConnection();
		orderDAO.setConnection(con);
		int insertCount = orderDAO.insertOrder(order);
		if(insertCount > 0){
			inquirySuccess = true;
			commit(con);
		}
		else{
			rollback(con);
		}
		close(con);
		return inquirySuccess;
	}

}
