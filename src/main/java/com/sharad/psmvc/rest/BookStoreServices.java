package com.sharad.psmvc.rest;

import javax.ws.rs.ext.ContextResolver;

import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.sharad.psmvc.exception.mappers.ValidationExceptionMapper;
import com.sharad.psmvc.rest.resource.CustomerResource;
import com.sharad.psmvc.rest.resource.HealthResource;
import com.sharad.psmvc.rest.resource.NotesResource;

public class BookStoreServices extends ResourceConfig {
    public BookStoreServices() {
	property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
	property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
	register(RequestContextFilter.class);
	register(NotesResource.class);
	register(HealthResource.class);
	register(LoggingFilter.class);
	register(CustomerResource.class);
	register(ValidationExceptionMapper.class);
	register(MoxyJsonFeature.class);
	register(JsonConfiguration.class);
    }

    public static class JsonConfiguration implements ContextResolver<MoxyJsonConfig> {
	@Override
	public MoxyJsonConfig getContext(final Class<?> type) {
	    final MoxyJsonConfig config = new MoxyJsonConfig();
	    config.setFormattedOutput(true);
	    return config;
	}
    }
}