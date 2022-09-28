package com.crs.service;

import java.util.List;

import com.crs.pojos.Crime;

public interface CrimeService {

    public Crime addCrimeDetail(Crime crime);

    public void deleteCrimeDetail(long id);

    public List<Crime> findAllCrime();

}