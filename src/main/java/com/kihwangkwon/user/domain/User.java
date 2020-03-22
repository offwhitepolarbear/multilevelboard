package com.kihwangkwon.user.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20)
	private String userId;
	
	@Column(length = 50)
	private String password;
	
	@Column(length = 50)
	private String email;
	
	@Column(length = 20)
	private String name;
	
	@Column(length = 50)
	private String nickname;
	
	@Column(length = 11)
	private String phoneNumber;
	
	@Column
	private LocalDateTime createdDate;
	
	@Column(length = 3)
	private String role;
	
	@Builder
	public User(String userId, String password, String email, String name, String nickname, String phoneNumber, LocalDateTime createdDate, String role) {
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.name = name;
		this.nickname = nickname;
		this.phoneNumber = phoneNumber;
		this.createdDate = createdDate;
		this.role=role;
	}
}
