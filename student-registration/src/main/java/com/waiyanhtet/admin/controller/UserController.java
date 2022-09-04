package com.waiyanhtet.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waiyanhtet.admin.model.UserEntity;
import com.waiyanhtet.admin.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping
	List<UserEntity> getUsers() {
		return userService.getUsers();
	}
}
