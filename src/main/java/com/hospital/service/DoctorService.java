package com.hospital.service;

import com.hospital.entity.Doctor;
import com.hospital.entity.Examination;
import com.hospital.entity.Patient;
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

    public Doctor getById(Long id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> searchByLastName(String lastName) {
        return doctorRepository.find("lastName", lastName).list();
    }

    public List<Examination> getExaminations(Long id) {
        Doctor doctor = doctorRepository.findById(id);
        return doctor.examinations;
    }

    public List<Patient> getPatients(Long id) {
        Doctor doctor = doctorRepository.findById(id);
        return doctor.patients;
    }
}