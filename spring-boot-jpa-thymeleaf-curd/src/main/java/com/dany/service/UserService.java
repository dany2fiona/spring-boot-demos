package com.dany.service;

import com.dany.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getUserList();

    public User findUserById(long id);

    public List<User> getUserList(int state);

    public void save(User user);

    public void edit(User user);

    public void delete(long id);

}
