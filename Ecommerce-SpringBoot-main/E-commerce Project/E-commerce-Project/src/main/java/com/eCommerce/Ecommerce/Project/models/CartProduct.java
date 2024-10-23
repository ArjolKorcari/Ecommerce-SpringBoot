package com.eCommerce.Ecommerce.Project.models;

import jakarta.persistence.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;

@Entity(name = "CART_PODUCT")
public class CartProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
//	@ManyToOne
//	@JoinTable(name = "product_id")
//	private Cart cart;
//	
	
	@ManyToOne
	private Product product;
	private Integer quantity;
	
	

	public CartProduct() {
		product=null;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public CartProduct(int id, Product product, Integer quantity) {
		super();
		//this.cart = cart;
		this.product = product;
		this.quantity = quantity;
		this.id= id;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



//	public Cart getCart() {
//		return cart;
//	}
//
//
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
	
	

}
