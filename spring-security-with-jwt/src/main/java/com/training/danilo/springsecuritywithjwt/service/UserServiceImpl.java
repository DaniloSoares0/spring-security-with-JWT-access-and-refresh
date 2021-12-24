package com.training.danilo.springsecuritywithjwt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.training.danilo.springsecuritywithjwt.domain.Role;
import com.training.danilo.springsecuritywithjwt.domain.User;
import com.training.danilo.springsecuritywithjwt.repository.RoleRepository;
import com.training.danilo.springsecuritywithjwt.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	
	@Override
	public User saveUser(User user) {
		log.info("Saving user");
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("Saving  new role {}", role.getName());
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		User user = userRepository.findByUsername(username);
		Role role = roleRepository.findByName(roleName);
		user.getRoles().add(role);
		//we dosen't need to call the save method because we are using transcional anotation
	}

	@Override
	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

}
