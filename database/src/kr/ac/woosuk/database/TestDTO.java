package kr.ac.woosuk.database;

public class TestDTO {
	private int id;
	private String name;
	
	public TestDTO(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
}
