package com.Shop2Drop.Shop2Drop.service;

import com.Shop2Drop.Shop2Drop.entity.User;
import com.Shop2Drop.Shop2Drop.entity.UserRole;
import com.Shop2Drop.Shop2Drop.security.PasswordResetToken;

import java.util.Set;

public interface UserService  {
    PasswordResetToken getPasswordResetToken(final String token);
    void createPasswordResetTokenForUser(final User user,final String token);
    User findByUsername(String username);
    User findByEmail(String email);
    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User save(User user);
}
