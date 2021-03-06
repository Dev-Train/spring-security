package com.spring.security.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.security.domain.entity.security.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: Customer
 * Inside the package - com.spring.security.domain.entity
 * Created Date: 3/15/2021
 * Created Time: 6:07 AM
 **/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Customer {

    @Id
    @GeneratedValue
    private Long customerId;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    @OneToOne(mappedBy = "customer",fetch = FetchType.EAGER)
    @JsonManagedReference
    private Profile profile;

    @OneToOne
    @JsonBackReference
    private User user;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
