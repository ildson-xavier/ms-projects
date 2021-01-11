package com.project.hruser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

	public BCryptPasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}
}
