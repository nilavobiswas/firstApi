package com.rest.api.firstapi.repositories;

import com.rest.api.firstapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
