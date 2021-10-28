package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.models.Category;
import com.ecommerce.user.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("category")
	public String category(ModelMap map) {
		
		map.put("ctg", categoryService.findAllCategories());
		
		return "dashboard/categories";
	}
	
	@GetMapping("create-category")
	public String showCreateCatgory(Model model) {
		
		Category category = new Category();
		category.setStatus(true);
			model.addAttribute("category", category);
  
		return "dashboard/create-user";
	}
	
	@PostMapping("proccess-category")
	public String createCategory(@ModelAttribute("category") Category category) {
		
		
		
		categoryService.createCategory(category);
		return "redirect:/category";
	}

	@GetMapping("edit-category/{id}")
	public String updateCategoryForm(@PathVariable Long id,Model model) {
		
		Category category = categoryService.findById(id);
		System.err.println(category);
		model.addAttribute("category", category);
		return "dashboard/edit-category";
		
	}
	
	@RequestMapping(value = "update-category",method = RequestMethod.POST)
	public String updateCategory(@ModelAttribute("category") Category category) {
		
		categoryService.updateCategory(category);
		
		return "redirect:/category";
	}
	
	@GetMapping("delete-category/{id}")
	public String deleteCategory(@PathVariable Long id,RedirectAttributes redirectAttributes)
	{
		try {
			categoryService.deleteCategory(id);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error","Delete Failed");
		}
		
		return "redirect:/category";	
	}
	
}
