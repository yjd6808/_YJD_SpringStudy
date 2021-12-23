package com.jdyun.example13_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/legend")
public class GoogleController {

	@RequestMapping("/content")
	public String google() {
		return "legend/content";
	}
}
