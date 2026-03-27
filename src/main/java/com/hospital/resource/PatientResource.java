package com.hospital.resource;

import com.hospital.entity.Patient;
import com.hospital.service.PatientService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientResource {

    @Inject
    PatientService patientService;

    @POST
    public Patient save(Patient patient) {
        return patientService.save(patient);
    }

    @GET
    public List<Patient> getAll() {
        return patientService.getAll();
    }

    @GET
    @Path("/{id}")
    public Patient getById(@PathParam("id") Long id) {
        return patientService.getById(id);
    }

    @GET
    @Path("/search")
    public List<Patient> searchByFirstName(@QueryParam("firstName") String firstName) {
        return patientService.searchByFirstName(firstName);
    }
}