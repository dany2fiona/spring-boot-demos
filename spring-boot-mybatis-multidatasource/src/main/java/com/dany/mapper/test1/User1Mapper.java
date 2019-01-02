package com.dany.mapper.test1;

import com.dany.entity.UserEntity;
import com.dany.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface User1Mapper {
    List<UserEntity> getAll();

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);

}