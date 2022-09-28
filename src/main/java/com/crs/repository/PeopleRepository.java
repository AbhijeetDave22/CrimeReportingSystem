package com.crs.repository;

import org.springframework.data.repository.CrudRepository;

import com.crs.pojos.People;

public interface PeopleRepository extends CrudRepository<People, Long> {

}
