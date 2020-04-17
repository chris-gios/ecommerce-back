package com.chriscorp.ecommerce.service.serviceImpl;

import com.chriscorp.ecommerce.model.User;
import com.chriscorp.ecommerce.repository.UserRepository;
import com.chriscorp.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User postUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User putUser(User user){
        return userRepository.save(user);
    }
}
