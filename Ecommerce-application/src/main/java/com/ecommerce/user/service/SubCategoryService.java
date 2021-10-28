package com.ecommerce.user.service;

import java.util.List;

import org.springframework.ui.Model;

import com.ecommerce.models.Category;

public interface SubCategoryService {

	void subCatgories(Model model);
	List<Category> parentCategories();
	void createCategory(Category category);
	Category catgoryById(Long id);
	void deleteSubCategory(Long id);
	
}
