package dao;

import java.util.List;
import java.sql.*;

import vo.CustomerVO;

public class CustomerDAOImpl implements CustomerDAO {
	private String className;
	private String url;
	private String id;
	private String pass;
	
	public CustomerDAOImpl() {
		this.className = "oracle.jdbc.driver.OracleDriver";
		this.url = "jdbc:oracle:thin:@192.168.86.146:1521:xe";
		this.id = "c##madang";
		this.pass = "madang";
	}
	@Override
	public void add(CustomerVO customer) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(this.className);
			conn = DriverManager.getConnection(this.url, this.id, this.pass);
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO customer ";
			sql += "(bookid, bookname, publisher, price) ";
			sql += "VALUES ";
			sql += "(CUST_SEQ.NEXTVAL, '"+customer.getCustid()+"', '"+customer.getName()+"', "+customer.getAddress()+"', '" +customer.getPhone()+")";
			int resultCnt = stmt.executeUpdate(sql);
			System.out.println("customer 테이블에 " + resultCnt + "개 튜플이 삽입 되었습니다.");
		} catch(ClassNotFoundException e) {
			System.out.println("오라클 드라이버를 찾을 수없습니다.");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(stmt != null) try {stmt.close();}catch(SQLException e) {}
			if(conn != null) try {conn.close();}catch(SQLException e) {}
		}

	}

	@Override
	public void update(CustomerVO customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CustomerVO customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public CustomerVO get(CustomerVO customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
