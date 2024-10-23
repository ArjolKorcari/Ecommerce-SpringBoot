package com.eCommerce.Ecommerce.Project.models;

import jakarta.persistence.CascadeType;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name = "PRODUCT" )
public class Product {
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String image;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	
	private Integer quantity;
	
	private Integer price;
	
	private Integer weight;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "costumer_id")
	private User costumer;

	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getCostumer() {
		return costumer;
	}

	public void setCostumer(User costumer) {
		this.costumer = costumer;
	}
	
	

	public Product(int id, String name, String image, Category category, int quantity, int price, int weight,
			String description, User costumer) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
		this.weight = weight;
		this.description = description;
		this.costumer = costumer;
	}

	public Product(){
		
	}
	
	
	
	
	
	
	

}
