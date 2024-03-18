package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<AppUser, Long> {
	
	Optional<AppUser> findByUserName (String userName) ;

}