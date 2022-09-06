package dao;

import java.util.List;

import vo.CustomerVO;

public interface CustomerDAO {
	public abstract void add(CustomerVO customer);
	public abstract void update(CustomerVO customer);
	public abstract void delete(CustomerVO customer);
	public abstract CustomerVO get(CustomerVO customer);
	public abstract List<CustomerVO> getList();
}
