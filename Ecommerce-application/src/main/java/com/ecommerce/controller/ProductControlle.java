package com.ecommerce.controller;

import java.util.ArrayList;
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

import com.ecommerce.models.Category;
import com.ecommerce.models.Photo;
import com.ecommerce.models.Product;
import com.ecommerce.user.service.CategoryService;
import com.ecommerce.user.service.ProductService;

@Controller
public class ProductControlle {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="showProduct", method = RequestMethod.GET)
	public String showProduct(Model model) {
		
	
		
		model.addAttribute("products", 	productService.allProducts());
		
		return "dashboard/admin-product";
	}
	
	@GetMapping("add-product")
	public String showAddProductForm(Model model) {
		
		List<Category> allCategories = categoryService.findAllCategories();
		model.addAttribute("categories", allCategories);
		
		Product product = new Product();
		product.setStatus(true);
		model.addAttribute("product", product);
		model.addAttribute("userPhotos", new ArrayList<Photo>());
		return "dashboard/add-product";
	}
	
	@PostMapping("save-product")
	public String saveProduct(@ModelAttribute Product  product) {
		productService.saveProduct(product);
		return "redirect:/showProduct";
	}
	
	@GetMapping("update-product-form/{id}")
	public String showUpdateForm(@PathVariable Long id,Model model) {
		
		List<Category> allCategories = categoryService.findAllCategories();
		model.addAttribute("categories", allCategories);
		
		Product product = productService.getProductById(id);
		
		model.addAttribute("product", product);
		
		return "dashboard/update-products";
	}
	
	@PostMapping("update-product")
	public String updateProduct(@ModelAttribute Product product) {
		
		
		productService.saveProduct(product);
		
		return "redirect:/showProduct";
	}
	
	@GetMapping(value="delete-product/{id}")
	public String deleteProduct(@PathVariable Long id) {
		
		productService.removeProduct(id);
		
		return "redirect:/showProduct";
	}
	
	
}
