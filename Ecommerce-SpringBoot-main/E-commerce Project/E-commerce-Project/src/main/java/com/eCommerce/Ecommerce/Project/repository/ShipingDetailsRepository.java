package com.eCommerce.Ecommerce.Project.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eCommerce.Ecommerce.Project.models.ShipingDetails;
@Repository
public interface ShipingDetailsRepository extends JpaRepository<ShipingDetails, UUID> {

}
