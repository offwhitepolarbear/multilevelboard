package com.kihwangkwon.user.service;

import org.springframework.stereotype.Service;

import com.kihwangkwon.user.domain.User;

import common.security.PasswordEncrypt;

@Service
public class UserAddService {
	public User addUser(User user) {
		String salt = PasswordEncrypt.getSalt().toString();
		String encryptedPassword = PasswordEncrypt.makeEncryptedPassword(user.getPassword(), salt);
		return user;
	}
}
