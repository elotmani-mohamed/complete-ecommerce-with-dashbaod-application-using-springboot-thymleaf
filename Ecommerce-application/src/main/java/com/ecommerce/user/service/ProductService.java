package com.ecommerce.user.service;

import java.util.List;

import com.ecommerce.models.Product;

public interface ProductService {
	
	List<Product> allProducts();

	 Product saveProduct(Product product);

	void removeProduct(Long id);
	
	Product getProductById(Long id);

	
}
