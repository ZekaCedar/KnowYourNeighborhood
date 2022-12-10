package com.kyn.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.kyn.entity.Users;

public class UsersPrincipal implements UserDetails, OAuth2User{


	private static final long serialVersionUID = 1L;
	
	private long usersId;
	private String email;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	private Map<String, Object> attributes;
	
	
	public UsersPrincipal(long usersId, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.usersId = usersId;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	
	// if user role is ROLE_USER
	public static UsersPrincipal createUser(Users users) {
		List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
		UsersPrincipal usersPrincipal = new UsersPrincipal(users.getUsersId(), users.getEmail(), users.getPassword(), authorities);
		return usersPrincipal;
	}
	
	// It returns usersPrincipal for Google
	public static UsersPrincipal createUser(Users users, Map<String, Object>attributes) {
		UsersPrincipal userPrincipal = UsersPrincipal.createUser(users);
		userPrincipal.setAttributes(attributes);
		return userPrincipal;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
	
		return password;
	}

	@Override
	public String getUsername() {
		
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

	public long getUsersId() {
		return usersId;
	}

	public void setUsersId(long usersId) {
		this.usersId = usersId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	@Override
	public String getName() {
		return String.valueOf(usersId);
	}
	
	

}
