package com.javalec.spring_test_item_mybatis.dto;

public class ItemDto {  // 여기선 굳이 dto 필요없다. 
	String name;
	int price;
	String description;
	
	public ItemDto() {}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
