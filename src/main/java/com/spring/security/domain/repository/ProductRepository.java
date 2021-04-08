package com.spring.security.domain.repository;

import com.spring.security.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: ProductRepository
 * Inside the package - com.spring.security.domain.repository
 * Created Date: 3/27/2021
 * Created Time: 6:49 AM
 **/
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
