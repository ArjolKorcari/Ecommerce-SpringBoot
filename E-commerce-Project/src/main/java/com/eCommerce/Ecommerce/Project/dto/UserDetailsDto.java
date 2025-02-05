package com.eCommerce.Ecommerce.Project.dto;

import javax.persistence.Column;

import com.eCommerce.Ecommerce.Project.models.Payment;

import jakarta.validation.constraints.Size;

public class UserDetailsDto {

  
	private String firstName;
	private String lastName;
	
	 private String email;
    private String username;
    
    private String adress1;
    private String adress2;
    private String city;
    
    private String state;
    private String zip;
    private Payment payment;

   
    
   
}
