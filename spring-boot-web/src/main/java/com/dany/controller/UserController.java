package com.dany.controller;

import com.dany.domain.User;
import com.dany.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController注解能够使项目支持Rest
@RestController
//表示该controller类下所有的方法都公用的一级上下文路径
@RequestMapping(value = "/springboot")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    //http://localhost:8080/springboot/getUser

    @RequestMapping("/getUser")
    @Cacheable(value = "user-key")
    public User getUser(){
        User user = userRepository.findByUserName("aa");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("/getUsers")
    @Cacheable(value = "key-Users")
    public List<User> getUsers(){
        List<User> users = userRepository.findAll();
        User user = userRepository.findByUserName("aa");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return users;
    }

}
