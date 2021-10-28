package com.ecommerce.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Long price;
	
	private boolean status;
	
	private int quantity;
	
	private String description;
	
	private boolean feautred;
	
	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;
	
	@Transient
	private List<MultipartFile> files= new ArrayList<MultipartFile>();
	
	@Transient
	private List<String> removeFiles = new ArrayList<String>();

	@OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
	private List<Photo> photos;
	
	
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isFeautred() {
		return feautred;
	}

	public void setFeautred(boolean feautred) {
		this.feautred = feautred;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public List<String> getRemoveFiles() {
		return removeFiles;
	}

	public void setRemoveFiles(List<String> removeFiles) {
		this.removeFiles = removeFiles;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	
	
	

	
	
	
	
	
}
