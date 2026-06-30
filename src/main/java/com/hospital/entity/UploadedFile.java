package com.hospital.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.io.File;

@Entity
@Table(name = "uploaded_file")
public class UploadedFile extends PanacheEntity {

    public String filename;

    @Transient
    public File file;
}