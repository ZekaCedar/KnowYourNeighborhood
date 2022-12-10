package com.kyn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	Long storeId;
	String storeName;
	String storeContact;
	String storeLocalities;
	String storeEmail;
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreContact() {
		return storeContact;
	}
	public void setStoreContact(String storeContact) {
		this.storeContact = storeContact;
	}
	public String getStoreLocalities() {
		return storeLocalities;
	}
	public void setStoreLocalities(String storeLocalities) {
		this.storeLocalities = storeLocalities;
	}
	public String getStoreEmail() {
		return storeEmail;
	}
	public void setStoreEmail(String storeEmail) {
		this.storeEmail = storeEmail;
	}
	public Store(String storeName, String storeContact, String storeLocalities, String storeEmail) {
		super();
		this.storeName = storeName;
		this.storeContact = storeContact;
		this.storeLocalities = storeLocalities;
		this.storeEmail = storeEmail;
	}
	public Store() {
		
	}

	
	
	
	
}
