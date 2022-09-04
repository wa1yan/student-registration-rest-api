package com.waiyanhtet.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waiyanhtet.admin.model.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);
}
