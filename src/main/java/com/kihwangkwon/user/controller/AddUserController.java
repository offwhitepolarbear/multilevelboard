package com.kihwangkwon.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kihwangkwon.user.domain.UserDTORequest;
import com.kihwangkwon.user.repository.AddUserRepository;

@RestController
public class AddUserController {
	
	@Autowired
	AddUserRepository addUserRepository;
	
	public boolean isUserIdExist(@RequestBody String userId) {
		boolean result = false;
		if(addUserRepository.findUserByUserId(userId) != null) {
			result = true;
		}
		return result;
	}

	public boolean isPhoneNumberExist(@RequestBody String phoneNumber) {
		boolean result = false;
		if(addUserRepository.findUserByPhoneNumber(phoneNumber) != null) {
			result = true;
		}
		return result;
	}
	
	public boolean isEmailExist(@RequestBody String email) {
		boolean result = false;
		if(addUserRepository.findUserByEmail(email) != null) {
			result = true;
		}
		return result;
	}

	public boolean isNickNameExist(@RequestBody String nickName) {
		boolean result = false;
		if(addUserRepository.findUserByNickName(nickName) != null) {
			result = true;
		}
		return result;
	}
	
	@PostMapping("adduser")
	public boolean addUser(@RequestBody UserDTORequest userRequest) {
		boolean result = false;
		
		return result;
	}
	
}
