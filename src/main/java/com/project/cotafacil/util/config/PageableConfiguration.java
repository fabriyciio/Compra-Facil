package com.project.cotafacil.util.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;
import org.springframework.data.web.config.SortHandlerMethodArgumentResolverCustomizer;

@Configuration
public class PageableConfiguration {

	
    @Bean
    PageableHandlerMethodArgumentResolverCustomizer pageableResolverCustomizer() {
        return pageableResolver -> pageableResolver.setOneIndexedParameters(true);
    }
   
    @Bean
    SortHandlerMethodArgumentResolverCustomizer sortResolverCustomizer() {
        return sortResolver -> sortResolver.setSortParameter("sort");
    }
}
