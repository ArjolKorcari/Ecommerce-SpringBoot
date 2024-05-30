package com.eCommerce.Ecommerce.Project.models;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "PRODUCT" )
public class Product {
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String image;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private Category category;
	
	private int quantity;
	
	private int price;
	
	private int weight;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "costumer_id")
	private User costumer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
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

	public Product(int id2, String name2, String image2, Category category2, int quantity2, int price2, int weight2,
			String description2, Object costumer2) {
		// TODO Auto-generated constructor stub
	}
	public Product(){
		
	}
	
	
	
	
	
	
	

}
