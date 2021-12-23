package com.javalec.spring_test_member_jdbc.dao;

import java.util.ArrayList;

import com.javalec.spring_test_member_jdbc.dto.MemDto;

public interface IMemDao {
	public ArrayList<MemDto> loginYn(final String memUid);
	public void write(final String memUid, final String memPwd, final String memName);
}
