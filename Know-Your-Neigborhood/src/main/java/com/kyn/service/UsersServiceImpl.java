package com.kyn.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kyn.entity.Users;
import com.kyn.exception.ResourceNotFoundException;
import com.kyn.repository.UsersRepository;


@Service
@Transactional
public class UsersServiceImpl implements UserDetailsService{

	@Autowired
	private UsersRepository usersRepo;
	


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users users = usersRepo.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("This email cannot be found "+ email));
				
		return UsersPrincipal.createUser(users);
	}
	
	//used for JWT authentication filter
	public UserDetails loadUserById(long userId) {
		
		Users users = usersRepo.findById(userId)
				.orElseThrow( () -> new ResourceNotFoundException("Users", "userId", userId));
		
		return UsersPrincipal.createUser(users);
				
	}

}
