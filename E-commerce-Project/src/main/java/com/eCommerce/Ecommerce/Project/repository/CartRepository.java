package com.eCommerce.Ecommerce.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eCommerce.Ecommerce.Project.models.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
