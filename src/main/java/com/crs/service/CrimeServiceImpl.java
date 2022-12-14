package com.crs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crs.dao.CrimeDAOImpl;
import com.crs.pojos.Crime;

@Service
public class CrimeServiceImpl implements CrimeService {

    @Autowired
    CrimeDAOImpl crimeDao;

    public Crime addCrimeDetail(Crime crime) {
        return crimeDao.save(crime);
    }

    public void deleteCrimeDetail(long id) {
        crimeDao.deleteById(id);
    }

    public List<Crime> findAllCrime() {
        List<Crime> crimes = new ArrayList<>();
        crimeDao.findAll().forEach(crimes::add);
        return crimes;
    }
}