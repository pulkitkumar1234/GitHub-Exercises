package com.Shop2Drop.Shop2DropAdminPanel.service;

import com.Shop2Drop.Shop2DropAdminPanel.entity.User;
import com.Shop2Drop.Shop2DropAdminPanel.entity.UserRole;
import com.Shop2Drop.Shop2DropAdminPanel.security.PasswordResetToken;

import java.util.Set;

public interface UserService  {
    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User save(User user);
}
