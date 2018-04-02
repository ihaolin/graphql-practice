package me.hao0.graphql.practice.service.impl;

import me.hao0.graphql.practice.model.User;
import me.hao0.graphql.practice.repository.UserRepository;
import me.hao0.graphql.practice.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : haolin
 * Email  : haolin.h0@gmail.com
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User get(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> gets() {
        return userRepository.getUsers();
    }
}
