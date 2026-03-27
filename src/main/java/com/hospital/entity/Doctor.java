package com.hospital.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor extends PanacheEntity {

    public String firstName;
    public String lastName;
    public String specialization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    public Department department;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    public List<Examination> examinations;

    @ManyToMany(mappedBy = "doctors", fetch = FetchType.LAZY)
    public List<Patient> patients;

    @OneToOne(mappedBy = "doctor", fetch = FetchType.LAZY)
    public DoctorProfile doctorProfile;
}