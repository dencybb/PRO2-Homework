package com.hospital.resource;

import com.hospital.entity.Doctor;
import com.hospital.service.DoctorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/doctors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoctorResource {

    @Inject
    DoctorService doctorService;

    @POST
    public Doctor save(Doctor doctor) {
        return doctorService.save(doctor);
    }

    @GET
    public List<Doctor> getAll() {
        return doctorService.getAll();
    }
}