package com.eCommerce.Ecommerce.Project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eCommerce.Ecommerce.Project.models.CartProduct;
import com.eCommerce.Ecommerce.Project.models.Product;
import com.eCommerce.Ecommerce.Project.models.User;

@Service
public class CartProductsService {
	
	private static ProductService productService;
	private  List<CartProduct> cartProducts;
	private static int cartId=0;
	
	@Autowired
	public CartProductsService(ProductService productService) {
		this.productService=productService;
		this.cartProducts = new ArrayList<>();
	}
	
	
	 public List<CartProduct> addToCart(int productId, int quantity) {
	        Product product = productService.getProduct(productId);
	        if (product == null) {
	            // Handle the case where the product doesn't exist
	            return cartProducts;
	        }

	        // Check if the product already exists in the cart
	        for (CartProduct cartProduct : cartProducts) {
	            if (cartProduct.getProduct().getId() == productId) {
	                // If the product already exists, update the quantity
	                cartProduct.setQuantity(cartProduct.getQuantity() + quantity);
	         
	                return cartProducts;
	            }
	        }

	        // If the product doesn't exist in the cart, add it
	        
	        cartProducts.add(new CartProduct(++cartId ,product, quantity));
	       
	        return cartProducts;
	    }
	 
	 
	 	public  Integer totatlQuantity() {
	 		int totalQuantity=0;
	 		for (CartProduct cartProduct : cartProducts) {
	 			 
	 			 if (cartProduct.getQuantity() < 0) {
	 				 cartProduct.setQuantity(0); // Nëse quantity është më e vogël se zero, vendos atë në zero
	 	        }
	 			 
	 			totalQuantity += cartProduct.getQuantity();
	 		}
	 		return totalQuantity;
	 	}
	 
	 
		public List<CartProduct> getCartProducts(){
			return cartProducts;
		}
		
		public double calculateSubtotal() {
		    double subtotal = 0.0;
		    for (CartProduct cartProduct : cartProducts) {
		        double productPrice = cartProduct.getProduct().getPrice();
		        if (cartProduct.getQuantity() < 0) {
	 				 cartProduct.setQuantity(0); // Nëse quantity është më e vogël se zero, vendos atë në zero
	 	        }
		      
		        subtotal += productPrice * cartProduct.getQuantity();;
		    }
		    return subtotal;
		}
		
		public void deleteCartProduct(int id) {
			Predicate<? super CartProduct>predicate =products->
	    	products.getId()==id;
	    	cartProducts.removeIf(predicate);
		}

		
	
		
	
	
	
}
