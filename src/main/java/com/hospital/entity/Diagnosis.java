package com.hospital.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "diagnosis")
public class Diagnosis extends PanacheEntity {

    public String name;
    public String description;

    @ManyToMany(mappedBy = "diagnoses")
    public List<Examination> examinations;
}