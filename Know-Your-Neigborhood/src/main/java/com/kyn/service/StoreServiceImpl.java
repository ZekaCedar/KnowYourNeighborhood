package com.kyn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyn.entity.Store;
import com.kyn.repository.StoreRepository;

@Service
@Transactional
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	StoreRepository storeRepository;

	@Override
	public Store addStore(Store store) {
		return storeRepository.save(store);
	}

	@Override
	public List<Store> viewStore() {
		return storeRepository.findAll();
	}

	@Override
	public List<Store> searchStoreByKeyword(String keyword) {
		return storeRepository.searchStoreByKeyword(keyword);
	}


	@Override
	public void deleteStore(long storeId) {
		storeRepository.deleteById(storeId);
		
	}

	@Override
	public Optional<Store> getStoreById(long storeId) {
		return storeRepository.findById(storeId);
	}
	
	

}
