package com.hospital.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "examination_report")
public class ExaminationReport extends PanacheEntity {

    public String result;
    public String notes;
    public String createdAt;

    @OneToOne
    @JoinColumn(name = "examination_id")
    public Examination examination;
}