package com.spring.security.controllers;

import com.spring.security.domain.entity.Product;
import com.spring.security.services.ProductService;
import com.spring.security.services.security.permissions.product.ProductCreatePermission;
import com.spring.security.services.security.permissions.product.ProductReadPermission;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: ProductController
 * Inside the package - com.spring.security.controllers
 * Created Date: 3/27/2021
 * Created Time: 6:59 AM
 **/
@RestController
@RequestMapping("/api/v1/security/product/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    //@Secured({"ROLE_ADMIN","ROLE_CUSTOMER"})
    @ProductReadPermission
    @GetMapping
    public ResponseEntity getProducts(){
        List<Product> products = productService.getProducts();
        return new ResponseEntity(products, HttpStatus.OK);
    }

    //@Secured({"ROLE_ADMIN","ROLE_CUSTOMER"})
    @ProductReadPermission
    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable Long id){
        Optional<Product> product = productService.getProductById(id);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @ProductCreatePermission
    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product){
        productService.createProduct(product);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
