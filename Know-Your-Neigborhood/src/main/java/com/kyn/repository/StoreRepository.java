package com.kyn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kyn.entity.Store;


@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{
	
	@Query(value = "SELECT s FROM Store s WHERE storeName LIKE '%' || :keyword || '%' "
			+ "OR storeContact LIKE '%' || :keyword || '%'"
			+ "OR storeLocalities LIKE '%' || :keyword || '%'"
			+ "OR storeEmail LIKE '%' || :keyword || '%'")
	List<Store> searchStoreByKeyword(@Param("keyword") String keyword);
}
