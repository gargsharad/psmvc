package com.sharad.psmvc.rest;

import java.util.Set;

import javax.ws.rs.core.Application;

import com.google.common.collect.ImmutableSet;
import com.sharad.psmvc.rest.resource.HealthResource;
import com.sharad.psmvc.rest.resource.NotesResource;

public class NotesApplication extends Application {
  
  @Override
  public Set<Class<?>> getClasses() {
    return ImmutableSet.<Class<?>>of(NotesResource.class, 
      HealthResource.class,
      NoteNotFoundExceptionMapper.class, LoggingFilter.class);
  }
}
