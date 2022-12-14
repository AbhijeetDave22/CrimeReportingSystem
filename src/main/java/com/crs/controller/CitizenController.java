package com.crs.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.crs.pojos.Citizen;
import com.crs.pojos.Complaint;
import com.crs.pojos.User;
import com.crs.service.CitizenServiceImpl;
import com.crs.service.ComplaintServiceImpl;
import com.crs.service.UserServiceImpl;

import java.security.Principal;

import javax.validation.Valid;

@Controller
public class CitizenController {

    public static String uploadDirectory = System.getProperty("user.dir") + "/src" + "/main" + "/resources" + "/static"
            + "/images";

    @Autowired
    UserServiceImpl userService;

    @Autowired
    CitizenServiceImpl citizenService;

    @Autowired
    ComplaintServiceImpl complaintService;

    @GetMapping("/login")
    public String loginRoute(Model model, @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        if (error != null) {
            model.addAttribute("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addAttribute("logout", "You've been logged out successfully");
        }

        return "login";
    }

    @GetMapping("/register")
    public String registerRoute(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerPostRoute(Model model, @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("validationError", true);
            return "register";
        }

        userService.saveUserDetails(user);
        return "redirect:/login";
    }

    @GetMapping("/user")
    public String userLoginRouter(Principal principal) {
        return ("redirect:/user/" + principal.getName());
    }

    @GetMapping("/user/{username}")
    public String citizenHomeRoute(Model model, @PathVariable String username) {
        model.addAttribute("user", userService.findSingleUserDetails(username));
        return "user/index";
    }

    @GetMapping("/user/{username}/complaint")
    public String citizenAddComplaintRoute(Model model, @PathVariable String username) {
        model.addAttribute("username", username);
        model.addAttribute("complaint", new Complaint());
        return "complaint/complaint-form";
    }

    @PostMapping("/user/{username}/complaint")
    public String citizenAddComplaintPostRoute(Model model, @Valid Complaint complaint, BindingResult result,
            @PathVariable String username, @RequestParam("file") MultipartFile file) {
        if (result.hasErrors()) {
            model.addAttribute("validationError", true);
            return "complaint/complaint-form";
        }

        Citizen complaintAddedCitizen = userService.findSingleUserDetails(username).getCitizen();
        Complaint complaintWithImage = complaintService.addImageToComplaint(complaint, file, uploadDirectory);
        model.addAttribute("citizen", citizenService.addComplaint(complaintAddedCitizen, complaintWithImage));
        model.addAttribute("complaint", complaint);
        return "complaint/submission";
    }

}