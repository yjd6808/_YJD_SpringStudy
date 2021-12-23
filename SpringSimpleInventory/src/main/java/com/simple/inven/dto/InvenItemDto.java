package com.simple.inven.dto;

public class InvenItemDto {
	private int u_id;
	private ItemDto itemInfo;
	private int quantity;
	
	
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public ItemDto getItemInfo() {
		return itemInfo;
	}
	public void setItemInfo(ItemDto itemInfo) {
		this.itemInfo = itemInfo;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
