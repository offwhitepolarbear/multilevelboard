package com.kihwangkwon.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kihwangkwon.user.domain.User;
import com.kihwangkwon.user.repository.AddUserRepository;

import common.security.PasswordEncrypt;

@Service
public class UserAddService {
	@Autowired
	private AddUserRepository addUserRepository;
	
	
	public User addUser(User user) {
		String salt = PasswordEncrypt.getSalt().toString();
		String encryptedPassword = PasswordEncrypt.makeEncryptedPassword(user.getPassword(), salt);
		return user;
	}
	
	public void addUserTest() {
		/*
		User user = User.builder()
				.userId("jpa")
				.password("암호")
				.email("aa")
				.name("name")
				.role("u").build();
		addUserRepository.save(user);
		*/
		
		User readUser = addUserRepository.findUserByUserId("jpa");
		System.out.println(readUser);
	}
}
