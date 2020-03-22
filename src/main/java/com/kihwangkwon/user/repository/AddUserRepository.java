package com.kihwangkwon.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kihwangkwon.user.domain.UserDTORequest;

public interface AddUserRepository extends JpaRepository<UserDTORequest, Long> {
	UserDTORequest findUserByUserId(String userId);
	UserDTORequest findUserByPhoneNumber(String phoneNumber);
	UserDTORequest findUserByEmail(String Email);
	UserDTORequest findUserByNickName(String NickName);
}
