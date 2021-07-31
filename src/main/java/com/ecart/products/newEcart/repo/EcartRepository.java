package com.ecart.products.newEcart.repo;

import com.ecart.products.newEcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcartRepository extends JpaRepository<Product, Integer> {
}
