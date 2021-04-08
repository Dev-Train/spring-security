package com.spring.security.domain.entity.security;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: Role
 * Inside the package - com.spring.security.domain.entity.security
 * Created Date: 3/27/2021
 * Created Time: 4:14 PM
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long roleId;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Singular
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST},fetch = FetchType.EAGER)
    @JoinTable(name = "ROLE_AUTHORITY",
            joinColumns = {@JoinColumn(name = "ROLE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID")})
    private Set<Authority> authorities;
}
