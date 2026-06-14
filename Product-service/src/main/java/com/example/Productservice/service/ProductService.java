package com.example.Productservice.service;

import com.example.Productservice.models.Product;
import com.example.Productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void addProduct(Product product){
        productRepository.insert(product);
    }

    public void updateProduct(Product product){
        Product savedProduct = productRepository.findById(product.getId())
                .orElseThrow(()-> new RuntimeException(
                        String.format("Cannot find product by this ID ")
                ));
        savedProduct.setName(product.getName());
        savedProduct.setDescription(product.getDescription());
        savedProduct.setPrice(product.getPrice());

        productRepository.save(product);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product getProductByName(String name){
        return productRepository.findByName(name).orElseThrow(()-> new RuntimeException(
                String.format("Cannot find product by this name")
        ));
    }

    public void deleteProduct(String id ){
        productRepository.deleteById(id);
    }
}
