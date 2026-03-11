package com.proyecto.daw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.daw.model.User;
import com.proyecto.daw.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findSqlAll();
    }

    public User findById(int id) {
        return userRepository.findSqlById(id);
    }

    public Long count() {
        return userRepository.count();
    }

    public List<User> findByNameContaining(String name) {
        return userRepository.findByNameContaining(name);
    }
}
