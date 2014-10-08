package com.sharad.psmvc.rest.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sharad.psmvc.service.NotesHealthService;

@Path("/health")
public class HealthResource {
  private final NotesHealthService healthService;

  @Inject
  public HealthResource(NotesHealthService healthService) {
    this.healthService = healthService;
  }
  
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String isHealthy() {
    return healthService.isHealthy() ? "OK" : "Not OK";
  }
}
