package com.crs.service;

import java.util.List;

import com.crs.pojos.EmergencyComplaint;

public interface EmergencyComplaintService {

    public List<EmergencyComplaint> findAllEmergencyComplaintDetails();

    public EmergencyComplaint findComplaintDetailsById(long id);

    public EmergencyComplaint saveComplaintDetails(EmergencyComplaint complaint);

    public EmergencyComplaint editComplaintStatusDetails(String status, long id);
}