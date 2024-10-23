package com.eCommerce.Ecommerce.Project.services;

import java.util.ArrayList;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eCommerce.Ecommerce.Project.models.User;
//import com.eCommerce.Ecommerce.Project.repository.UserDao;
//import com.eCommerce.Ecommerce.Project.repository.UserRepository;
//import com.example.BankProjekt.Programmer.Programmer;

@Service
public class UserService {
	
	
	
	private static List<User> users= new ArrayList<User>();
	private static int userCount=0;
	private User newUser;
	static {
		users.add(new User(++userCount,"admin" , "admin@gmail.com", "123", "ROLE_ADMIN", "Tirana, Albania"));
		users.add(new User(++userCount,"Arjol" , "arjol@gmail.com", "123", "ROLE_NORMAL", "Tirana, Albania"));
		
	}
	
	public String getUsername(String username) {
		for(User user: users) {
			if(user.getUsername().equals(username))
				return username;
		}
		return null;
	}
	public String getPassword(String password) {
		for(User user: users) {
			if(user.getPassword().equals(password))
				return password;
		}
		return null;
	}
	
	public List<User> getUsers(){
		return users;
	}
	
	public void  addUser(User user) {
		user.setId(++userCount);
		users.add(user);
	}
	
	public User checkLogin(String username , String password) {
		for(User user: users) {
			if(user.getUsername().equals(username) 
					&& user.getPassword().equals(password)) {
				return user;
			}
		};
		return null;
	}
	
	public Boolean checkUserExists(String username, String email) {
	    for (User user: users) {
	        if (user.getUsername().equals(username) || user.getEmail().equals(email)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	

	
	public User findUserById(int id) {
		for(User user: users) {
			if(id==user.getId())
				return user;
		}
		return null;
	}
	
	
	public void deleteById(int id) {
    	Predicate<? super User>predicate =user->
    	user.getId()==id;
    	users.removeIf(predicate);
    }
	
	public void updateUser(User user) {
		deleteById(user.getId());
		users.add(user);
	}
	
	
	
	
	public User getUser(String username) {
		for(User user:users) {
			if(user.getUsername().equals(username))
				return user;
		}
		
		return null;
	}
	
	public void postUser(User user) {
		newUser=user;
		
	}
	
	public User getUser() {
		return newUser;
		
	}
	
	public void logout() {
		newUser=null;
	}
	
	
	public void updateUserProfile(User user) {
		deleteById(user.getId());
		users.add(user);
	}
	
	
	 public  boolean changePassword( String currentPassword, String newPassword, String newPassword2) {
	       
	            if (newUser.getPassword().equals(currentPassword)) {
	                if(newPassword.equals(newPassword2)) {
	                newUser.setPassword(newPassword);
	                return true;
	                }
	            }
	        
	        return false; 
	    }
	
	public List<User> getAllUsers(){
		return users;
	}
	
	
	

	
	

}
