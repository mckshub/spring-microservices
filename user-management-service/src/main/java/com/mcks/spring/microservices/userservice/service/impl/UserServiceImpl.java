package com.mcks.spring.microservices.userservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcks.spring.microservices.userservice.document.User;
import com.mcks.spring.microservices.userservice.model.UserRequestVO;
import com.mcks.spring.microservices.userservice.model.UserResponseVO;
import com.mcks.spring.microservices.userservice.proxy.category.Category;
import com.mcks.spring.microservices.userservice.proxy.category.CategoryRequestModel;
import com.mcks.spring.microservices.userservice.proxy.category.CategoryResponseModel;
import com.mcks.spring.microservices.userservice.proxy.category.ICategoryServiceProxy;
import com.mcks.spring.microservices.userservice.proxy.role.IRoleServiceProxy;
import com.mcks.spring.microservices.userservice.proxy.role.Role;
import com.mcks.spring.microservices.userservice.proxy.role.RoleResponseModel;
import com.mcks.spring.microservices.userservice.repository.UserRepository;
import com.mcks.spring.microservices.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IRoleServiceProxy roleServiceProxy;

	@Autowired
	private ICategoryServiceProxy categoryServiceProxy;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUser(String userName) {
		return userRepository.findById(userName);
	}

	@Override
	public User authenticateUser(User user) {
		return null;
	}

	@Override
	public boolean checkUserExists(String userName) {
		return userName.equalsIgnoreCase(getUser(userName).orElse(new User()).getUserName());
	}

	@Override
	public UserResponseVO saveUser(User user, String roleCode, List<String> categoryCodes) {
		UserResponseVO responseVO = new UserResponseVO();
		if (!checkUserExists(user.getUserName())) {
			setRoleForUser(user, roleCode);
			setCategoriesForUser(user, categoryCodes);
			User savedUser = userRepository.save(user);
			responseVO.setUser(savedUser);
			responseVO.setStatus(true);
			responseVO.setStatusMessage("User details saved successfully !");
		} else {
			responseVO.setUserAlreadyExists(true);
			responseVO.setStatus(false);
			responseVO.setStatusMessage("User already exists");
		}
		return responseVO;
	}

	@SuppressWarnings("unchecked")
	private void setCategoriesForUser(User user, List<String> categoryCodes) {
		CategoryResponseModel categoryResponse = categoryServiceProxy
				.getAllCategoriesByIds(new CategoryRequestModel(null, null, categoryCodes));
		List<Category> categoriesToSave = ((List<Category>) categoryResponse.getResultObject());
		user.setCategories(categoriesToSave);
	}

	private void setRoleForUser(User user, String roleCode) {
		RoleResponseModel roleResponse = roleServiceProxy.getRoleById(roleCode);
		user.setRole(new ObjectMapper().convertValue(roleResponse.getResultObject(), Role.class));
	}

	@Override
	public UserResponseVO modifyUser(UserRequestVO requestVO) {
		return null;
	}

}
