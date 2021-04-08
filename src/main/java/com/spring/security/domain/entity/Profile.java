package com.spring.security.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: Profile
 * Inside the package - com.spring.security.domain.entity
 * Created Date: 3/29/2021
 * Created Time: 6:26 AM
 **/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Profile {

    @Id
    @GeneratedValue
    private Long profileId;

    private String paymentName;

    private String favoriteVacationDestination;

    @OneToOne
    @JsonBackReference
    private Customer customer;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
