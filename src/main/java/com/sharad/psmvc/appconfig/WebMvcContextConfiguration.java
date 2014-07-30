package com.sharad.psmvc.appconfig;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.sharad.psmvc.web.IndexController;

@Configuration
@EnableWebMvc
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public IndexController indexController() {
		return new IndexController();
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		return new TilesConfigurer();
	}

	@Bean
	public TilesViewResolver tilesViewResolver() {
		TilesViewResolver tilesViewResolver = new TilesViewResolver();
		tilesViewResolver.setOrder(0);
		return tilesViewResolver;
	}

	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		registry.addViewController("/index.jsp").setViewName("index");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**/*").addResourceLocations("/assets/");
		//registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		//registry.addResourceHandler("/img/**").addResourceLocations("/images/");
		//registry.addResourceHandler("/js/**").addResourceLocations("/jquery/");
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:/messages");
		messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}

}
