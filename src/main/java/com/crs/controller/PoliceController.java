package com.crs.controller;

import java.security.Principal;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.crs.service.ComplaintServiceImpl;
import com.crs.service.CrimeServiceImpl;
import com.crs.service.EmergencyComplaintServiceImpl;
import com.crs.service.UserServiceImpl;

import org.springframework.ui.Model;

@Controller
public class PoliceController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ComplaintServiceImpl complaintService;

    @Autowired
    EmergencyComplaintServiceImpl emergencyComplaintService;

    @Autowired
    CrimeServiceImpl crimeService;

    @GetMapping("/police")
    public String policeLoginRouter(Principal principal) {
        return ("redirect:/police/" + principal.getName());
    }

    @GetMapping("/police/{username}")
    public String citizenHomeRoute(Model model, @PathVariable String username) {
        model.addAttribute("user", userService.findSingleUserDetails(username));
        model.addAttribute("complaints", complaintService.findAllComplaintDetails());
        model.addAttribute("emergencyComplaints", emergencyComplaintService.findAllEmergencyComplaintDetails());
        model.addAttribute("crimes", crimeService.findAllCrime());
        return "police/index";
    }
}