package com.crs.repository;

import org.springframework.data.repository.CrudRepository;

import com.crs.pojos.EmergencyComplaint;

public interface EmergencyComplaintRepository extends CrudRepository<EmergencyComplaint, Long> {
}