package com.crs.repository;

import org.springframework.data.repository.CrudRepository;

import com.crs.pojos.Complaint;

public interface ComplaintRepository extends CrudRepository<Complaint, Long> {
    // List<Complaint> findAll();
}