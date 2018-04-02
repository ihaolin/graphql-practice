package me.hao0.graphql.practice.controller;

import me.hao0.graphql.practice.model.HttpResponse;
import me.hao0.graphql.practice.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author : haolin
 * Email  : haolin.h0@gmail.com
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HttpResponse get(@PathVariable("id") Long id){
        return HttpResponse.ok(userService.get(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public HttpResponse gets(){
        return HttpResponse.ok(userService.gets());
    }
}
