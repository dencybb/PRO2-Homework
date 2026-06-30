package com.hospital.resource;

import com.hospital.dto.FileUploadForm;
import com.hospital.entity.Patient;
import com.hospital.service.PatientService;
import com.hospital.service.TimeZoneService;
import com.hospital.service.UploadedFileService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import java.util.List;

@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientResource {

    @Inject
    PatientService patientService;

    @Inject
    TimeZoneService timeZoneService;

    @Inject
    UploadedFileService uploadedFileService;

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

    @GET
    @Path("/getTimezoneByIP")
    public Patient getTimezoneByIP(@QueryParam("userId") Long userId) {
        return timeZoneService.assignTimeZone(userId);
    }

    @POST
    @Path("/uploadFile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Patient uploadFile(@QueryParam("id") Long id, @MultipartForm FileUploadForm form) {
        return uploadedFileService.uploadFile(id, form);
    }

    @GET
    @Path("/{id}/files")
    public Patient getPatientWithFiles(@PathParam("id") Long id) {
        return uploadedFileService.getPatientWithFiles(id);
    }
}