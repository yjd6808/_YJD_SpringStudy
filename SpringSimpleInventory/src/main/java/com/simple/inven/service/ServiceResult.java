package com.simple.inven.service;

import javax.naming.spi.DirStateFactory.Result;

public class ServiceResult {
	private boolean isSuccess;
	private int status;
	private String message;
	
	public ServiceResult() {
		this.isSuccess = false;
		this.message = "";
	}
	
	public ServiceResult(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public ServiceResult(boolean isSuccess, String message) {
		this.isSuccess = isSuccess;
		this.message = message;
	}
	
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public Object getData() {
		if (!(this instanceof ServiceResult)) {
			return ((ServiceResultWithData)this).getData();
		}
		return null;
	}

}
