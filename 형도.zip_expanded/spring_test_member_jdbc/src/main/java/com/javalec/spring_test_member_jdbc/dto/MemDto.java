package com.javalec.spring_test_member_jdbc.dto;

public class MemDto {
	String memUid;
	String memPwd;
	String memName;
	
	public MemDto() {}
	
	public MemDto(String memUid, String memPwd, String memName) {
		super();
		this.memUid = memUid;
		this.memPwd = memPwd;
		this.memName = memName;
	}
	
	public String getMemUid() {
		return memUid;
	}
	public void setMemUid(String memUid) {
		this.memUid = memUid;
	}
	public String getMemPwd() {
		return memPwd;
	}
	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	
	
	
}
