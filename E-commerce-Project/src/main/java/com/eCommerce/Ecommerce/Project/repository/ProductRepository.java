package com.eCommerce.Ecommerce.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eCommerce.Ecommerce.Project.models.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer >{

}
