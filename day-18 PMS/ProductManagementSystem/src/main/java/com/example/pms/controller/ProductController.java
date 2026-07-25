package com.example.pms.controller;

import com.example.pms.entity.Product;
import com.example.pms.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST Controller exposing Product endpoints under base path /api/products.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    /**
     * Pure Constructor Injection for ProductService.
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * POST /api/products - Add a new Product
     */
    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    /**
     * GET /api/products - Get all Products
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * GET /api/products/{id} - Get Product by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    /**
     * PUT /api/products/{id} - Update an existing Product
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @Valid @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * DELETE /api/products/{id} - Delete Product by ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteProductById(@PathVariable Integer id) {
        productService.deleteProductById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Product deleted successfully with ID: " + id);
        return ResponseEntity.ok(response);
    }

    /**
     * GET /api/products/name/{name} - Search Product by Name
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        Product product = productService.getProductByName(name);
        return ResponseEntity.ok(product);
    }

    /**
     * DELETE /api/products/name/{name} - Delete Product by Name
     */
    @DeleteMapping("/name/{name}")
    public ResponseEntity<Map<String, String>> deleteProductByName(@PathVariable String name) {
        productService.deleteProductByName(name);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Product deleted successfully with name: " + name);
        return ResponseEntity.ok(response);
    }

    /**
     * GET /api/products/quantity/{quantity} - Filter Products by Quantity
     */
    @GetMapping("/quantity/{quantity}")
    public ResponseEntity<List<Product>> getProductsByQuantity(@PathVariable Integer quantity) {
        List<Product> products = productService.getProductsByQuantity(quantity);
        return ResponseEntity.ok(products);
    }

    /**
     * GET /api/products/pricerange?min=100&max=500 - Filter Products by Price Range
     */
    @GetMapping("/pricerange")
    public ResponseEntity<List<Product>> getProductsByPriceRange(
            @RequestParam("min") Double minPrice,
            @RequestParam("max") Double maxPrice) {
        List<Product> products = productService.getProductsByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(products);
    }

    /**
     * GET /api/products/count - Return total count of products
     */
    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> countProducts() {
        long count = productService.countProducts();
        Map<String, Long> response = new HashMap<>();
        response.put("totalProducts", count);
        return ResponseEntity.ok(response);
    }

    /**
     * GET /api/products/totalprice - Return sum of all product prices
     */
    @GetMapping("/totalprice")
    public ResponseEntity<Map<String, Double>> getTotalPrice() {
        Double totalPrice = productService.getTotalPrice();
        Map<String, Double> response = new HashMap<>();
        response.put("totalPrice", totalPrice);
        return ResponseEntity.ok(response);
    }
}
