package com.hospital.client;

import com.hospital.dto.TimeZoneResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "timeapi-client")
@Path("/api/time/current/ip")
public interface TimeApiClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    TimeZoneResponse getTimeZoneByIp(@QueryParam("ipAddress") String ipAddress);
}