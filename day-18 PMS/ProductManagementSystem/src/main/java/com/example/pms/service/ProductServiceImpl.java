package com.example.pms.service;

import com.example.pms.entity.Product;
import com.example.pms.exception.ProductNotFoundException;
import com.example.pms.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of ProductService using constructor injection and Spring Data JPA.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    /**
     * Constructor injection for ProductRepository.
     * Field injection is intentionally avoided per project requirements.
     */
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProductById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
    }

    @Override
    public Product updateProduct(Integer id, Product productDetails) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));

        existingProduct.setProductName(productDetails.getProductName());
        existingProduct.setProductPrice(productDetails.getProductPrice());
        existingProduct.setProductQuantity(productDetails.getProductQuantity());

        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProductById(Integer id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }
        productRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProductByName(String name) {
        return productRepository.findByProductName(name)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with name: " + name));
    }

    @Override
    public void deleteProductByName(String name) {
        int deletedCount = productRepository.deleteByProductName(name);
        if (deletedCount == 0) {
            throw new ProductNotFoundException("Product not found with name: " + name);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProductsByQuantity(Integer quantity) {
        return productRepository.findByProductQuantity(quantity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice) {
        return productRepository.findByProductPriceBetween(minPrice, maxPrice);
    }

    @Override
    @Transactional(readOnly = true)
    public long countProducts() {
        return productRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Double getTotalPrice() {
        Double total = productRepository.getTotalPriceSum();
        return total != null ? total : 0.0;
    }
}
