package com.crs.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.crs.service.ComplaintServiceImpl;
import com.crs.service.CrimeServiceImpl;

@Controller
public class HomeController {

    @Autowired
    CrimeServiceImpl crimeService;

    @Autowired
    ComplaintServiceImpl complaintService;

    @GetMapping("/")
    public String HomeRoute(Model model) {
        model.addAttribute("crimes", crimeService.findAllCrime());
        return "home";
    }

}