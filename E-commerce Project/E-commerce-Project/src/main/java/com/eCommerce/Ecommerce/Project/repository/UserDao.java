//package com.eCommerce.Ecommerce.Project.repository;
//
//import java.util.List;
//
//
//
////import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.eCommerce.Ecommerce.Project.models.User;
//
//
//
////@Repository
//public class UserDao {
//	
//  private SessionFactory sessionFactory;
//  
//  @Autowired
//  public void setSessionFactory(SessionFactory sessionFactory) {
//    this.sessionFactory = sessionFactory;
//  }
//   
//  @Transactional
//  public List<User> getAllUser() {
//    Session session = sessionFactory.getCurrentSession();
//    List<User> userList = session.createQuery("from User").list();
//    return userList;
//  }
//  @Transactional
//  public User saveUser(User user) {
//	  this.sessionFactory.getCurrentSession().saveOrUpdate(user);
//	  System.out.println("User added "+ user.getId());
//	  return user;
//  }
//  
////  @Transactional
////  public User getUser(String username, String password) {
////	  Query query = sessionFactory.getCurrentSession().createQuery("from CUSTOMER where username =:username");
////	 
////	  	  query.setParameter("username", username);
////	  try {
////			User user = (User) query.getSingleResult();
////			System.out.println(user.getPassword());
////			if(password.equals(user.getPassword())) {
////				return user;
////			}else {		
////				return new User();
////			}
////		}catch(Exception e){
////			System.out.println(e.getMessage());
////			User user = new User();
////			return user;
////		}
////	  
////	  
////  }
//  
//// @Transactional
////	public boolean userExists(String username) {
////		Query query = sessionFactory.getCurrentSession().createQuery("from CUSTOMER where username = :username");
////		query.setParameter("username",username);
////		return !query.getResultList().isEmpty();
////	}
//  
//  
//  
//  
//  
//  
//  
//  
//  
//}