package com.kyn.configuration;

import java.util.ArrayList;

public class OAuth2 {
	
	private ArrayList<String> authorizedRedirectUris = new ArrayList<String>();

	public ArrayList<String> getAuthorizedRedirectUris() {
		return authorizedRedirectUris;
	}

	public void setAuthorizedRedirectUris(ArrayList<String> authorizedRedirectUris) {
		this.authorizedRedirectUris = authorizedRedirectUris;
	}

	
	
}
