package com.crs.dao;

import com.crs.pojos.EmergencyComplaint;

public interface EmergencyComplaintDAO {
    public EmergencyComplaint findById(long id);

    public Iterable<EmergencyComplaint> findAll();

    public EmergencyComplaint save(EmergencyComplaint emergencyComplaint);
}