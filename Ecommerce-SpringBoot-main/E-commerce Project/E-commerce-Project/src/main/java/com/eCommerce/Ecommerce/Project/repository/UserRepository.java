package com.eCommerce.Ecommerce.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eCommerce.Ecommerce.Project.models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
