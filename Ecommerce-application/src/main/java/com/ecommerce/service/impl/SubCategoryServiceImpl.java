package com.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ecommerce.models.Category;
import com.ecommerce.repositories.CategoryRepo;
import com.ecommerce.user.service.SubCategoryService;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public void subCatgories(Model model) {
		
		List<Category> categories = categoryRepo.findParentCategories();
//		 List<String> names = new ArrayList<String>();
//		categories.forEach(ct->{
//			names.add(ct.getName());
//		});	
//		 model.addAttribute("names", names);
//		List<Category> cats = new ArrayList<Category>();
//
//      categories.forEach(c->{
//    	  c.getCategories().forEach(b->{
//    		  cats.add(b);
//    	  });
//      });    
    
      model.addAttribute("subCategories", categories);
               

      
	}

	@Override
	public List<Category> parentCategories() {
		
		
		 
		return categoryRepo.findParentCategories();
	}

	@Override
	public void createCategory(Category category) {
		// TODO Auto-generated method stub
		categoryRepo.save(category);
	}

	@Override
	public Category catgoryById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepo.findById(id).get();
	}

	@Override
	public void deleteSubCategory(Long id) {
		// TODO Auto-generated method stub
		categoryRepo.deleteById(id);
	}

}
