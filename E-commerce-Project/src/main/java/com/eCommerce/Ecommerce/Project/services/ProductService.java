package com.eCommerce.Ecommerce.Project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eCommerce.Ecommerce.Project.models.Category;
import com.eCommerce.Ecommerce.Project.models.Product;
import com.eCommerce.Ecommerce.Project.models.User;


@Service
public class ProductService {
	private static CategoryService categoryService;
	
	
	private static List<Product> products= new ArrayList<Product>();
	
	private static int productCount=0;
	private static List<Product> popularProducts= new ArrayList<Product>();
	
	 @Autowired
	    public ProductService(CategoryService categoryService) {
	        this.categoryService = categoryService;
	        initializeProducts();
	        popularProducts();
	    }
	
	  private void initializeProducts() {
		  
		  products.add(new Product(++productCount,"Porche 911 GT3 RS" , "https://files.porsche.com/filestore/image/multimedia/none/992-gt3-rs-modelimage-sideshot/model/cfbb8ed3-1a15-11ed-80f5-005056bbdc38/porsche-model.png",category(4), 20, 222100, 73, " Unleash your passion for driving with the Porsche 911 GT3 RS – where adrenaline meets perfection. ", null));
		 
		  products.add(new Product(++productCount,"RentHouse" , "https://www.thehousedesigners.com/images/uploads/SiteImage-Landing-house-plansluxury-1.webp", category(3), 20, 300, 73, "You are a student, this is a very cheap house ", null));
		  products.add(new Product(++productCount,"Porche 911" ,"https://files.porsche.com/filestore/image/multimedia/none/911-tus-modelimage-sideshot/model/930894f1-6214-11ea-80c8-005056bbdc38/porsche-model.png",category(4) , 20, 400000, 73, "Porsche 911 sets the standard for excellence.", null));
		  products.add(new Product(++productCount, "Macbook pro", "https://tr3bit.al/storage/media/L6LDZNG4E0ryZU4lIHkBvmxOzJJDzeN2WuzQDfPF.png", category(7), 40, 19, 3322, "The MacBook Pro is Apple's flagship laptop, known for its sleek design", null));
		  products.add(new Product(++productCount,"G 63 AMG" ,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmmaw1eESAuSVFKA6pXbOUjJqKciiPh1SATkN-WoI7kQ&s", category(4), 20, 200000, 2003, "The G63 AMG is a high-performance luxury SUV manufactured by Mercedes-AMG", null));
		  products.add(new Product(++productCount,"FC Barcelona Shirt" , "https://footballmonk.in/wp-content/uploads/2023/06/BARCELONA-HOME-RETRO-1999-100-YEAR-OLD_1.jpg",category(2), 20, 100, 73, "Classic FC Barcelona shirt on our web for a special price", null));
			
		  products.add(new Product(++productCount,"Porche 911 Turbo" , "https://files.porsche.com/filestore/image/multimedia/none/992-tucab-modelexplorer-01/normal/a5796b91-8b0e-11eb-80d4-005056bbdc38;sS;twebp065/porsche-normal.webp",category(4), 40, 250000, 76, "The Porsche 911 Turbo is an iconic sports car renowned for its exhilarating performance and timeless design", null));  
		  products.add(new Product(++productCount,"Louis Vuitton Nike Air Force 1" , "https://sothebys-com.brightspotcdn.com/dims4/default/e7416fd/2147483647/strip/false/crop/743x418+1+0/resize/1200x675!/quality/90/?url=http%3A%2F%2Fsothebys-brightspot.s3.amazonaws.com%2Fdotcom%2F7f%2F10%2F1671eb5a43c4b49789d238082a6a%2F90-3.jpg", category(8), 90, 30, 43, "Nike x Louis Vuitton combines the iconic design of the Air Force 1 sneaker with the luxury of Louis Vuitton.", null));
		 
		  products.add(new Product(++productCount,"Galaxy S24 Ultra" ,"https://images.samsung.com/is/image/samsung/p6pim/levant/2401/gallery/levant-galaxy-s24-s928-sm-s928bztwmea-thumb-539426054", category(8), 17, 1000, 2003, "S24 Ultra is a compact, feature-rich smartphone that combines sleek design with powerful performance", null));
		products.add(new Product(++productCount,"Football Items" , "https://assets.goal.com/v3/assets/bltcc7a7ffd2fbf71f5/blte71687e3b1527830/62cd589a8ba3ee49dd9aa19e/Prime-day-2022-football-deals.jpg?auto=webp&format=pjpg&width=3840&quality=60",category(8), 20, 50, 73, "Football items encompass a wide range of gear and equipment essential for playing the sport. ", null));
		
		products.add(new Product(++productCount,"Oversized Motif-detail T-shirt" ,"https://m.media-amazon.com/images/I/71gVnUeccML._AC_UY350_.jpg", category(2), 17, 17, 2003, "Today Only! 15% off $75, 20% off $100", null));
		products.add(new Product(++productCount,"Strawberry smoothie" ,"https://hips.hearstapps.com/hmg-prod/images/delish-how-to-make-a-smoothie-horizontal-1542310071.png?crop=0.8893333333333334xw:1xh;center,top&resize=1200:*", category(5), 17, 4, 2003, "Indulge in the refreshing sweetness of a strawberry smoothie!", null));
		products.add(new Product(++productCount,"House for Rent" , "https://www.thehousedesigners.com/images/uploads/SiteImage-Landing-contemporary-house-plans-1.webp", category(3), 90, 800, 43, "Charming house for rent featuring modern amenities and stylish interior design", null));
		products.add(new Product(++productCount,"iPhone 15 Pro Max" , "https://www.redline.al/wp-content/uploads/2023/11/Apple-iPhone-15-Pro-lineup-hero-230912.jpg.news_app_ed.jpg", category(8), 90, 1200, 43, "The iPhone 15 Pro Max is the pinnacle of Apple's smartphone innovation, boasting  technology", null));
		products.add(new Product(++productCount,"Tab S9 Ultra" , "https://media.merrjep.al/Image/6ce3a4572ae04967ae94dac9086b11eb/20240315/false/false/1280/960/tablet-s9-ultra-samsung-i-ri.jpeg?noLogo=true", category(8), 90, 1200, 43, "The Tab S9 Ultra is a state-of-the-art tablet designed for exceptional productivity and entertainment.", null));
		products.add(new Product(++productCount,"Dairy Food " , "https://cu-website-cms-prd.s3.amazonaws.com/Milk_Products_ca4b0ea83e.jpg", category(6), 90, 20, 43, "Fresh from the farm to your table, our dairy products are crafted with care and quality in mind. ", null));
		
	  
	  }
	  
	  private void popularProducts() {
		  popularProducts.add(new Product(++productCount,"Porche 911 GT3 RS" , "https://files.porsche.com/filestore/image/multimedia/none/992-gt3-rs-modelimage-sideshot/model/cfbb8ed3-1a15-11ed-80f5-005056bbdc38/porsche-model.png",category(4), 20, 222100, 73, " Unleash your passion for driving with the Porsche 911 GT3 RS – where adrenaline meets perfection. ", null));
		  popularProducts.add(new Product(++productCount,"Porche 911 Turbo" , "https://files.porsche.com/filestore/image/multimedia/none/992-tucab-modelexplorer-01/normal/a5796b91-8b0e-11eb-80d4-005056bbdc38;sS;twebp065/porsche-normal.webp",category(4), 40, 250000, 76, "The Porsche 911 Turbo is an iconic sports car renowned for its exhilarating performance and timeless design", null));  
		  popularProducts.add(new Product(++productCount,"Louis Vuitton Nike Air Force 1" , "https://sothebys-com.brightspotcdn.com/dims4/default/e7416fd/2147483647/strip/false/crop/743x418+1+0/resize/1200x675!/quality/90/?url=http%3A%2F%2Fsothebys-brightspot.s3.amazonaws.com%2Fdotcom%2F7f%2F10%2F1671eb5a43c4b49789d238082a6a%2F90-3.jpg", category(8), 90, 30, 43, "Nike x Louis Vuitton combines the iconic design of the Air Force 1 sneaker with the luxury of Louis Vuitton.", null));
		  popularProducts.add(new Product(++productCount,"Porche 911" ,"https://files.porsche.com/filestore/image/multimedia/none/911-tus-modelimage-sideshot/model/930894f1-6214-11ea-80c8-005056bbdc38/porsche-model.png",category(4) , 20, 400000, 73, "Porsche 911 sets the standard for excellence.", null));
		  	   
	  }
	  
	  public List<Product> getPopularProducts(){
		  return popularProducts;
	  }
	  
	  
	  
	  
	  public List<Product> searchProducts(String keyword) {
	        List<Product> searchResults = new ArrayList<>();
	        for (Product product : products) {
	            // Check if the product name or description contains the keyword
	            if (product.getName().toLowerCase().contains(keyword.toLowerCase()) ||
	                product.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
	                searchResults.add(product);
	            }
	        }
	        return searchResults;
	    }
	
	private static Category category(int id) {
		return categoryService.getCategory(id);

	}
	
	public List<Product> getProducts(){
		return products;
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	public Product getProduct(int id) {
		for(Product product: products) {
			if(product.getId()==id) {
				return product;
			}
		}
		return null;
	}
	
	public void deleteProduct(int id) {
		Predicate<? super Product> predicate=product-> product.getId()==id; // kjo eshte nje metod qe shef nese id qe jepet tek kjo todo objekt eshte e barabart me todo specifike
		products.removeIf(predicate);
	}
	
	public void updateProduct( Product product) {
		deleteProduct(product.getId());
		products.add(product);
	}
	
	
	public List<Product> findProductByCategory(int id) {
	    List<Product> productsInCategory = new ArrayList<>();
	    for (Product product : products) {
	        // Check if the product and its category are not null
	        if (product != null && product.getCategory() != null && product.getCategory().getId() == id) {
	            productsInCategory.add(product);
	        }
	    }
	    return productsInCategory;
	}

	
	
	public List<Product> createProductList(int id, String name, String image, Category category, int quantity,
	        int price, int weight, String description, User customer) {
	    List<Product> products = new ArrayList<>();
	    Product product = new Product(id, name, image, category, quantity, price, weight, description, customer);
	    products.add(product);
	    return products;
	}
	
	
	   public Product addProductt(Product product) {
	        product.setId(++productCount);  // Automatically incrementing product ID
	        products.add(product);
	        return product;
	    }
	
	 public boolean changeProductName(int productId, String newName) {
	        for (Product product : products) {
	            if (product.getId() == productId) {
	                product.setName(newName);
	                return true;
	            }
	        }
	        return false;
	    }
	 
	 
	 public boolean changeProductImage(int productId, String newImageUrl) {
	        for (Product product : products) {
	            if (product.getId() == productId) {
	                product.setImage(newImageUrl);
	                return true;
	            }
	        }
	        return false;
	    }
	 
	 
	 public boolean addProductToPopularProducts(int productId) {
	        for (Product product : products) {
	            if (product.getId() == productId) {
	                if (!popularProducts.contains(product)) {
	                    popularProducts.add(product);
	                    return true; // Successfully added
	                } else {
	                    return false; // Product already exists in popularProducts
	                }
	            }
	        }
	        return false; // Product not found in the main products list
	    }
	 
	 
	 public boolean updateProductPrice(int productId, Integer newPrice) {
	        for (Product product : products) {
	            if (product.getId() == productId) {
	                product.setPrice(newPrice);
	                return true; // Price updated successfully
	            }
	        }
	        return false; // Product not found
	    }
	 

}
