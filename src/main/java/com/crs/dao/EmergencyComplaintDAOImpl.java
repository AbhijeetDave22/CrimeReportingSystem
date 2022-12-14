package com.crs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crs.pojos.EmergencyComplaint;
import com.crs.repository.EmergencyComplaintRepository;

@Repository
public class EmergencyComplaintDAOImpl implements EmergencyComplaintDAO {

    @Autowired
    EmergencyComplaintRepository emergencyComplaintRepository;

    @Override
    public EmergencyComplaint findById(long id) {
        return emergencyComplaintRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<EmergencyComplaint> findAll() {
        return emergencyComplaintRepository.findAll();
    }

    @Override
    public EmergencyComplaint save(EmergencyComplaint emergencyComplaint) {
        return emergencyComplaintRepository.save(emergencyComplaint);
    }

}