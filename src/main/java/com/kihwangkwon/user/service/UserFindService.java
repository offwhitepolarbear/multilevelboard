package com.kihwangkwon.user.service;

import com.kihwangkwon.user.domain.User;
import com.kihwangkwon.user.repository.UserRepository;

import common.security.PasswordEncrypt;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserFindService {

	private UserRepository userRepository;
	
	public void login(User user) {
		String salt = PasswordEncrypt.getSalt().toString();
		String encryptedPassword = PasswordEncrypt.makeEncryptedPassword(user.getPassword(), salt);
		User checkUser = userRepository.findByUserIdAndPassword(user.getUserId(), user.getPassword());
		if(checkUser!=null){
			
		}
		else {

		}
	}
	

}
