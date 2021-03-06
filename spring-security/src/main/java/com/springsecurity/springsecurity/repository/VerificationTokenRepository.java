package com.springsecurity.springsecurity.repository;

import com.springsecurity.springsecurity.entity.VerificationToken;
import org.springframework.data.repository.CrudRepository;

public interface VerificationTokenRepository extends CrudRepository<VerificationToken, Integer> {

    public VerificationToken findByToken(String token);
}
