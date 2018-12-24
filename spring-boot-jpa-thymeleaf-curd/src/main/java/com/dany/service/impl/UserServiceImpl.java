package com.dany.service.impl;

import com.dany.entity.User;
import com.dany.repository.UserRepository;
import com.dany.service.UserService;
import com.dany.utils.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getUserList(int state) {
        return userRepository.findAllByStateEquals(0);
    }

    @Override
    public void save(User user) {
        logger.debug("dan.y:"+user.toString());
        user.setRegTime(Timer.getCurrentTime());
        logger.debug("dan.y:"+user.toString());
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        logger.debug("dan.y:"+user.toString());
        user.setRegTime(Timer.getCurrentTime());
        logger.debug("dan.y:"+user.toString());
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        User user = findUserById(id);
        logger.debug("dan.y:"+user.toString());
        user.setState(1);
        user.setCancleTime(Timer.getCurrentTime());
        logger.debug("dan.y:"+user.toString());
        userRepository.save(user);
//        userRepository.deleteById(id);
    }
}
