package com.spring.security.domain.repository;

import com.spring.security.domain.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: RoleRepository
 * Inside the package - com.spring.security.domain.repository
 * Created Date: 3/27/2021
 * Created Time: 4:25 PM
 **/
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findRoleByName(String roleName);
}
