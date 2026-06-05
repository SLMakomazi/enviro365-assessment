/*
 * AssessmentApplication.java
 * Main Spring Boot application entry point for the Enviro365 Assessment system.
 * Initializes and starts the entire Spring application context.
 * Contains the main method that bootstraps the application.
 */
package com.enviro.assessment.junior.siseko_makomazi; // Root application package

import org.springframework.boot.SpringApplication; // Spring Boot application launcher
import org.springframework.boot.autoconfigure.SpringBootApplication; // Auto-configuration annotation

@SpringBootApplication // Marks this as a Spring Boot application (enables auto-config, component scanning)
public class AssessmentApplication {
    
    /**
     * Main method - entry point for the application
     * @param args Command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(AssessmentApplication.class, args); // Launch Spring Boot application
    }
}

