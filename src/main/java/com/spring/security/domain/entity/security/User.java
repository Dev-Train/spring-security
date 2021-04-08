package com.spring.security.domain.entity.security;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.security.domain.entity.Customer;
import lombok.*;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: User
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
@Table(name = "SECURIY_USER")
public class User implements UserDetails, CredentialsContainer {

    @Id
    @GeneratedValue
    private Long userId;

    private String userName;

    private String password;

    @Singular
    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    private Set<Role> roles;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Customer customer;


    @Transient
    public Set<GrantedAuthority> getAuthorities(){
        return this.roles.stream()
                .map(Role :: getAuthorities)
                .flatMap(Set::stream)
                .map(authority -> {
                    return new SimpleGrantedAuthority(authority.getPermission());
                })
                .collect(Collectors.toSet());
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNotExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNotLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNotExpired();
    }


    @Builder.Default
    private boolean accountNotExpired = true;

    @Builder.Default
    private boolean accountNotLocked = true;

    @Builder.Default
    private boolean credentialsNotExpired = true;

    @Builder.Default
    private boolean enabled = true;

    @Override
    public void eraseCredentials() {
        this.password = null;
    }
}
