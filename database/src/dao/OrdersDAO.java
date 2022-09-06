package dao;

import java.util.List;

import vo.OrdersVO;

public interface OrdersDAO {
	public abstract void add(OrdersVO order);
	public abstract void update(OrdersVO customer);
	public abstract void delete(OrdersVO order);
	public abstract OrdersVO get(OrdersVO order);
	public abstract List<OrdersVO> getList();
}
