package org.example.primerproyecto.service;

import org.example.primerproyecto.entity.User;

public interface UserService {

    User findByEmail(String email);

    User createUser(User user);
}
