package com.meditoken.doctorservice.service;


import com.meditoken.doctorservice.model.Doctor;
import com.meditoken.doctorservice.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor createNewDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }


    public Doctor getDoctorByDocId(Long docId) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(docId);
        if(optionalDoctor.isPresent()){
            return doctorRepository.findByDocId(docId);
        } else {
            throw new IllegalStateException("Doctor not found error!");
        }
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
