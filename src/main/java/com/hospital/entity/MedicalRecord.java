package com.hospital.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "medical_record")
public class MedicalRecord extends PanacheEntity {

    public String bloodType;
    public String allergies;

    @OneToOne
    @JoinColumn(name = "patient_id")
    public Patient patient;
}