/*
 * CorsConfig.java
 * Spring configuration class for Cross-Origin Resource Sharing (CORS) settings.
 * Enables the frontend (running on different origin) to access the backend API.
 * Implements WebMvcConfigurer to customize Spring MVC configuration.
 */
package com.enviro.assessment.junior.siseko_makomazi.config; // Configuration layer package

import org.springframework.context.annotation.Configuration; // Configuration annotation
import org.springframework.lang.NonNull; // Null-safety annotation
import org.springframework.web.servlet.config.annotation.CorsRegistry; // CORS registry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; // MVC configuration interface

@Configuration // Marks this class as a Spring configuration class
public class CorsConfig implements WebMvcConfigurer { // Implements interface to customize MVC configuration

    /**
     * Configures CORS (Cross-Origin Resource Sharing) mappings
     * Allows frontend application to make requests to backend API endpoints
     * @param registry The CorsRegistry to add CORS mappings to
     */
    @Override // Override method from WebMvcConfigurer interface
    public void addCorsMappings(@NonNull CorsRegistry registry) { // @NonNull indicates registry cannot be null
        registry.addMapping("/**") // Apply CORS to all endpoints
                .allowedOrigins("http://localhost:5173", "http://localhost:3000") // Allow frontend origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow these HTTP methods
                .allowedHeaders("*") // Allow any request headers (e.g., Authorization, Content-Type)
                .allowCredentials(true); // Allow credentials
    }
}

