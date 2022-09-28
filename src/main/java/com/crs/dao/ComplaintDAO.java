package com.crs.dao;

import com.crs.pojos.Complaint;

public interface ComplaintDAO {
    public Complaint save(Complaint complaint);

    public Iterable<Complaint> findAll();

    public Complaint findById(long id);

    public void deleteById(long id);

}