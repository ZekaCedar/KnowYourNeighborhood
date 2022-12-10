package com.kyn.exception;

import javax.naming.AuthenticationException;

public class OAuthAuthenticationException extends AuthenticationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OAuthAuthenticationException(String msg) {
		super(msg);
	}

}
