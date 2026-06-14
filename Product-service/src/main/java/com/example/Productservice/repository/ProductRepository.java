package com.example.Productservice.repository;

import com.example.Productservice.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query
    Optional<Product> findByName(String name);
}
