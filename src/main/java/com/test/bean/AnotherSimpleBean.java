package com.test.bean;

public class AnotherSimpleBean extends Bean {

	
	private int id;
	private String name;
	private Double price;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AnotherSimpleDto [id=").append(id).append(", name=").append(name).append(", price=")
				.append(price).append("]");
		return builder.toString();
	}
}
