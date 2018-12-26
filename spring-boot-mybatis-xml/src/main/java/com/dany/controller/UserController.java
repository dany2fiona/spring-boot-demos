package com.dany.controller;

import com.dany.entity.UserEntity;
import com.dany.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<UserEntity> getUsers(){
        return userMapper.getAll();
    }

    @RequestMapping("/getUser")
    public UserEntity getUser(Long id){
        return userMapper.getOne(id);
    }

    @RequestMapping("/add")
    public String save(UserEntity user){
        userMapper.insert(user);
        return "add success";
    }

    @RequestMapping(value = "update")
    public String update(UserEntity user){
        userMapper.update(user);
        return "modify success";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userMapper.delete(id);
        return "delete success";
    }

}
