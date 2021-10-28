package com.ecommerce.doa;

import java.util.List;

import com.ecommerce.models.Category;

public class CategoryDto {

	
	private Long id;
	
	private String name;
	
	private boolean status;
	

	private List<Category> parentCategorId;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public List<Category> getParentCategorId() {
		return parentCategorId;
	}


	public void setParentCategorId(List<Category> parentCategorId) {
		this.parentCategorId = parentCategorId;
	}
	
	
}
