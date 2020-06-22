package com.mcks.spring.microservices.usermanagementservice.service.impl;

import java.util.List;
import java.util.Optional;

import com.mcks.spring.microservices.usermanagementservice.document.Role;
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

    @Override
    public List<Role> getAllRolesByList(final List<Integer> roleIds) {
        return (List<Role>) roleRepository.findAllById(roleIds);
    }

    @Override
    public Optional<Role> getRole(final Integer roleId) {
        return roleRepository.findById(roleId);
    }
    
}