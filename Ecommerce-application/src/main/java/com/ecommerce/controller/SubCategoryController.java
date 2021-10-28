package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.models.Category;
import com.ecommerce.user.service.SubCategoryService;
 
@Controller
public class SubCategoryController {

	@Autowired
	private SubCategoryService subCategoryService;
	
	@GetMapping("subCategories")
	public String loadSubCategories(Model model) {
		
		subCategoryService.subCatgories(model);
	

		return "dashboard/sub-category";
		
	}
	
	
	@GetMapping("showSubCategoryForm")
	public String showSubCategoryForm(Model model) {
		List<Category> catrgories = subCategoryService.parentCategories();
		model.addAttribute("parentCategories", catrgories);	
		Category category = new Category();
		category.setStatus(true);
		model.addAttribute("subCategory", category);

		return "dashboard/create-subCategory";
	}
	
	@PostMapping("create-sub-category")
	public String createCategory(@ModelAttribute("category") Category category) {
		
		//category.setId(null);
		//category.setCategory(subCategoryService.catgoryById(category.getCategory().getId()));
		subCategoryService.createCategory(category);
		return "redirect:/subCategories";
	}
	@GetMapping("showUpdateSubCategoryForm/{id}")
	public String showUpdateSubCatgeory(@PathVariable Long id,Model model) {
		
		List<Category> catrgories = subCategoryService.parentCategories();
		model.addAttribute("parentCategories", catrgories);			
		Category category = subCategoryService.catgoryById(id);
		model.addAttribute("subCategory", category);
		
		return "dashboard/update-sub-category";
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "update-sub-category")
	public String updateSubCategory(@ModelAttribute Category category) {
		
		subCategoryService.createCategory(category);
		
		return "redirect:/subCategories";
	}
	@RequestMapping(value="delete-sub-category/{id}",method = RequestMethod.GET)
	public String deleteSubCategory(@PathVariable Long id,RedirectAttributes redirectAttributes) {
		
		try {
			subCategoryService.deleteSubCategory(id);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error","This category contains products make sure to delete all product inside gory cate in order to delete it");
		}
		
		
		
		return "redirect:/subCategories";
		
	}
}
