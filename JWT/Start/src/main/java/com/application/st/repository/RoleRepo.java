package com.application.st.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.st.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
	
	Role findByName (String name);

}