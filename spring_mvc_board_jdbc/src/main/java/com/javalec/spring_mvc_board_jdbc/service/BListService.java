package com.javalec.spring_mvc_board_jdbc.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

//import com.javalec.spring_mvc_board.dao.BDao;
//import com.javalec.spring_mvc_board.dto.BDto;
import com.javalec.spring_mvc_board_jdbc.dao.*;
import com.javalec.spring_mvc_board_jdbc.dto.*;

public class BListService implements BService{
	@Override
	public void execute(Model model) {
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);
	}
}
