package com.navastud.backendninja.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// TODO: Auto-generated Javadoc
/**
 * The Class TextCrypt.
 */
public class TextCrypt {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		BCryptPasswordEncoder pc = new BCryptPasswordEncoder();
		System.out.println(pc.encode("user"));
	}

}
