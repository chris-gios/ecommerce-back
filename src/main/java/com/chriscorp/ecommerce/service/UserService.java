package com.chriscorp.ecommerce.service;

import com.chriscorp.ecommerce.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUser();

    Optional<User> getUserById(long id);

    void deleteUserById(long id);

    User create(User user) throws Exception;

    User putUser(User user);

    User findUserByUserName(String username);

}
