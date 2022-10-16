package com.meditoken.doctorservice.controller;

import com.meditoken.doctorservice.model.Doctor;
import com.meditoken.doctorservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors/")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public Doctor createNewDoctor(@RequestBody Doctor doctor){
        return doctorService.createNewDoctor(doctor);
    }

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping(path = "{docId}")
    public Doctor getDoctorByDocId(@PathVariable("docId") Long docId){
        return doctorService.getDoctorByDocId(docId);
    }

}
