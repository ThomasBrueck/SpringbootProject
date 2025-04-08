package org.example.primerproyecto.service.impl;

import org.example.primerproyecto.entity.User;
import org.example.primerproyecto.repository.UserRepository;
import org.example.primerproyecto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }
}
