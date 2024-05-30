//package com.eCommerce.Ecommerce.Project.repository;
//
//import java.util.List;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.eCommerce.Ecommerce.Project.models.Category;
//
//@Service
//public class CategoryDao {
//	
//	private SessionFactory sessionFactory;
//	
//	@Autowired
//	public void setSessionFactory (SessionFactory sessionFactory) {
//		this.sessionFactory=sessionFactory;
//	}
//	
//	@Transactional
//	public Category addCategory(String name) {
//		Category category = new Category();
//		category.setName(name);
//		this.sessionFactory.getCurrentSession().saveOrUpdate(category);
//		return category;
//	}
//	
//	@Transactional
//	public List<Category> getCategories(){
//		return this.sessionFactory.getCurrentSession().createQuery("from CATEGORY").list();
//	}
//	
//	@Transactional
//	public Category updateCategory(int id, String name) {
//		Category category= this.sessionFactory.getCurrentSession().get(Category.class, id);
//		category.setName(name);
//		this.sessionFactory.getCurrentSession().update(category);
//		return category;
//	}
//	
//	@Transactional
//	public Category getCategory(int id) {
//		return this.sessionFactory.getCurrentSession().get(Category.class, id);
//	}
//
//	
//
//}
