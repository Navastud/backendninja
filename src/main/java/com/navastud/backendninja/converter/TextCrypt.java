package com.navastud.backendninja.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TextCrypt {

	public static void main(String[] args) {
		BCryptPasswordEncoder pc = new BCryptPasswordEncoder();
		System.out.println(pc.encode("user"));
	}

}
