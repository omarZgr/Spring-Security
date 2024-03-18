package com.application.st.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.st.entity.AppUser;
import com.application.st.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepo userRepo;
	
	@Autowired
	private final PasswordEncoder passwordEncoder;

	
	
public List<AppUser> findAll (){
		
		return userRepo.findAll();
	}
	
    public AppUser findById (Long id){
		
		return userRepo.findById(id).orElse(null);
	}
    
    public AppUser save(AppUser entity) {
    	entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		return userRepo.save(entity);
	}

}
