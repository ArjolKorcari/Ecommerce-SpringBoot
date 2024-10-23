package com.eCommerce.Ecommerce.Project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eCommerce.Ecommerce.Project.models.Product;
import com.eCommerce.Ecommerce.Project.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	  @PutMapping("/changeName")
	    public ResponseEntity<String> changeProductName(@RequestParam int productId, @RequestParam String newName) {
	        boolean isUpdated = productService.changeProductName(productId, newName);
	        
	        if (isUpdated) {
	            return ResponseEntity.ok("Product name updated successfully.");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with ID " + productId + " not found.");
	        }
	    }
	  
	  
	  @PutMapping("/changeImage")
	    public ResponseEntity<String> changeProductImage(@RequestParam int productId, @RequestParam String newImageUrl) {
	        boolean isUpdated = productService.changeProductImage(productId, newImageUrl);
	        
	        if (isUpdated) {
	            return ResponseEntity.ok("Product image updated successfully.");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with ID " + productId + " not found.");
	        }
	    }
	  
	  @PutMapping("/updatePrice")
	    public ResponseEntity<String> updateProductPrice(@RequestParam int productId, @RequestParam Integer newPrice) {
	        boolean isUpdated = productService.updateProductPrice(productId, newPrice);
	        
	        if (isUpdated) {
	            return ResponseEntity.ok("Product price updated successfully.");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with ID " + productId + " not found.");
	        }
	    }
	  
	  
	  @PostMapping("/add")
	    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
	        Product newProduct = productService.addProductt(product);
	        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
	    }
	  
	  
	  @DeleteMapping("/delete")
	  public ResponseEntity<Void> deleteProduct(@RequestParam int productId) {
	      productService.deleteProduct(productId);
	      return ResponseEntity.ok().build();
	  }
	  
	  
	  @PostMapping("/popular/{productId}")
	    public ResponseEntity<String> addProductToPopular(@PathVariable int productId) {
	        boolean result = productService.addProductToPopularProducts(productId);
	        
	        if (result) {
	            return ResponseEntity.ok("Product successfully added to popular products.");
	        } else {
	            return ResponseEntity.badRequest().body("Product could not be added. It may already be in popular products or doesn't exist.");
	        }
	    }


}
