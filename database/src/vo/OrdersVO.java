package vo;

import java.sql.Date;

public class OrdersVO {
	private int orderid;
	private CustomerVO customer;
	private BookVO book;
	private int saleprice;
	private Date orderdate;
	
	public OrdersVO(int orderid, CustomerVO customer, BookVO book, int saleprice, Date orderdate) {
		this.orderid = orderid;
		this.customer = customer;
		this.book = book;
		this.saleprice = saleprice;
		this.orderdate = orderdate;
	}
	
	public CustomerVO getCustomerVO() {
		return customer;
	}
	public BookVO getBookVO() {
		return book;
	}
	
	public int getOrderid() {
		return orderid;
	}
	public int getSaleprice() {
		return saleprice;
	}
	public Date getOrderdate() {
		return orderdate;
	}
}
