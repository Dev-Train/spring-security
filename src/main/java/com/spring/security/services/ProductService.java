package com.spring.security.services;

import com.spring.security.domain.entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: ProductService
 * Inside the package - com.spring.security.services
 * Created Date: 3/27/2021
 * Created Time: 6:50 AM
 **/
public interface ProductService {

    Optional<Product> getProductById(Long id);

    List<Product> getProducts();

    void createProduct(Product product);
}
