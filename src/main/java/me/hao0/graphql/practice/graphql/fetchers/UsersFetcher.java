package me.hao0.graphql.practice.graphql.fetchers;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import me.hao0.graphql.practice.model.User;
import me.hao0.graphql.practice.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : haolin
 * Email  : haolin.h0@gmail.com
 */
@Component
public class UsersFetcher implements DataFetcher<List<User>> {

    @Resource
    private UserService userService;

    @Override
    public List<User> get(DataFetchingEnvironment env) {
        return userService.gets();
    }
}
