package com.sharad.psmvc.appconfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {

    private static final Class<?>[] configurationClasses = new Class<?>[] { WebMvcContextConfiguration.class, PersistanceContextConfiguration.class };

    private static final Logger _log = LoggerFactory.getLogger(ApplicationInitializer.class);

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
	_log.debug("Initializing Application using WebApplicationInitializer");
	registerListener(servletContext);
	registerDispatcherServlet(servletContext);
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
