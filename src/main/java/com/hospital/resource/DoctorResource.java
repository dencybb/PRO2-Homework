package com.hospital.resource;

import com.hospital.entity.Doctor;
import com.hospital.entity.Examination;
import com.hospital.entity.Patient;
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

    @GET
    @Path("/{id}")
    public Doctor getById(@PathParam("id") Long id) {
        return doctorService.getById(id);
    }

    @GET
    @Path("/search")
    public List<Doctor> searchByLastName(@QueryParam("lastName") String lastName) {
        return doctorService.searchByLastName(lastName);
    }

    @GET
    @Path("/{id}/examinations")
    public List<Examination> getExaminations(@PathParam("id") Long id) {
        return doctorService.getExaminations(id);
    }

    @GET
    @Path("/{id}/patients")
    public List<Patient> getPatients(@PathParam("id") Long id) {
        return doctorService.getPatients(id);
    }
}