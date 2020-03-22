package com.kihwangkwon.user.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddUserController {

	public boolean isUserIdExist(@RequestBody String userId) {
		boolean result = false;
		return result;
	}

	public boolean isPhoneNumberExist(@RequestBody String phoneNumber) {
		boolean result = false;
		return result;
	}
	
	public boolean isEmailExist(@RequestBody String email) {
		boolean result = false;
		return result;
	}
	
}
