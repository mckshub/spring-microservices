package com.mcks.spring.microservices.usermanagementservice.controller;

import java.util.List;
import java.util.Optional;

import com.mcks.spring.microservices.usermanagementservice.document.Role;
import com.mcks.spring.microservices.usermanagementservice.model.ResponseVO;
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
    public ResponseVO getAllRoles() {
        final ResponseVO responseVO = new ResponseVO();
        final List<Role> allRoles = roleService.getAllRoles();
        responseVO.setResultObject((Object) allRoles);
        return responseVO;                                                                                                                                                                                                                                                                                                                                  
    }

    @GetMapping(value="/getAllRolesByIds", produces = APPLICATION_JSON)
    public ResponseVO getAllRolesByIds(final List<Integer> roleIds) {
        final ResponseVO responseVO = new ResponseVO();
        final List<Role> allRoles = roleService.getAllRolesByList(roleIds);
        responseVO.setResultObject((Object) allRoles);
        responseVO.setStatus(true);
        responseVO.setStatusMessages("Success");
        return responseVO;
    }

    @GetMapping(value="/getRoleById", produces = APPLICATION_JSON)
    public ResponseVO getRoleById(final Integer roleId) {
        ResponseVO responseVO = new ResponseVO();
        Optional<Role> role =roleService.getRole(roleId);
        responseVO.setResultObject((Object) role);
        responseVO.setStatus(true);
        responseVO.setStatusMessages("Success");                                                                                                                                                                                                                                                                    
        return responseVO;
    }

}