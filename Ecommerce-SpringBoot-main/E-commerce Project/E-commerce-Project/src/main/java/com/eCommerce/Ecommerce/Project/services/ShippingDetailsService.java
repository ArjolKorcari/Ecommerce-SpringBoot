package com.eCommerce.Ecommerce.Project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eCommerce.Ecommerce.Project.dto.UserDetailsDto;
import com.eCommerce.Ecommerce.Project.models.Payment;
import com.eCommerce.Ecommerce.Project.models.ShipingDetails;
import com.eCommerce.Ecommerce.Project.repository.PaymentRepository;
import com.eCommerce.Ecommerce.Project.repository.ShipingDetailsRepository;
import com.eCommerce.Ecommerce.Project.repository.UserRepository;

@Service
public class ShippingDetailsService {
	
	@Autowired
	private ShipingDetailsRepository detailsService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	
//	public void postShippingDetails(UserDetailsDto detailsDto) {
//		
//		ShipingDetails shipingDetails = new ShipingDetails();
//		Payment paymentDetails = new Payment();
//		paymentDetails.setPaymentType(null);
//		shipingDetails.setPaymentDetails(null);
//	}
	
	public ShipingDetails saveShippingDetails(ShipingDetails shipingDetails) {
		detailsService.save(shipingDetails);
		return shipingDetails;
	}
	
	public List<ShipingDetails> getShippingDetails(){
		return detailsService.findAll();
	}
	
}
