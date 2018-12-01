package org.rackspace.rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableEntityLinks
@EnableHypermediaSupport(type = HypermediaType.HAL)
@Configuration
@ComponentScan(basePackages = {"org.rackspace.test.rest"})
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

}
