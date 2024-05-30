package com.eCommerce.Ecommerce.Project.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eCommerce.Ecommerce.Project.models.Product;

import jakarta.websocket.Session;

@Repository
public class ProductDao {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public List<Product> getProducts(){
		return this.sessionFactory.getCurrentSession().createQuery("from PRODUCT").list();
	}
	
	@Transactional
	public Product addProduct(Product product) {
		this.sessionFactory.getCurrentSession().save(product);
		return product;
	}
	
	@Transactional
	public Product getProduct(int id) {
		return this.sessionFactory.getCurrentSession().get(Product.class, id);
		
	}
	
	@Transactional
	public Product updateProduct(Product product) {
		this.sessionFactory.getCurrentSession().update(String.valueOf(Product.class), product);
		return product;
		
	}
	
//	@Transactional
//	public Boolean deleteProduct(int id) {
//		Session session = this.sessionFactory.getCurrentSession();
//		Object persistanceInstance = session.load()
//		
//	}

}
