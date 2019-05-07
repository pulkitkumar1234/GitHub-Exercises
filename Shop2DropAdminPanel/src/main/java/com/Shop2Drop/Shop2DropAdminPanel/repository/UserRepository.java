package com.Shop2Drop.Shop2DropAdminPanel.repository;


import com.Shop2Drop.Shop2DropAdminPanel.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User,Long> {

    User findByUsername(String username);

}
