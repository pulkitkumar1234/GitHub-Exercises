package com.Shop2Drop.Shop2Drop.repository;

import com.Shop2Drop.Shop2Drop.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User,Long> {

    User findByUsername(String username);
    User findByEmail(String email);
}
