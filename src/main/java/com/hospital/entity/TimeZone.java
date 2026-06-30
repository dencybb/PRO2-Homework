package com.hospital.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "timezone")
public class TimeZone extends PanacheEntity {

    public String timeZone;
    public String dateTime;
    public String date;
    public String time;
    public String dayOfWeek;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    public Patient patient;
}