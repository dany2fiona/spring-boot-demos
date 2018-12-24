package com.dany.repository;

import com.dany.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findById(long id);

    Long deleteById(long id);

    List<User> findAllByStateEquals(int state);
}
