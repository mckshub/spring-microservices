package com.mcks.spring.microservices.roleservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcks.spring.microservices.roleservice.document.Role;
import com.mcks.spring.microservices.roleservice.repository.RoleRepository;
import com.mcks.spring.microservices.roleservice.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public List<Role> getAllRolesByList(List<String> roleCodes) {
		LOGGER.info("Roles codes obtained from RequestVO : {}", roleCodes);

		List<Role> roles = new ArrayList<>();
		roleCodes.forEach(roleCode -> {
			Role role = getRole(roleCode).get();
			roles.add(role);
		});

		return roles;
	}

	@Override
	public Optional<Role> getRole(String code) {
		return roleRepository.findByRoleCode(code);
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> saveAll(List<Role> roles) {
		return roleRepository.saveAll(roles);
	}

}