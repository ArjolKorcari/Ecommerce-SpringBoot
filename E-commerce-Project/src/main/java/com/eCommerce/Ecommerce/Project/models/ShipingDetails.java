package com.eCommerce.Ecommerce.Project.models;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class ShipingDetails {
	@Id
	private Integer id;
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Assuming 'user_id' is the foreign key
    private User userDetails;
	
	
	@ManyToOne
    @JoinColumn(name = "payment_id", nullable = false) // New relation to Payment
    private Payment paymentDetails;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public User getUserDetails() {
		return userDetails;
	}


	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}


	public Payment getPaymentDetails() {
		return paymentDetails;
	}


	public void setPaymentDetails(Payment paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
	

}
