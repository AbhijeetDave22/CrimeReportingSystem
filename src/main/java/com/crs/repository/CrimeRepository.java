package com.crs.repository;

import org.springframework.data.repository.CrudRepository;

import com.crs.pojos.Crime;

public interface CrimeRepository extends CrudRepository<Crime, Long> {

}