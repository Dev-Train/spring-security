package com.spring.security.services.security;

import com.spring.security.domain.entity.security.Role;
import com.spring.security.domain.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: RoleServiceImpl
 * Inside the package - com.spring.security.services.security
 * Created Date: 3/27/2021
 * Created Time: 5:29 PM
 **/
@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> getRoleById(Long roleId) {
        return roleRepository.findById(roleId);
    }

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        return roleRepository.findRoleByName(roleName);
    }

    @Override
    public Set<Role> getRoles() {
        return roleRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void createRoles(List<Role> roles) {
        roleRepository.saveAll(roles);
    }
}
