package com.dany;

import com.dany.dao.UserDao;
import com.dany.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSaveUser() throws Exception{
        UserEntity user = new UserEntity();
        user.setId(2l);
        user.setUserName("小明");
        user.setPassWord("123456");
        userDao.saveUser(user);
    }

    @Test
    public void testFindAll(){
        List<UserEntity> users = userDao.findAll();
        for (UserEntity user:users){
            System.out.println("user is "+user);
        }
    }

    @Test
    public void findUserByUserName(){
        UserEntity user = userDao.findUserByUserName("小明");
        System.out.println("user is "+user);
    }

    @Test
    public void updateUser(){
        UserEntity user = new UserEntity();
        user.setId(2l);
        user.setUserName("小红");
        user.setPassWord("888888");
        userDao.updateUser(user);
    }

    @Test
    public void deleteUserById(){
        userDao.deleteUserById(2l);
    }
}
