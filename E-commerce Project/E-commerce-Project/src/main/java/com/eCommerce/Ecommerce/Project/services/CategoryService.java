package com.eCommerce.Ecommerce.Project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eCommerce.Ecommerce.Project.models.Category;


@Service
public class CategoryService {
	
	private static List<Category> categories = new ArrayList<Category>();
	
	
	static {
		categories.add(new Category(1, "Fruits"));
		categories.add(new Category(2, "Clothes"));
		categories.add(new Category(3, "House"));
		categories.add(new Category(4, "Cars"));
		categories.add(new Category(5, "Drinks"));
		categories.add(new Category(6, "Dairy"));
		categories.add(new Category(7, "Laptops"));
		categories.add(new Category(8, "Other"));
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
	

}
