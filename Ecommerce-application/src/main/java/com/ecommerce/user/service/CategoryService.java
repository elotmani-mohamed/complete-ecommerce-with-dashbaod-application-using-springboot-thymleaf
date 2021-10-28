package com.ecommerce.user.service;

import java.util.List;

import com.ecommerce.models.Category;

public interface CategoryService {
	
	List<Category> findAllCategories();
    void createCategory(Category category);
    Category findById(Long id);
    void deleteCategory(Long id);
	void updateCategory(Category category);
	
}