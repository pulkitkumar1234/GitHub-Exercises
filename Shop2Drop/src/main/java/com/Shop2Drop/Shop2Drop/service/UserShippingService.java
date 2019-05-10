package com.Shop2Drop.Shop2Drop.service;

import com.Shop2Drop.Shop2Drop.entity.UserShipping;

public interface UserShippingService {
    UserShipping findById(Long id);

    void removeById(Long id);
}
