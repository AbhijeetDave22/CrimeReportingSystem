package com.crs.repository;

import org.springframework.data.repository.CrudRepository;

import com.crs.pojos.Citizen;

public interface CitizenRepository extends CrudRepository<Citizen, Long> {
    Citizen findByComplaintId(long id);
}