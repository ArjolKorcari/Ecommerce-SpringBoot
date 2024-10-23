package com.eCommerce.Ecommerce.Project.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eCommerce.Ecommerce.Project.models.CartProduct;
import com.eCommerce.Ecommerce.Project.models.Category;
import com.eCommerce.Ecommerce.Project.models.Product;
import com.eCommerce.Ecommerce.Project.models.User;

@Service
public class CartService {
	
	private static ProductService productService;
	private static List<Product> cartProducts= new  ArrayList<Product>();
	private static List<String> promotionCode= new ArrayList<String>();
	
	
	@Autowired
	public CartService(ProductService productService) {
		this.productService=productService;
	}
	
	static {
		promotionCode.add("#A123B");
		promotionCode.add("#AB22B");
		promotionCode.add("#AC23B");
		promotionCode.add("#AD23B");
		promotionCode.add("#AE23B");
		promotionCode.add("#AF23B");
	}
	
	
	public List<Product> createProductList(int id) {
		
		
	    Product product = productService.getProduct(id);
	    for(Product product2 : cartProducts) {
	    if(product2.getId()==id) {
	    	return null;
	    }}
	    cartProducts.add(product);
	    return cartProducts;
	}
	
	private Product getCartProduct(int id) {
	    for (Product product : cartProducts) {
	        if (product.getId() == id) {
	            return product;
	        }
	    }
	    return null;
	}

	
	public List<Product> getCartProducts(){
		return cartProducts;
	}
	
	public int calculatePrice() {
		int totalPrice=0;
		for(Product product: cartProducts) {
			totalPrice+=product.getPrice();
		}
		return totalPrice;
		
	}

	
	public void deleteCart(int id) {
		Predicate<? super Product>predicate =products->
    	products.getId()==id;
    	cartProducts.removeIf(predicate);
	}
	
	public int updateSubtotal(int id, int number) {
		Product product= getCartProduct(id);
		int newPrice=product.getPrice()*number;
		int subtotal=newPrice+calculatePrice();
		return subtotal;
	}
	
	public void updateCart(int counter, int id) {
		deleteCart(id);
		List<Product> cartProducts1=getCartProducts();
		
		
		Product product = productService.getProduct(id);
		product.setPrice(product.getPrice()*counter);
		
		cartProducts.add(product);
		
	}
	public List<Integer> number(){
		List<Integer> numbers= new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4); 
		return numbers;
		
		
	}
	
	public Double discountPrice(String code) {
	    double subtotal = calculatePrice();
	    for (String redeemCode : promotionCode) {
	        if (redeemCode.equalsIgnoreCase(code)) {
	            subtotal = subtotal - (0.1 * subtotal);
	            break; 
	        }
	    }
	    return subtotal;
	}
	public int updateSubtotalBasedOnQuantity(int id, int newQuantity) {
	    // Gjej produktin në shportën e blerjeve
	    Product product = getCartProduct(id);
	    if (product == null) {
	        // Produkti nuk ekziston në shportën e blerjeve, kështu që nuk ka nevojë për azhurnime
	        return calculatePrice(); // Ktheje subtotalin aktual
	    }

	    // Llogarit çmimin e ri bazuar në numrin e ri të produktit
	    int newPrice = product.getPrice() * newQuantity;

	    // Gjej subtotalin aktual
	    int currentTotal = calculatePrice();

	    // Llogarit subtotalin e ri
	    int newTotal = currentTotal - (product.getPrice() * product.getQuantity()) + newPrice;

	    // Azhurno produktin në shportën e blerjeve me numrin e ri të produktit
	    product.setQuantity(newQuantity);

	    // Kthe subtotalin e ri
	    return newTotal;
	}



	

	

}
