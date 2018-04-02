package me.hao0.graphql.practice.repository;

import com.google.common.collect.Lists;
import me.hao0.graphql.practice.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

/**
 * Author : haolin
 * Email  : haolin.h0@gmail.com
 */
@Repository
public class UserRepository {

    private static final Random r = new Random();

    public User getById(Long id){
        User u = new User();
        u.setId(id);
        u.setName("name" + id);
        u.setAge(r.nextInt());
        return u;
    }

    public List<User> getUsers(){
        return Lists.newArrayList(
            new User(1L, "user1", 22),
            new User(2L, "user2", 23)
        );
    }
}
