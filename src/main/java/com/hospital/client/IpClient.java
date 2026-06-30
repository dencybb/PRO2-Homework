package com.hospital.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "ip-client")
@Path("/")
public interface IpClient {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String getPublicIp();
}