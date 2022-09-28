package com.crs.dao;

import com.crs.pojos.Citizen;

public interface CitizenDAO {
    public Citizen save(Citizen citizen);

    public Iterable<Citizen> findAll();

    public Citizen findById(long id);

    public Citizen findByComplaintId(long id);
}