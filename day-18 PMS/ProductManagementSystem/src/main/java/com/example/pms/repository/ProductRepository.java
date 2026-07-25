package com.example.pms.repository;

import com.example.pms.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA Repository for Product entity.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    /**
     * Find product by product name using JPQL @Query.
     */
    @Query("SELECT p FROM Product p WHERE p.productName = :productName")
    Optional<Product> findByProductName(@Param("productName") String productName);

    /**
     * Find products by quantity using JPQL @Query.
     */
    @Query("SELECT p FROM Product p WHERE p.productQuantity = :quantity")
    List<Product> findByProductQuantity(@Param("quantity") Integer quantity);

    /**
     * Find products whose price falls between minPrice and maxPrice.
     */
    @Query("SELECT p FROM Product p WHERE p.productPrice BETWEEN :minPrice AND :maxPrice")
    List<Product> findByProductPriceBetween(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);

    /**
     * Delete product by product name.
     */
    @Modifying
    @Query("DELETE FROM Product p WHERE p.productName = :productName")
    int deleteByProductName(@Param("productName") String productName);

    /**
     * Custom JPQL Query to compute total price sum of all products.
     */
    @Query("SELECT COALESCE(SUM(p.productPrice), 0.0) FROM Product p")
    Double getTotalPriceSum();
}
