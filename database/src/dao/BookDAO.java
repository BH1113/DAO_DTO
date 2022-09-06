package dao;

import java.util.List;

import vo.BookVO;

public interface BookDAO {
	public abstract void add(BookVO book);
	public abstract void update(BookVO book);
	public abstract void delete(BookVO book);
	public abstract BookVO get(BookVO book);
	public abstract List<BookVO> getList();
}
