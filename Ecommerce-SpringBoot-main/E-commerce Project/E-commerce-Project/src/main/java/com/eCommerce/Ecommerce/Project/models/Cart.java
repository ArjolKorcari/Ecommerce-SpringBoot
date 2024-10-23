package com.eCommerce.Ecommerce.Project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "CART")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // kjo ben qe vlera e gjenerar te zgjidhet automatikisht
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name = "costumer_id")
	private User costumer;
	
	private Cart() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public User getCostumer() {
		return costumer;
	}

	public void setCostumer(User costumer) {
		this.costumer = costumer;
	}
	
	
}
