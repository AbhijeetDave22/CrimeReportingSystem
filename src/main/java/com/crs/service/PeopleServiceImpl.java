package com.crs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crs.dao.PeopleDAOImpl;
import com.crs.pojos.People;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    PeopleDAOImpl peopleDAO;

    public People addSinglePeopleDetail(People people) {
        People savedPeople = peopleDAO.save(people);
        return savedPeople;
    }

    // Not Used
    // public People getSinglePeopleDetail(Long id) {
    // return peopleRepository.findById(id).orElse(null);
    // }
}