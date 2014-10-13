package com.sharad.psmvc.appconfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.sharad.psmvc.rest.BookStoreServices;
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApplicationInitializer implements WebApplicationInitializer {

    private static final Class<?>[] configurationClasses = new Class<?>[] { WebMvcContextConfiguration.class, PersistanceContextConfiguration.class };

    private static final Logger _log = LoggerFactory.getLogger(ApplicationInitializer.class);

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    
    private static final String JERSEY_SERVLET_NAME = "jersey";

    public void onStartup(ServletContext servletContext) throws ServletException {
	_log.debug("Initializing Application using WebApplicationInitializer");
	servletContext.setInitParameter(ContextLoader.CONFIG_LOCATION_PARAM, "Dont initialize");
	registerListener(servletContext);
	registerJerseyServlet(servletContext);
	registerDispatcherServlet(servletContext);
    }

    private void registerJerseyServlet(ServletContext servletContext) {
    	_log.debug("Adding jersey servlet to servlet context");
    	ServletRegistration.Dynamic jersey = servletContext.addServlet(JERSEY_SERVLET_NAME, ServletContainer.class.getName());
    	jersey.setInitParameter("javax.ws.rs.Application", BookStoreServices.class.getName());
    	jersey.setLoadOnStartup(1);
    	_log.debug("adding mapping /services/* to  dispatcher servlet");
    	jersey.addMapping("/services/*");
		
	}

	private void registerDispatcherServlet(ServletContext servletContext) {
	_log.debug("Creating context for dispatcher servlet using :: WebMvcContextConfiguration ::");
	AnnotationConfigWebApplicationContext dispatcherContext = createContext(WebMvcContextConfiguration.class);
	_log.debug("Adding dispatcher servlet to servlet context");
	ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(dispatcherContext));
	dispatcher.setLoadOnStartup(1);
	_log.debug("adding mapping /web/* to  dispatcher servlet");
	dispatcher.addMapping("/web/*");
    }

    private void registerListener(ServletContext servletContext) {
	_log.debug("Creating root application context :: AnnotationConfigWebApplicationContext ::");
	AnnotationConfigWebApplicationContext rootContext = createContext(configurationClasses);
	_log.debug("Adding  ContextLoaderListener to root context");
	servletContext.addListener(new ContextLoaderListener(rootContext));
	_log.debug("Adding  RequestContextListener to servlet context");
	servletContext.addListener(new RequestContextListener());
    }

    private AnnotationConfigWebApplicationContext createContext(final Class<?>... annotatedClasses) {
	AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
	context.register(annotatedClasses);
	return context;
    }

}
