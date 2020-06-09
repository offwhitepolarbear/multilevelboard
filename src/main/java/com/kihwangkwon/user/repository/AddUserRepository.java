package com.kihwangkwon.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kihwangkwon.user.domain.User;

public interface AddUserRepository extends JpaRepository<User, Long> {
	User findUserByUserId(String userId);
	User findUserByPhoneNumber(String phoneNumber);
	User findUserByEmail(String Email);
	User findUserByNickName(String NickName);
	
}
