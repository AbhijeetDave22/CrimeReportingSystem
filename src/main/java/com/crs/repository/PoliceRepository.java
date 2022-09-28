package com.crs.repository;

import org.springframework.data.repository.CrudRepository;

import com.crs.pojos.Police;

public interface PoliceRepository extends CrudRepository<Police, Long> {

}