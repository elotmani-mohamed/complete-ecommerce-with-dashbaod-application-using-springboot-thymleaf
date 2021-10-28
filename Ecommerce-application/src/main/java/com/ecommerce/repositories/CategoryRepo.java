package com.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

	@Query("from Category c where c.category=null")
	List<Category> findParentCategories();
//	@Query("from Category c where c.category!=null")
//	List<Category> findSubCategories();
	
}
