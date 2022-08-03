package dao;

import static db.JdbcUtil.close;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import vo.*;

public class OrderDAO {
	public static OrderDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private OrderDAO() {}
	
	public static OrderDAO getInstance() {
		if(instance == null){
			instance = new OrderDAO();
		}
		return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	public OrderDTO selectOrderLookup(int order_id) {
		
		OrderDTO order = null;
		
		try  {
			String sql = "SELECT * FROM order_info WHERE order_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_id);
			
			rs = pstmt.executeQuery();
				if(rs.next()) {
					order=new OrderDTO();
					order.setOrder_id(rs.getInt("order_id"));
					order.setOrder_kind(rs.getString("order_kind"));
					order.setOrder_price(rs.getInt("order_price"));
					order.setOrder_image(rs.getString("order_image"));
					order.setOrder_content(rs.getString("order_content"));
					order.setOrder_count(rs.getInt("order_count"));
					
					System.out.println("상품조회성공!");
				}
				System.out.println("SQL구문실행완료!");
			} catch(Exception e) {
				System.out.println("selectOrderInfo 에러: " + e.getMessage());			
			} finally {
				close(rs);
				close(pstmt);
		}
		
		return order;
	}
	public int updateOrderInfo(OrderDTO order) {
		
		int insertCount = 0;
		
		try {
			String sql="INSERT INTO order_info VALUES (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order.getOrder_id());
			pstmt.setString(2, order.getOrder_kind());
			pstmt.setInt(3, order.getOrder_price());
			pstmt.setString(4, order.getOrder_image());
			pstmt.setString(5, order.getOrder_content());
			pstmt.setInt(6, order.getOrder_count());
			
			insertCount = pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("updateOrderInfo: " + e.getMessage());			
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	public int cancelOrder(String num) {
		int cancelCount = 0;

		try {
			String sql = "DELETE Order_info WHERE order_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			
			cancelCount = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("deleteorder 에러: " + e.getMessage());	
		} finally {
			close(pstmt);
		}
		
		return cancelCount;
	}

	public ArrayList<OrderDTO> selectOrderList() {
		ArrayList<OrderDTO> orderList=new ArrayList<OrderDTO>();
		OrderDTO order = null;

		try{
			String sql="SELECT * FROM order_info";
			pstmt=con.prepareStatement(sql);
			
			if(rs.next()){
				order=new OrderDTO();
				order.setOrder_id(rs.getInt("order_id"));
				order.setOrder_kind(rs.getString("order_kind"));
				order.setOrder_price(rs.getInt("order_price"));
				order.setOrder_image(rs.getString("order_image"));
				order.setOrder_content(rs.getString("order_content"));
				order.setOrder_count(rs.getInt("order_count"));
				orderList.add(order);
			}
			rs=pstmt.executeQuery();
		}catch(Exception e){
			System.out.println("orderList 에러: " + e.getMessage());			
		}finally{
			close(rs);
			close(pstmt);
		}
		return orderList;
	}

	public int insertOrder(OrderDTO order) {
		String sql="INSERT INTO order_info VALUES (?,?,?,?,?,?)";
		int insertCount=0;
		
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order.getOrder_id());
			pstmt.setString(2, order.getOrder_kind());
			pstmt.setInt(3, order.getOrder_price());
			pstmt.setString(4, order.getOrder_image());
			pstmt.setString(5, order.getOrder_content());
			pstmt.setInt(6, order.getOrder_count());
			insertCount=pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("insertOrder 에러: " + e.getMessage());			
		}finally{
			close(pstmt);
		}
		
		return insertCount;
	}
}