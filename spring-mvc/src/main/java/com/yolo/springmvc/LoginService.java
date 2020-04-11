package com.yolo.springmvc;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean isUserValid(String name, String password) {
		if(name.equalsIgnoreCase("yolo") && password.equalsIgnoreCase("password"))
			return true;
		else
			return false;
	}

}
