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
		model.addAttribute("list", dtos); // model에 값을 담았다는것은 controller에서 view로 값을 넘길수있다?
		
		// controller에서 command단 호출해보자. command단 gogo! 
		
	}

}
