package com.kihwangkwon.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String main() {
		System.out.println("a메인임");
		return "main";
	}
	@GetMapping("/test")
	public String test() {
		System.out.println("테스트임");
		return"test/test";
	}
}
