package svc;

import java.sql.*;
import java.util.*;
import static db.JdbcUtil.*;
import dao.*;
import vo.*;

public class OrderLookupService {

	public ArrayList<OrderDTO> getOrderList() {
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		ArrayList<OrderDTO> orderList = orderDAO.selectOrderList();
		close(con);
		return orderList;
	}

}
