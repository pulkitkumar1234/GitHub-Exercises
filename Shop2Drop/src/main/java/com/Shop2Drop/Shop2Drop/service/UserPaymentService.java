package com.Shop2Drop.Shop2Drop.service;

import com.Shop2Drop.Shop2Drop.entity.UserPayment;

public interface UserPaymentService {

    UserPayment findById(Long id);
    void removeById(Long id);
}
