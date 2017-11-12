package com.test.dto;

public class SimpleDto extends Dto {

	private int id;
	private String stringField;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStringField() {
		return stringField;
	}
	public void setStringField(String stringField) {
		this.stringField = stringField;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SimpleDto [id=").append(id).append(", stringField=").append(stringField).append("]");
		return builder.toString();
	}
	
	
}
