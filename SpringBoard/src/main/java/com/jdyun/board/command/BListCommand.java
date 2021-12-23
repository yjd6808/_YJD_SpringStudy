package com.jdyun.board.command;

import java.util.ArrayList;


import org.springframework.ui.Model;

import com.jdyun.board.dao.BDao;
import com.jdyun.board.dto.BDto;

public class BListCommand implements BCommand{

	@Override
	public void execute(Model model) {
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos); // model�� ���� ��Ҵٴ°��� controller���� view�� ���� �ѱ���ִ�?
		
		// controller���� command�� ȣ���غ���. command�� gogo! 
		
	}

}
