package com.sharad.psmvc.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sharad.psmvc.web.IndexController;

@Configuration
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public IndexController indexController() {
		return new IndexController();
	}

}
