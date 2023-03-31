package com.neoris.service;

import com.neoris.entity.User;
import com.neoris.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public List<User> findAllUser() {
        return userRepository.findAllUser();
    }
}
