package com.hospital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient extends PanacheEntity {

    public String firstName;
    public String lastName;
    public String dateOfBirth;

    @JsonIgnore
    @OneToOne(mappedBy = "patient", fetch = FetchType.LAZY)
    public MedicalRecord medicalRecord;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "patient_doctor",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    public List<Doctor> doctors;

    @JsonIgnore
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<TimeZone> timeZones;

}