package com.example.demo.confg;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StartUpApp implements CommandLineRunner {
	
	private final UserService userService;
	
	private final RoleService roleService;

	@Override
	public void run(String... args) throws Exception {


		if (roleService.findAll().isEmpty()) {			
			roleService.save(new Role(null, "admin"));
			roleService.save(new Role(null, "user"));
			roleService.save(new Role(null, "employee"));
		}
		
		
		if (userService.findAll().isEmpty()) {
			
			Set<Role> adminRoles = new HashSet<>();
			adminRoles.add(roleService.findByName("admin"));
			
			Set<Role> userRoles = new HashSet<>();
			userRoles.add(roleService.findByName("user"));
			
			Set<Role>  empRoles = new HashSet<>();
			empRoles.add(roleService.findByName("employee"));
			
			userService.save(new AppUser(null, "Nour Shaheen", "nour", "123", adminRoles, true, true, true, true));
			
			userService.save(new AppUser(null, "Ali Mohamed", "ali", "123", userRoles, true, true, true, true));
			
			userService.save(new AppUser(null, "Ahmed Ebraheem", "ahmed", "123", empRoles, true, true, true, true));
		}
		
	}

}