package com.dany.mapper.test2;


import com.dany.entity.UserEntity;
import com.dany.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface User2Mapper {
    List<UserEntity> getAll();

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);

}