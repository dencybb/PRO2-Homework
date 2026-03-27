package com.hospital.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department extends PanacheEntity {

    public String name;
    public String location;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    public List<Doctor> doctors;
}