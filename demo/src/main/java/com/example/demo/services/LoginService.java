package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean validateUser(String userid, String password) {
		return userid.equalsIgnoreCase("demo-basic") && password.equalsIgnoreCase("123123");
	}
}