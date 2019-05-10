package com.Shop2Drop.Shop2Drop.service.impl;

import com.Shop2Drop.Shop2Drop.entity.*;
import com.Shop2Drop.Shop2Drop.repository.*;
import com.Shop2Drop.Shop2Drop.security.PasswordResetToken;
import com.Shop2Drop.Shop2Drop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Autowired
    UserPaymentRepository userPaymentRepository;

    @Autowired
    UserShippingRepository userShippingRepository;



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

    @Override
    public void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user){
        userPayment.setUser(user);
        userPayment.setUserBilling(userBilling);
        userPayment.setDefaultPayment(true);
        userBilling.setUserPayment(userPayment);
        user.getUserPaymentList().add(userPayment);
        save(user);
    }
    @Override
    public void setUserDefaultPayment(Long userPaymentId, User user){
        List<UserPayment> userPaymentList= (List<UserPayment>) userPaymentRepository.findAll();

        for(UserPayment userPayment:userPaymentList){
            if(userPayment.getId()==userPaymentId){
                userPayment.setDefaultPayment(true);
                userPaymentRepository.save(userPayment);
            }else {
                userPayment.setDefaultPayment(false);
                userPaymentRepository.save(userPayment);
            }
        }
    }

    @Override
    public void updateUserShipping(UserShipping userShipping, User user){

        userShipping.setUser(user);
        userShipping.setUserShippingDefault(true);
        user.getUserShippingList().add(userShipping);
        save(user);

    }
    @Override
    public void setUserDefaultShipping(Long userShippingId,User user){
        List<UserShipping> userShippingList= (List<UserShipping>) userShippingRepository.findAll();

        for(UserShipping userShipping:userShippingList){
            if(userShipping.getId()==userShippingId){
                userShipping.setUserShippingDefault(true);
                userShippingRepository.save(userShipping);
            }else {
                userShipping.setUserShippingDefault(false);
                userShippingRepository.save(userShipping);
            }
        }
    }
}
