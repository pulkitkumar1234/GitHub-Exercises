package com.Shop2Drop.Shop2Drop.service.impl;

import com.Shop2Drop.Shop2Drop.entity.UserShipping;
import com.Shop2Drop.Shop2Drop.repository.UserShippingRepository;
import com.Shop2Drop.Shop2Drop.service.UserShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserShippingServiceImpl implements UserShippingService {

    @Autowired
    UserShippingRepository userShippingRepository;
    @Override
    public UserShipping findById(Long id){
        return userShippingRepository.findOne(id);

    }

    @Override
    public void removeById(Long id){
        userShippingRepository.delete(id);
    }
}
