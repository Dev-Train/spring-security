package com.spring.security.services.security;

import com.spring.security.domain.entity.security.Role;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: RoleService
 * Inside the package - com.spring.security.services.security
 * Created Date: 3/27/2021
 * Created Time: 5:26 PM
 **/
public interface RoleService {

    Optional<Role> getRoleById(Long roleId);
    Optional<Role> getRoleByName(String roleName);
    Set<Role> getRoles();
    Role createRole(Role role);
    void createRoles(List<Role> roles);
}
