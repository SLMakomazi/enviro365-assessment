/*
 * PortfolioController.java
 * REST API controller for portfolio-related endpoints.
 * Handles HTTP requests for retrieving portfolio data.
 * Maps to /api/portfolios base path.
 */
package com.enviro.assessment.junior.siseko_makomazi.controller; // Controller layer package

import com.enviro.assessment.junior.siseko_makomazi.dto.PortfolioDTO; // DTO for API responses
import com.enviro.assessment.junior.siseko_makomazi.service.PortfolioService; // Business logic service
import org.springframework.http.ResponseEntity; // HTTP response wrapper
import org.springframework.web.bind.annotation.GetMapping; // HTTP GET annotation
import org.springframework.web.bind.annotation.PathVariable; // URL path variable annotation
import org.springframework.web.bind.annotation.RequestMapping; // Base URL path mapping
import org.springframework.web.bind.annotation.RestController; // REST controller annotation

import java.util.List; // For returning lists

@RestController // Marks this class as a REST API controller (returns JSON/XML)
@RequestMapping("/api/portfolios") // Base URL path: localhost:8080/api/portfolios
public class PortfolioController {

    private final PortfolioService portfolioService; // Service for business logic (injected)

    /**
     * Constructor with dependency injection for PortfolioService
     */
    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService; // Inject the service dependency
    }

    /**
     * GET endpoint to retrieve all portfolios
     * HTTP GET /api/portfolios
     * @return ResponseEntity with List of PortfolioDTO objects and HTTP 200 OK
     */
    @GetMapping // Maps to HTTP GET request at /api/portfolios
    public ResponseEntity<List<PortfolioDTO>> getPortfolios() {
        return ResponseEntity.ok(portfolioService.getAllPortfolios()); // Get all portfolios and return with 200 status
    }

    /**
     * GET endpoint to retrieve a specific portfolio by ID
     * HTTP GET /api/portfolios/{id}
     * @param id The portfolio ID from the URL path
     * @return ResponseEntity with PortfolioDTO object and HTTP 200 OK
     * @throws NoSuchElementException if portfolio with given ID not found
     */
    @GetMapping("/{id}") // Maps to HTTP GET request at /api/portfolios/{id}
    public ResponseEntity<PortfolioDTO> getPortfolioById(@PathVariable Long id) { // Extract ID from URL path
        return ResponseEntity.ok(portfolioService.getPortfolioById(id)); // Get portfolio by ID and return with 200 status
    }
}

