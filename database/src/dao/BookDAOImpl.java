package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.BookVO;

public class BookDAOImpl implements BookDAO {
	private String className;
	private String url;
	private String id;
	private String pass;
	
	public BookDAOImpl() {
		this.className = "oracle.jdbc.driver.OracleDriver";
		this.url = "jdbc:oracle:thin:@192.168.86.146:1521:xe";
		this.id = "c##madang";
		this.pass = "madang";
	}

	@Override
	public void add(BookVO book) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(this.className);
			conn = DriverManager.getConnection(this.url, this.id, this.pass);
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO book ";
			sql += "(bookid, bookname, publisher, price) ";
			sql += "VALUES ";
			sql += "(BOOK_SEQ.NEXTVAL, '"+book.getBookname()+"', '"+book.getPublisher()+"', "+book.getPrice()+")";
			int resultCnt = stmt.executeUpdate(sql);
			System.out.println("Book 테이블에 " + resultCnt + "개 튜플이 삽입 되었습니다.");
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
	public void update(BookVO book) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(this.className);
			conn = DriverManager.getConnection(this.url, this.id, this.pass);
			stmt = conn.createStatement();
			
			String sql = "UPDATE book SET ";
			sql += "bookname='"+book.getBookname()+"', ";
			sql += "publisher='"+book.getPublisher()+"', ";
			sql += "price='"+book.getPrice()+"' ";
			sql += "WHERE bookid="+book.getBookid();
			int resultCnt = stmt.executeUpdate(sql);
			System.out.println("Book 테이블에 " + resultCnt + "개 튜플이 수정 되었습니다.");
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
	public void delete(BookVO book) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(this.className);
			conn = DriverManager.getConnection(this.url, this.id, this.pass);
			stmt = conn.createStatement();
			
			String sql = "DELETE FROM book ";
			sql += "WHERE bookid="+book.getBookid();
			int resultCnt = stmt.executeUpdate(sql);
			System.out.println("Book 테이블에 " + resultCnt + "개 튜플이 삭제 되었습니다.");
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
	public BookVO get(BookVO book) {
		BookVO result = null;
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
				result = new BookVO(bookid, bookname, publisher, price);
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
	public List<BookVO> getList() {
		List<BookVO> results = new ArrayList<BookVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(this.className);
			conn = DriverManager.getConnection(this.url, this.id, this.pass);
			
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM book";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int bookid = rs.getInt("bookid");
				String bookname = rs.getString("bookname");
				String publisher = rs.getString("publisher");
				int price = rs.getInt("price");
				BookVO book = new BookVO(bookid, bookname, publisher, price);
				results.add(book);
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
		return results;
	}

	
}
