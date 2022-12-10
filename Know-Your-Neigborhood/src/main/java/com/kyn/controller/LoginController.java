package com.kyn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyn.jwtsecurity.TokenProvider;
import com.kyn.payload.AfterLogin;
import com.kyn.payload.Login;

@RestController
@RequestMapping( value = "/kyn")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	//return response entity
	@PostMapping(value = "/login")
	public ResponseEntity<?> loginUser(@RequestBody Login login){
		
		//Check Authentication
		// using email and password
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
		
		//Call the security
		//check the authentication
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		//if authentication is correct
		//can get permission, provide the token
		String token = tokenProvider.createToken(authentication);
		
		//return the token in the body
		// pass the token and token type
		// ok status mean 200 HTTP status
		return ResponseEntity.ok(new AfterLogin(token));
		
	}

}
