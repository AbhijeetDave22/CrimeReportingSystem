package com.crs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;





import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.crs.pojos.EmergencyComplaint;
import com.crs.pojos.People;
import com.crs.repository.PeopleRepository;
import com.crs.service.PeopleServiceImpl;

@SpringBootTest
public class PeopleServiceTest {

    @Autowired
    PeopleServiceImpl peopleService;

    @MockBean
    PeopleRepository peopleRepository;

    @Test
    public void addSinglePeopleDetail() {
        long phoneNumber = 9876543210l;
        People people = new People(1, "Hrithik Naha", phoneNumber,
                new EmergencyComplaint(2, "No dogs to feed", "Investigation Pending"));

        when(peopleRepository.save(people)).thenReturn(people);
        People savedPeople = peopleRepository.save(people);

        assertEquals(savedPeople, peopleService.addSinglePeopleDetail(people), "It should add the people Detail");
    }
}