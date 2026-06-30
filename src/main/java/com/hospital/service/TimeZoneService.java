package com.hospital.service;

import com.hospital.client.IpClient;
import com.hospital.client.TimeApiClient;
import com.hospital.dto.TimeZoneResponse;
import com.hospital.entity.Patient;
import com.hospital.entity.TimeZone;
import com.hospital.repository.PatientRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class TimeZoneService {

    @Inject
    PatientRepository patientRepository;

    @Inject
    @RestClient
    IpClient ipClient;

    @Inject
    @RestClient
    TimeApiClient timeApiClient;

    public Patient assignTimeZone(Long userId) {
        Patient patient = patientRepository.findById(userId);

        if (patient == null) {
            throw new NotFoundException("Patient with id " + userId + " not found");
        }

        String ip = ipClient.getPublicIp();
        TimeZoneResponse response = timeApiClient.getTimeZoneByIp(ip);

        return saveTimeZone(patient, response);
    }

    @Transactional
    public Patient saveTimeZone(Patient patient, TimeZoneResponse response) {
        TimeZone timeZone = new TimeZone();
        timeZone.timeZone = response.timeZone;
        timeZone.dateTime = response.dateTime;
        timeZone.date = response.date;
        timeZone.time = response.time;
        timeZone.dayOfWeek = response.dayOfWeek;
        timeZone.patient = patient;
        timeZone.persist();

        return patient;
    }
}