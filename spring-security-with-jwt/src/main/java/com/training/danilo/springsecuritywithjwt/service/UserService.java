package com.training.danilo.springsecuritywithjwt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.danilo.springsecuritywithjwt.domain.Role;
import com.training.danilo.springsecuritywithjwt.domain.User;


public interface UserService {

	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username,String roleName);
	User getUser(String username);
	List<User> getUsers();
}
