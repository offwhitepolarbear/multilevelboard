package com.kihwangkwon.user.domain;

import java.util.Date;

import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
public class UserDTORequest {

	String userId;
	String password;
	String nickName;
	String name;
	String PhoneNumber;
	String email;
	Date birthDate;
	
	@Override
	public String toString() {
		return "RequestUserDTO [userId=" + userId + ", password=" + password + ", nickName=" + nickName + ", name="
				+ name + ", PhoneNumber=" + PhoneNumber + ", email=" + email + "]";
	}
}
