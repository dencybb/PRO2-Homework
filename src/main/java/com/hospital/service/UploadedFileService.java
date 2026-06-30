package com.hospital.service;

import com.hospital.dto.FileUploadForm;
import com.hospital.entity.Patient;
import com.hospital.entity.UploadedFile;
import com.hospital.repository.PatientRepository;
import com.hospital.repository.UploadedFileRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@ApplicationScoped
public class UploadedFileService {

    private static final String UPLOAD_DIR = "uploads";

    @Inject
    PatientRepository patientRepository;

    @Inject
    UploadedFileRepository uploadedFileRepository;

    @Transactional
    public Patient uploadFile(Long patientId, FileUploadForm form) {
        Patient patient = patientRepository.findById(patientId);

        if (patient == null) {
            throw new NotFoundException("Patient with id " + patientId + " not found");
        }

        Path uploadPath = Paths.get(UPLOAD_DIR);
        try {
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory", e);
        }

        UploadedFile existing = uploadedFileRepository.find("filename", UPLOAD_DIR + "/" + form.filename).firstResult();
        UploadedFile uploadedFile;
        if (existing != null) {
            uploadedFile = existing;
        } else {
            String filePath = UPLOAD_DIR + "/" + form.filename;
            try (InputStream is = form.file; FileOutputStream fos = new FileOutputStream(filePath)) {
                is.transferTo(fos);
            } catch (IOException e) {
                throw new RuntimeException("Could not save file", e);
            }

            uploadedFile = new UploadedFile();
            uploadedFile.filename = filePath;
            uploadedFile.persist();
        }

        if (patient.uploadedFiles == null) {
            patient.uploadedFiles = new java.util.ArrayList<>();
        }
        if (!patient.uploadedFiles.contains(uploadedFile)) {
            patient.uploadedFiles.add(uploadedFile);
        }

        return patient;
    }

    public Patient getPatientWithFiles(Long patientId) {
        Patient patient = patientRepository.findById(patientId);

        if (patient == null) {
            throw new NotFoundException("Patient with id " + patientId + " not found");
        }

        if (patient.uploadedFiles != null) {
            for (UploadedFile uf : patient.uploadedFiles) {
                uf.file = new File(uf.filename);
            }
        }

        return patient;
    }
}