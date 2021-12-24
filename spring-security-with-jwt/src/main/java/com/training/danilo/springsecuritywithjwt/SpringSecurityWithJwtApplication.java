package com.training.danilo.springsecuritywithjwt;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.training.danilo.springsecuritywithjwt.domain.Role;
import com.training.danilo.springsecuritywithjwt.domain.User;
import com.training.danilo.springsecuritywithjwt.service.UserService;

@SpringBootApplication
public class SpringSecurityWithJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithJwtApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	CommandLineRunner run(UserService userService) {
		return args ->{
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
			
			userService.saveUser(new User(null,"John Travoltta","john","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Will Smith","Will","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Caroline Denver","Caroline","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"John Whitehead","Whitehead","1234",new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("Will", "ROLE_ADMIN");
			userService.addRoleToUser("Whitehead", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("Caroline", "ROLE_USER");
			userService.addRoleToUser("Caroline", "ROLE_ADMIN");
			userService.addRoleToUser("Caroline", "ROLE_MANAGER");

		};
	}
}
