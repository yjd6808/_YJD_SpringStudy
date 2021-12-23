package com.simple.inven.dto;

public class InvenDto {
	private int u_id;
	private int user_uid;
	private String invenName;
	private int curSize;
	private int maxSize;
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getUser_uid() {
		return user_uid;
	}
	public void setUser_uid(int user_uid) {
		this.user_uid = user_uid;
	}
	public String getInvenName() {
		return invenName;
	}
	public void setInvenName(String invenName) {
		this.invenName = invenName;
	}
	public int getCurSize() {
		return curSize;
	}
	public void setCurSize(int curSize) {
		this.curSize = curSize;
	}
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
}
