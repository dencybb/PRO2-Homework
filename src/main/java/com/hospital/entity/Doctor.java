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

    @ManyToOne
    @JoinColumn(name = "department_id")
    public Department department;

    @OneToMany(mappedBy = "doctor")
    public List<Examination> examinations;

    @ManyToMany(mappedBy = "doctors")
    public List<Patient> patients;
}