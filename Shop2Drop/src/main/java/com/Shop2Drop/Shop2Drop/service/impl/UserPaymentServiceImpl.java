package com.Shop2Drop.Shop2Drop.service.impl;

import com.Shop2Drop.Shop2Drop.entity.UserPayment;
import com.Shop2Drop.Shop2Drop.repository.UserPaymentRepository;
import com.Shop2Drop.Shop2Drop.service.UserPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

    @Autowired
    UserPaymentRepository userPaymentRepository;
    @Override
    public UserPayment findById(Long id) {
        return userPaymentRepository.findOne(id);

    }

    @Override
  public void removeById(Long id){
        userPaymentRepository.delete(id);
    }
}
