package com.kihwangkwon.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kihwangkwon.user.service.UserAddService;

@Controller
public class UserTestController {
	
	@Autowired
	UserAddService userAddService;
	
	@GetMapping("addusert")
	public String testAdd() {
		
		userAddService.addUserTest();
		return null;
	}
}
