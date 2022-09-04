package com.waiyanhtet.admin.service;

import java.util.List;

import com.waiyanhtet.admin.model.Role;
import com.waiyanhtet.admin.model.UserEntity;

public interface UserService {

	UserEntity saveUser(UserEntity user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	UserEntity getUser(String username);
	List<UserEntity> getUsers();
}
