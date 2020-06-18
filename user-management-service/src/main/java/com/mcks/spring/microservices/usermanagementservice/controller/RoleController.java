package com.mcks.spring.microservices.usermanagementservice.controller;

import java.util.List;

import com.mcks.spring.microservices.usermanagementservice.model.Role;
import com.mcks.spring.microservices.usermanagementservice.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class RoleController {
    
    private static final String APPLICATION_JSON = "application/json";

    @Autowired
    private RoleService roleService;

    @GetMapping(value="/getAllRoles", produces = APPLICATION_JSON)
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

}