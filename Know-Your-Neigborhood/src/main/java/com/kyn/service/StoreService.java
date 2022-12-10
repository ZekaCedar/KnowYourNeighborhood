package com.kyn.service;

import java.util.List;
import java.util.Optional;

import com.kyn.entity.Store;

public interface StoreService {
	
	public Store addStore(Store store);
	
	public List<Store> viewStore();
	
	public List<Store> searchStoreByKeyword(String keyword);
	
	public Optional<Store> getStoreById(long storeId);
	
	public void deleteStore(long storeId);

}
