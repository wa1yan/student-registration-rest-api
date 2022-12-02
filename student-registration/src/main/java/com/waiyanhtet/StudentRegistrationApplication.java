package com.waiyanhtet;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.waiyanhtet.admin.model.Role;
import com.waiyanhtet.admin.model.UserEntity;
import com.waiyanhtet.admin.service.UserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableScheduling
@ComponentScan(basePackages = "com.waiyanhtet")
@SpringBootApplication
public class StudentRegistrationApplication extends SpringBootServletInitializer {

	
//	private UserService userService;
//	
//	@Autowired
//	public StudentRegistrationApplication(UserService userService) {
//		this.userService = userService;
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(StudentRegistrationApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new UserEntity(null, "user", "user", "password", new ArrayList<>()));
			userService.saveUser(new UserEntity(null, "admin", "admin", "adminpassword", new ArrayList<>()));

			userService.addRoleToUser("user", "ROLE_USER");
			userService.addRoleToUser("admin", "ROLE_ADMIN");

		};
	}
	
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StudentRegistrationApplication.class);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		userService.saveRole(new Role(null, "ROLE_USER"));
//		userService.saveRole(new Role(null, "ROLE_MANAGER"));
//		userService.saveRole(new Role(null, "ROLE_ADMIN"));
//		userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//
//		userService.saveUser(new UserEntity(null, "user", "user", "password", new ArrayList<>()));
//		userService.saveUser(new UserEntity(null, "admin", "admin", "adminpassword", new ArrayList<>()));
//
//		userService.addRoleToUser("user", "ROLE_USER");
//		userService.addRoleToUser("admin", "ROLE_ADMIN");
//		
//	}
	
}
