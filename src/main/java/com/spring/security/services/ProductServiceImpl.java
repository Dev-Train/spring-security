package com.spring.security.services;

import com.spring.security.domain.entity.Product;
import com.spring.security.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: ProductServiceImpl
 * Inside the package - com.spring.security.services
 * Created Date: 3/27/2021
 * Created Time: 6:56 AM
 **/
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }
}
