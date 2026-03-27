package com.hospital.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "examination")
public class Examination extends PanacheEntity {

    public String date;
    public String description;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    public Doctor doctor;

    @ManyToMany
    @JoinTable(
            name = "examination_diagnosis",
            joinColumns = @JoinColumn(name = "examination_id"),
            inverseJoinColumns = @JoinColumn(name = "diagnosis_id")
    )
    public List<Diagnosis> diagnoses;
}