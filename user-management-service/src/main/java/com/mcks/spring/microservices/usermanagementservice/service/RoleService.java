package com.mcks.spring.microservices.usermanagementservice.service;

import java.util.List;
import java.util.Optional;

import com.mcks.spring.microservices.usermanagementservice.document.Role;

public interface RoleService {
    
    List<Role> getAllRoles();

    List<Role> getAllRolesByList(final List<Integer> roleIds);

    Optional<Role> getRole(final Integer roleId);

}