package com.crs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crs.pojos.Crime;
import com.crs.service.CrimeServiceImpl;

@Controller
public class CrimeController {

    @Autowired
    CrimeServiceImpl crimeService;

    @GetMapping("/crime/new")
    public String addNewCrimeRoute(Model model) {
        model.addAttribute("crime", new Crime());
        return "crime/add-crime-form";
    }

    @PostMapping("/crime/new")
    public String addNewCrimePostRoute(Model model, @Valid Crime crime, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("validationError", true);
            return "crime/add-crime-form";
        }

        crimeService.addCrimeDetail(crime);
        return "redirect:/police";
    }

    @GetMapping("/crime/{id}/delete")
    public String deleteCrimeRoute(@PathVariable("id") long id) {
        crimeService.deleteCrimeDetail(id);
        return "redirect:/police";
    }

}