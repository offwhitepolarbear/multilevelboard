package com.kihwangkwon.user.domain;

import lombok.Getter;

import lombok.Setter;

@Setter
@Getter
public class UserDTORequest {
	String userId;
	String password;
	String nickName;
	String name;
	String PhoneNumber;
	String email;
	String address;
	String addressDetail;
	
	@Override
	public String toString() {
		return "RequestUserDTO [userId=" + userId + ", password=" + password + ", nickName=" + nickName + ", name="
				+ name + ", PhoneNumber=" + PhoneNumber + ", email=" + email + ", address=" + address
				+ ", addressDetail=" + addressDetail + "]";
	}
}
