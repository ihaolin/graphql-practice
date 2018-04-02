package me.hao0.graphql.practice.graphql.fetchers;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import me.hao0.graphql.practice.model.User;
import me.hao0.graphql.practice.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Author : haolin
 * Email  : haolin.h0@gmail.com
 */
@Component
public class UserFetcher implements DataFetcher<User> {

    @Resource
    private UserService userService;

    @Override
    public User get(DataFetchingEnvironment env) {
        Map args = env.getArguments();
        return userService.get(Long.valueOf(String.valueOf(args.get("id"))));
    }
}
