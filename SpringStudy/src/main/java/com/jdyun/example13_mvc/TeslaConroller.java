package com.jdyun.example13_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeslaConroller {

	@RequestMapping("/car/zizon")
	ModelAndView cartesla() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("hello", 12334);
		mv.setViewName("car/tesla");
		return mv;
	}
}
