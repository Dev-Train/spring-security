package com.spring.security.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: Product
 * Inside the package - com.spring.security.domain.entity
 * Created Date: 3/27/2021
 * Created Time: 6:47 AM
 **/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String productName;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
