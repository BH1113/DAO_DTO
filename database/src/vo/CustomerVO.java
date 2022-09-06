package vo;

public class CustomerVO {
	private int custid;
	private String name;
	private String address;
	private String phone;
	
	public CustomerVO(int custid, String name, String address, String phone) {
		this.custid = custid;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public int getCustid() {
		return custid;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
}
