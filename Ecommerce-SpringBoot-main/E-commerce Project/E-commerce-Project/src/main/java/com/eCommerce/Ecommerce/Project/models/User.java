package com.eCommerce.Ecommerce.Project.models;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.Size;

//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@EnableJpaRepositories
@Entity(name = "COSTUMER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true) // This ensures that each user has a unique username in the database
    @Size(min = 5 , message = "Username should be  atleast 5 characters")
    private String username;
    
    private String surname;

    private String email;
    
    @Size(min=8 , message="Enter atleast 8 characters for password")
    private String password;
    
    private String role;
    private String address;
    
    

    public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

	public User(Integer id, String username, String email, String password, String role, String address) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.address = address;
	}
    
}
