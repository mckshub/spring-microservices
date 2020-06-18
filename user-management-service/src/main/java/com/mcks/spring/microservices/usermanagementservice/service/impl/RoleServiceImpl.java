package com.mcks.spring.microservices.usermanagementservice.service.impl;

import java.util.List;

import com.mcks.spring.microservices.usermanagementservice.model.Role;
import com.mcks.spring.microservices.usermanagementservice.repository.RoleRepository;
import com.mcks.spring.microservices.usermanagementservice.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    
}