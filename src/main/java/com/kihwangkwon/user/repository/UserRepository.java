package com.kihwangkwon.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kihwangkwon.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserIdAndPassword (String userId, String password);
}
