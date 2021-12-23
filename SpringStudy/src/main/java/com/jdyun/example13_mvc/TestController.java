package com.jdyun.example13_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/test/view")
	public String testview() {
		return "test/view";
	}
}
