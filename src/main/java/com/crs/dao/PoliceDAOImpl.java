package com.crs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crs.pojos.Police;
import com.crs.repository.PoliceRepository;

@Repository
public class PoliceDAOImpl implements PoliceDAO {

    @Autowired
    PoliceRepository policeRepository;

    @Override
    public Iterable<Police> findAll() {
        return policeRepository.findAll();
    }

    @Override
    public Police findById(long id) {
        return policeRepository.findById(id).orElse(null);
    }

    @Override
    public Police save(Police police) {
        return policeRepository.save(police);
    }

    @Override
    public void deleteById(long id) {
        policeRepository.deleteById(id);
    }

}