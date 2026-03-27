package com.hospital.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient extends PanacheEntity {

    public String firstName;
    public String lastName;
    public String dateOfBirth;

    @OneToOne(mappedBy = "patient")
    public MedicalRecord medicalRecord;

    @ManyToMany
    @JoinTable(
            name = "patient_doctor",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    public List<Doctor> doctors;
}