package com.meditoken.doctorservice.repository;

import com.meditoken.doctorservice.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Doctor findByDocId(Long docId);
}
