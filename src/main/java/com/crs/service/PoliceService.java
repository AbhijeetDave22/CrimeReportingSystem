package com.crs.service;

import java.util.List;

import com.crs.pojos.Police;

public interface PoliceService {

    public List<Police> findAllPoliceDetails();

    public Police findSinglePoliceDetail(Long id);

    public Police savePoliceDetail(Police police);

    public Police editPoliceDetails(String name, long id);

    // Not Used
    public void deletePoliceDetail(long id);
}