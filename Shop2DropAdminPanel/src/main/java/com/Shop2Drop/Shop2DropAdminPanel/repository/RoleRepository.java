package com.Shop2Drop.Shop2DropAdminPanel.repository;


import com.Shop2Drop.Shop2DropAdminPanel.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
Role findByName(String name);
}
