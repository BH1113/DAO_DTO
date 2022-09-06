package kr.ac.woosuk.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class First {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@192.168.86.146:1521:xe";
		String id = "c##madang";
		String pass = "madang";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pass);
			
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			String sql1 = "INSERT INTO book "
					    + "(bookid, bookname, publisher, price) "
					    + "VALUES "
					    + "(BOOK_SEQ.NEXTVAL, '웹 프로그래밍 1권', 'YK출판사', 32000) ";
			stmt.executeUpdate(sql1);
			String sql2 = "INSERT INTO book "
				    + "(bookid, bookname, publisher, price) "
				    + "VALUES "
				    + "(BOOK_SEQ.NEXTVAL, '웹 프로그래밍 2권', 'YK출판사', 32000) ";
			stmt.executeUpdate(sql2);
			conn.commit();
		} catch (ClassNotFoundException e) {
			System.out.println("오라클드라이브를 찾을수없습니다.");
		} catch (SQLException e) {
			try { conn.rollback(); } catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch (SQLException e) {}
			if(stmt != null) try {stmt.close();} catch (SQLException e) {}
			if(conn != null) try {conn.close();} catch (SQLException e) {}
		}
	}
}
