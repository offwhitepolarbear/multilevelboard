package com.kihwangkwon.user.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kihwangkwon.user.domain.UserDTORequest;

@RestController
public class UserAuthController {
	
	public boolean login(@RequestBody UserDTORequest user) {
		boolean result = false;
		return result;
	}
}
