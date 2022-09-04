package com.waiyanhtet.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waiyanhtet.admin.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{
	
	Role findByName(String name);
}
