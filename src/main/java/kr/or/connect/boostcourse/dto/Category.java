package kr.or.connect.boostcourse.dto;

public class Category {
	private int id;
	private String name;
	private int count;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", count=" + count + "]";
	}
	
}
