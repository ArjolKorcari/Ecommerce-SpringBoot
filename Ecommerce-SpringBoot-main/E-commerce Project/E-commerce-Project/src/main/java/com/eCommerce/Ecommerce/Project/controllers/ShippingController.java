package com.eCommerce.Ecommerce.Project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eCommerce.Ecommerce.Project.models.ShipingDetails;
import com.eCommerce.Ecommerce.Project.services.ShippingDetailsService;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
	
	@Autowired
    private ShippingDetailsService shippingDetailsService;
	
	 @PostMapping
	    public ResponseEntity<ShipingDetails> saveDetails(@RequestBody ShipingDetails shipingDetails) {
	        try {
	            ShipingDetails savedDetails = shippingDetailsService.saveShippingDetails(shipingDetails);
	            return new ResponseEntity<>(savedDetails, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	 
	 @GetMapping
	 public ResponseEntity<List<ShipingDetails>> getShippingDetails() {
	        List<ShipingDetails> allDetails = shippingDetailsService.getShippingDetails();
	        return ResponseEntity.ok(allDetails);
	    }
}
