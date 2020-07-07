package com.mcks.spring.microservices.userservice.service.impl;

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
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
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

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean checkUserExists(String userName) {
        return userName.equalsIgnoreCase(getUser(userName).orElse(new User()).getUsername());
    }

    @Override
    public UserResponseVO saveUser(User user, String roleCode, List<String> categoryCodes) {
        UserResponseVO responseVO = new UserResponseVO();
        if (!checkUserExists(user.getUsername())) {
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
        List<Category> distinctCategoriesToSave = categoriesToSave.stream().distinct().collect(Collectors.toList());
        user.setCategories(distinctCategoriesToSave);
    }

    private void setRoleForUser(User user, String roleCode) {
        RoleResponseModel roleResponse = roleServiceProxy.getRoleById(roleCode);
        user.setRole(new ObjectMapper().convertValue(roleResponse.getResultObject(), Role.class));

    }

    @Override
    public UserResponseVO modifyUser(UserRequestVO requestVO) {
        UserResponseVO responseVO = new UserResponseVO();
        if (requestVO != null) {
            User user = requestVO.getUser();
            if (checkUserExists(requestVO.getUser().getUsername())) {
                setRoleForUser(user, requestVO.getRoleCode());
                setCategoriesForUser(user, requestVO.getCategoryCodes());
                User savedUser = userRepository.save(user);
                responseVO.setUser(savedUser);
                responseVO.setStatus(true);
                responseVO.setStatusMessage("User details modified successfully !");
            } else {
                responseVO.setUserAlreadyExists(false);
                responseVO.setStatus(false);
                responseVO.setStatusMessage("User does not exists !");
            }
        } else {
            responseVO.setUserAlreadyExists(false);
            responseVO.setStatus(false);
            responseVO.setStatusMessage("No Request Data found for processing !");
        }
        return responseVO;
    }

    @Override
    public User authenticateUser(String username) throws Exception {
        if (checkUserExists(username)) {
            User userFromDB = getUser(username).orElse(new User());
            return userFromDB;
        } else {
            throw new Exception("User Not Found !");
        }
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userFromDB = authenticateUser(username);
        LOGGER.info("UserServiceImpl.class ==> User Details Fetched from DB : " + userFromDB.toString());
         org.springframework.security.core.userdetails.User user =
                 new org.springframework.security.core.userdetails.User(userFromDB.getUsername(), userFromDB.getPassword(), new ArrayList<>());
        LOGGER.info("UserServiceImpl.class ==> User object retrieved for Spring Security : " + user.toString());
        return user;
    }
}
