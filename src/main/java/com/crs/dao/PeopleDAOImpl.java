package com.crs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crs.pojos.People;
import com.crs.repository.PeopleRepository;

@Repository
public class PeopleDAOImpl implements PeopleDAO {

    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public People save(People people) {
        return peopleRepository.save(people);
    }

}