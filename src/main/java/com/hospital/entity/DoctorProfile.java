package com.hospital.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "doctor_profile")
public class DoctorProfile extends PanacheEntity {

    public String biography;
    public String phone;
    public String email;

    @OneToOne
    @JoinColumn(name = "doctor_id")
    public Doctor doctor;
}