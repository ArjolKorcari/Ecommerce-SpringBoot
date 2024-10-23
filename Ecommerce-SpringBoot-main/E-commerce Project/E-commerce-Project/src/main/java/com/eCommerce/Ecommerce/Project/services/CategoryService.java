package com.eCommerce.Ecommerce.Project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eCommerce.Ecommerce.Project.models.Category;
import com.eCommerce.Ecommerce.Project.models.Product;


@Service
public class CategoryService {
	
	private static List<Category> categories = new ArrayList<Category>();
	private static int id=1;
	
	static {
		categories.add(new Category(id++, "Fruits"));
		categories.add(new Category(id++, "Clothes"));
		categories.add(new Category(id++, "House"));
		categories.add(new Category(id++, "Cars"));
		categories.add(new Category(id++, "Drinks"));
		categories.add(new Category(id++, "Dairy"));
		categories.add(new Category(id++, "Laptops"));
		categories.add(new Category(id++, "Other"));
	}
	
	public List<Category> getCategories() {
		return categories;
	}
	
	public Category getCategory(int id) {
		for(Category category: categories) {
			if(id==category.getId()) {
				return category;
			}
		}
		return null;
	}
	
	 public Category addCategory(Category category) {
		 category.setId(id++);
	        categories.add(category);
	        return category;
	    }

	    // Customize (update) an existing category
	    public Category customizeCategory(int id, Category updatedCategory) {
	        for (Category category : categories) {
	            if (id == category.getId()) {
	                category.setName(updatedCategory.getName());
	                return category;
	            }
	        }
	        return null; // Return null if category not found
	    }

	    // Delete a category
	    public boolean deleteCategory(int id) {
	        Optional<Category> categoryToDelete = categories.stream()
	                .filter(category -> category.getId() == id)
	                .findFirst();

	        if (categoryToDelete.isPresent()) {
	            categories.remove(categoryToDelete.get());
	            return true;
	        }
	        return false; // Return false if category not found
	    }
	

}
