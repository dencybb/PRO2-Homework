package com.hospital;

import com.hospital.repository.PatientRepository;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

@ApplicationScoped
public class HospitalScheduler {

    private static final Logger LOG = Logger.getLogger(HospitalScheduler.class);

    @Inject
    PatientRepository patientRepository;

    @Scheduled(every = "60s")
    void logPatientCount() {
        long count = patientRepository.count();
        LOG.info("Trenutni broj pacijenata u bazi: " + count);
    }
}