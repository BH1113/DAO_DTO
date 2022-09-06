package kr.ac.woosuk.database;

import java.util.List;

import dao.BookDAO;
import dao.BookDAOImpl;
import vo.BookVO;

public class Main {
	public static void main(String[] args) {
		BookDAO bookDao = new BookDAOImpl();
		
		BookVO book = new BookVO(1, null, null, 0);
		
		bookDao.delete(book);
	}
}
