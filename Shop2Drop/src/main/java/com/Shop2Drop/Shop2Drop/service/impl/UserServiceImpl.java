package com.Shop2Drop.Shop2Drop.service.impl;

import com.Shop2Drop.Shop2Drop.entity.User;
import com.Shop2Drop.Shop2Drop.entity.UserRole;
import com.Shop2Drop.Shop2Drop.repository.PasswordResetTokenRepository;
import com.Shop2Drop.Shop2Drop.repository.RoleRepository;
import com.Shop2Drop.Shop2Drop.repository.UserRepository;
import com.Shop2Drop.Shop2Drop.security.PasswordResetToken;
import com.Shop2Drop.Shop2Drop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG= LoggerFactory.getLogger(UserService.class);

    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Override
    public PasswordResetToken getPasswordResetToken(String token) {
        return passwordResetTokenRepository.findByToken(token);
    }

    @Override
    public void createPasswordResetTokenForUser(final User user, final String token) {
        final PasswordResetToken myToken=new PasswordResetToken(token,user);
        passwordResetTokenRepository.save(myToken);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    @Override
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception{
        User localUser=userRepository.findByUsername(user.getUsername());
        if(localUser!=null){
           LOG.info("user {} Already Exists,Nothing Will Be Done",user.getUsername());
        }else {
            for(UserRole ur:userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            localUser=userRepository.save(user);
        }
        return localUser;
    }

    @Override
    public User save(User user){
        return userRepository.save(user);
    }
}
