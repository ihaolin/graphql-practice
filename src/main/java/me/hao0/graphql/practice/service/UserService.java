package me.hao0.graphql.practice.service;

import me.hao0.graphql.practice.model.User;

import java.util.List;

/**
 * Author : haolin
 * Email  : haolin.h0@gmail.com
 */
public interface UserService {

    User get(Long id);

    List<User> gets();
}
