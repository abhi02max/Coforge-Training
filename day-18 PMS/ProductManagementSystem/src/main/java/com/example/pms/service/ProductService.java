package com.example.pms.service;

import com.example.pms.entity.Product;

import java.util.List;

/**
 * Service Interface for managing Product operations.
 */
public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Integer id);

    Product updateProduct(Integer id, Product product);

    void deleteProductById(Integer id);

    Product getProductByName(String name);

    void deleteProductByName(String name);

    List<Product> getProductsByQuantity(Integer quantity);

    List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice);

    long countProducts();

    Double getTotalPrice();
}
