package com.kihwangkwon.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kihwangkwon.user.domain.UserDTORequest;

import io.jsonwebtoken.Jwts;


@RestController
public class UserAuthController {
	
	public boolean login(@RequestBody UserDTORequest user) {
		boolean result = false;
		Map map = new HashMap();
		Jwts.builder().addClaims(map);
		return result;
	}
}
