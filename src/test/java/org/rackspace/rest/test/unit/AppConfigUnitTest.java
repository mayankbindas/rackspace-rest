package org.rackspace.rest.test.unit;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableEntityLinks
@EnableHypermediaSupport(type = HypermediaType.HAL)
@Configuration
@ComponentScan(basePackages = { "org.rackspace.rest" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
public class AppConfigUnitTest implements WebMvcConfigurer {

}
