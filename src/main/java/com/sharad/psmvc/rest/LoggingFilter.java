package com.sharad.psmvc.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
@Loggable
public class LoggingFilter implements ContainerRequestFilter {
  private static final Logger _log = LoggerFactory.getLogger(LoggingFilter.class);

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    MultivaluedMap<String, String> map = requestContext.getHeaders();
  }
}
