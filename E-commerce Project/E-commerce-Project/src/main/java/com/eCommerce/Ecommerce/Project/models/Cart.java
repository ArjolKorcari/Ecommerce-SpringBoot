package com.eCommerce.Ecommerce.Project.models;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "CART")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // kjo ben qe vlera e gjenerar te zgjidhet automatikisht
	private int id;
	
	
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
