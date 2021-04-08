package com.spring.security.domain.entity.security;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Objects;
import java.util.Set;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: Authority
 * Inside the package - com.spring.security.domain.entity.security
 * Created Date: 3/19/2021
 * Created Time: 5:57 AM
 **/
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Authority {

    @Id
    @GeneratedValue
    private Long authorityId;

    private String permission;

    @ManyToMany(mappedBy = "authorities")
    private Set<Role> roles;
}
