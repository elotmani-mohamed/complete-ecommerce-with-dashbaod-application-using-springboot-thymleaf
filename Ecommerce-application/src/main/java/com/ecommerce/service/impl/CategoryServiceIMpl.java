package com.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.models.Category;
import com.ecommerce.repositories.CategoryRepo;
import com.ecommerce.user.service.CategoryService;

@Service
public class CategoryServiceIMpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public List<Category> findAllCategories() {
		
		return categoryRepo.findParentCategories();
	}

	@Override
	public void createCategory(Category category) {
		
		categoryRepo.save(category);
		
	}

	@Override
	public Category findById(Long id) {
		
		return categoryRepo.findById(id).get();
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepo.deleteById(id);
		
	}

	@Override
	public void updateCategory(Category category) {
		
		categoryRepo.save(category);
		
	}

	

	

	

}
