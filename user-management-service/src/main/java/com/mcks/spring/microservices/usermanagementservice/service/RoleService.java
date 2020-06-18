package com.mcks.spring.microservices.usermanagementservice.service;

import java.util.List;

import com.mcks.spring.microservices.usermanagementservice.model.Role;

public interface RoleService {
    
    List<Role> getAllRoles();

}