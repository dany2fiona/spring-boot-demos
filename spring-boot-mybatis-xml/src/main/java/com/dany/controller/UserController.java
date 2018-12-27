package com.dany.controller;

import com.dany.entity.UserEntity;
import com.dany.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//http://localhost:8080/swagger-ui.html
@Api(value = "用户controller",tags = {"用户接口"},description = "用户操作接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "查询所有用户",notes = "查询所有用户")
    @RequestMapping(value = "/getUsers",method = RequestMethod.POST)
    public List<UserEntity> getUsers(){
        return userMapper.getAll();
    }

    @ApiOperation(value = "查询用户",notes = "查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户标识",required = true,paramType = "query",dataType = "long")
    })
    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    public UserEntity getUser(Long id){
        return userMapper.getOne(id);
    }

    @ApiOperation(value = "新增用户",notes = "新增注册")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String save(UserEntity user){
        userMapper.insert(user);
        return "add success";
    }

    @ApiOperation(value = "修改用户",notes = "修改用户")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(UserEntity user){
        userMapper.update(user);
        return "modify success";
    }

    @ApiOperation(value = "删除用户",notes = "删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户标识",required = true,paramType = "query",dataType = "long")
    })
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
//    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)  浏览器方式
//    public String delete(@PathVariable("id") Long id){
    public String delete(Long id){
        userMapper.delete(id);
        return "delete success";
    }

}
