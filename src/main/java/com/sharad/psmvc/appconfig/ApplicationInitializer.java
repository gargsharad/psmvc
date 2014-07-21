package com.sharad.psmvc.appconfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {

	private static final Class<?>[] configurationClasses = new Class<?>[] {
			WebMvcContextConfiguration.class,
			PersistanceContextConfiguration.class };

	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		registerListener(servletContext);
		registerDispatcherServlet(servletContext);
	}

	private void registerDispatcherServlet(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext dispatcherContext = createContext(WebMvcContextConfiguration.class);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/web/*");
	}

	private void registerListener(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext rootContext = createContext(configurationClasses);
		servletContext.addListener(new ContextLoaderListener(rootContext));
		servletContext.addListener(new RequestContextListener());
	}

	private AnnotationConfigWebApplicationContext createContext(
			final Class<?>... annotatedClasses) {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(annotatedClasses);
		return context;
	}

}
