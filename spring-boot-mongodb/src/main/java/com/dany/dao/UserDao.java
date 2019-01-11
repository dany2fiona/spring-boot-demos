package com.dany.dao;

import com.dany.entity.UserEntity;

import java.util.List;

public interface UserDao {

    public void saveUser(UserEntity user);

    public List<UserEntity> findAll();

    public UserEntity findUserByUserName(String userName);

    public int updateUser(UserEntity user);

    public void deleteUserById(Long id);
}
