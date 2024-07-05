// package com.example.school.school.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.multipart.MultipartFile;

// import com.example.school.school.model.Application;
// import com.example.school.school.service.ApplicationService;

// import java.sql.Date;
// import java.util.List;

// @RestController
// @RequestMapping("/applications")
// public class ApplicationController {

//     @Autowired
//     private ApplicationService applicationService;

//     @PostMapping
//     public ResponseEntity<Application> createApplication(@RequestParam("firstName") String firstName,
//                                                          @RequestParam("lastName") String lastName,
//                                                          @RequestParam("userName") String userName,
//                                                          @RequestParam("phoneNumber") String phoneNumber,
//                                                          @RequestParam("dob") Date dob,
//                                                          @RequestParam("email") String email,
//                                                          @RequestParam("course") String course,
//                                                          @RequestParam("fileUpload") MultipartFile fileUpload
//                                                          ) {
//         Application application = new Application();
//         application.setFirstName(firstName);
//         application.setLastName(lastName);
//         application.setUserName(userName);
//         application.setPhoneNumber(phoneNumber);
//         application.setDob(dob);
//         application.setEmail(email);
//         application.setCourse(course);
//         // Save fileUpload to a location and set the path to the application entity
//         application.setFileUpload(fileUpload.getOriginalFilename());
        
        
//         Application savedApplication = applicationService.saveApplication(application);
//         return ResponseEntity.ok(savedApplication);
//     }

//     @GetMapping ("/api/applications")
//     public ResponseEntity<List<Application>> getAllApplications() {
//         List<Application> applications = applicationService.getAllApplications();
//         return ResponseEntity.ok(applications);
//     }




//     @GetMapping("/{id}")
//     public Application getApplicationById(@PathVariable Long id) {
//         return applicationService.getApplicationById(id);
//     }
// }



package com.example.school.school.controller;

import com.example.school.school.model.Application;
import com.example.school.school.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable Long id) {
        return applicationService.getApplicationById(id);
    }

    @PostMapping
    public Application createApplication(@RequestBody Application application) {
        return applicationService.saveApplication(application);
    }

    @PutMapping("/{id}")
    public Application updateApplication(@PathVariable Long id, @RequestBody Application application) {
        Application existingApplication = applicationService.getApplicationById(id);
        if (existingApplication != null) {
            existingApplication.setFirstName(application.getFirstName());
            existingApplication.setLastName(application.getLastName());
            existingApplication.setUserName(application.getUserName());
            existingApplication.setPhoneNumber(application.getPhoneNumber());
            existingApplication.setDob(application.getDob());
            existingApplication.setEmail(application.getEmail());
            existingApplication.setCourse(application.getCourse());
            existingApplication.setFileUpload(application.getFileUpload());
            return applicationService.saveApplication(existingApplication);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
    }
}
