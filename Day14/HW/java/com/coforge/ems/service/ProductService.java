package com.coforge.ems.service;

import com.coforge.ems.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private Map<Integer, Product> productDatabase = new HashMap<>();

    public boolean createProduct(Product product) {
        if (productDatabase.containsKey(product.getProductId())) {
            return false;
        }
        productDatabase.put(product.getProductId(), product);
        return true;
    }

    public boolean updateProduct(Product product) {
        if (productDatabase.containsKey(product.getProductId())) {
            productDatabase.put(product.getProductId(), product);
            return true;
        }
        return false;
    }

    public boolean deleteProduct(Integer id) {
        if (productDatabase.containsKey(id)) {
            productDatabase.remove(id);
            return true;
        }
        return false;
    }

    public Product findProduct(Integer id) {
        return productDatabase.get(id);
    }

    public List<Product> findAllProducts() {
        return new ArrayList<>(productDatabase.values());
    }

}
