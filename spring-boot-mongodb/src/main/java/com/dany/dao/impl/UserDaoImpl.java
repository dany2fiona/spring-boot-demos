package com.dany.dao.impl;

import com.dany.dao.UserDao;
import com.dany.entity.UserEntity;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(UserEntity user) {
        mongoTemplate.save(user);
    }

    @Override
    public List<UserEntity> findAll() {
        return mongoTemplate.findAll(UserEntity.class);
    }

    @Override
    public UserEntity findUserByUserName(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        UserEntity user = mongoTemplate.findOne(query,UserEntity.class);
        return user;
    }

    @Override
    public int updateUser(UserEntity user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("UserName",user.getUserName()).set("passWord",user.getPassWord());
        WriteResult result = mongoTemplate.updateFirst(query,update,UserEntity.class);
        if(result!=null){
            return result.getN();
        }
        return 0;
    }

    @Override
    public void deleteUserById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,UserEntity.class);
    }
}
