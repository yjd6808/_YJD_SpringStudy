package com.simple.inven.service;

public class ServiceResultWithData<T> extends ServiceResult {
	private T data;
	
	public ServiceResultWithData(boolean isSuccess, T data) {
		super(isSuccess);
		this.data = data;
	}

	public ServiceResultWithData(boolean isSuccess, String message, T data) {
		super(isSuccess, message);
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
