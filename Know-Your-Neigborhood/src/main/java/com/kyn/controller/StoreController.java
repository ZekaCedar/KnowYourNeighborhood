package com.kyn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyn.entity.Store;
import com.kyn.service.StoreService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/kyn")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	//Add Store API
	@PostMapping(value = "/saveStore")
	public Store addStore(@RequestBody Store store) {
		return storeService.addStore(store);
	}
	
	//View Store API
	@GetMapping(value = "/viewStore")
	public List<Store> viewStore(){
		return storeService.viewStore();
	}
	
	//Search Store API
	@GetMapping(value = "/search/{keyword}")
	public List<Store> searchStore(@PathVariable String keyword){
		return storeService.searchStoreByKeyword(keyword);
	}
	
	//Delete Store API
	@DeleteMapping(value = "/delete/{store_id}")
	public void deleteStorebyId(@PathVariable long store_id) {
		storeService.deleteStore(store_id);
	}
	
	//Find Store by Id API
	@GetMapping( value = "/getStore/{store_id}")
	public Optional<Store> getStoreById(@PathVariable long store_id){
		return storeService.getStoreById(store_id);
	}

}
