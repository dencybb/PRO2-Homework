package com.hospital.service;

import com.hospital.entity.Patient;
import com.hospital.repository.PatientRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PatientService {

    @Inject
    PatientRepository patientRepository;

    @Transactional
    public Patient save(Patient patient) {
        patientRepository.persist(patient);
        return patient;
    }

    public List<Patient> getAll() {
        return patientRepository.listAll();
    }

    public Patient getById(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> searchByFirstName(String firstName) {
        return patientRepository.find("firstName", firstName).list();
    }
}