package com.eCommerce.Ecommerce.Project.models;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity(name = "CART_PODUCT")
public class CartProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
//	@ManyToOne
//	@JoinTable(name = "product_id")
//	private Cart cart;
//	
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
