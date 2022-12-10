package com.kyn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kyn.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	
	Optional<Users> findByEmail(String email);
	
	// Check or find existing mail - return true or false
	// For Register (duplicate email)
	Boolean existsByEmail(String email);

}
