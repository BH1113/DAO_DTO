package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import vo.BookVO;
import vo.OrdersVO;

public class OrdersDAOImpl implements OrdersDAO {
	private String className;
	private String url;
	private String id;
	private String pass;
	
	public OrdersDAOImpl() {
		this.className = "oracle.jdbc.driver.OracleDriver";
		this.url = "jdbc:oracle:thin:@192.168.86.146:1521:xe";
		this.id = "c##madang";
		this.pass = "madang";
	}
	@Override
	public void add(OrdersVO order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(OrdersVO customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(OrdersVO order) {
		// TODO Auto-generated method stub

	}

	@Override
	public OrdersVO get(OrdersVO order) {
		OrdersVO result = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(this.className);
			conn = DriverManager.getConnection(this.url, this.id, this.pass);
			
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM book WHERE bookid=" + book.getBookid();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int bookid = rs.getInt("bookid");
				String bookname = rs.getString("bookname");
				String publisher = rs.getString("publisher");
				int price = rs.getInt("price");
				result = new OrdersVO(bookid, bookname, publisher, price);
			}
		} catch(ClassNotFoundException e) {
			System.out.println("오라클 드라이버를 찾을수 없습니다.");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch(SQLException e) {}
			if (stmt != null) try {stmt.close();} catch(SQLException e) {}
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
		}
		return result;
	}

	@Override
	public List<OrdersVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
