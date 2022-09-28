package com.crs.dao;

import com.crs.pojos.Crime;

public interface CrimeDAO {

    public Crime save(Crime crime);

    public Iterable<Crime> findAll();

    public void deleteById(long id);
}