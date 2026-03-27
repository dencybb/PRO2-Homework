package com.hospital.service;

import com.hospital.entity.Doctor;
import com.hospital.repository.DoctorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class DoctorService {

    @Inject
    DoctorRepository doctorRepository;

    @Transactional
    public Doctor save(Doctor doctor) {
        doctorRepository.persist(doctor);
        return doctor;
    }

    public List<Doctor> getAll() {
        return doctorRepository.listAll();
    }
}