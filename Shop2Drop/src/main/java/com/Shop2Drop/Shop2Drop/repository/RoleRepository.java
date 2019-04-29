package com.Shop2Drop.Shop2Drop.repository;

import com.Shop2Drop.Shop2Drop.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
Role findByName(String name);
}
