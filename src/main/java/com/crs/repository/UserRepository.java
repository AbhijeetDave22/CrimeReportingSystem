package com.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crs.pojos.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findByPoliceId(long id);

    User findByCitizenId(long id);
}