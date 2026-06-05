/*
 * InvestorController.java
 * REST API controller for investor-related endpoints.
 * Handles HTTP requests for retrieving investor data.
 * Maps to /api/investors base path.
 */
package com.enviro.assessment.junior.siseko_makomazi.controller; // Controller layer package

import com.enviro.assessment.junior.siseko_makomazi.dto.InvestorDTO; // DTO for API responses
import com.enviro.assessment.junior.siseko_makomazi.service.InvestorService; // Business logic service
import org.springframework.http.ResponseEntity; // HTTP response wrapper
import org.springframework.web.bind.annotation.GetMapping; // HTTP GET annotation
import org.springframework.web.bind.annotation.PathVariable; // URL path variable annotation
import org.springframework.web.bind.annotation.RequestMapping; // Base URL path mapping
import org.springframework.web.bind.annotation.RestController; // REST controller annotation

import java.util.List; // For returning lists

@RestController // Marks this class as a REST API controller (returns JSON/XML)
@RequestMapping("/api/investors") // Base URL path: localhost:8080/api/investors
public class InvestorController {

    private final InvestorService investorService; // Service for business logic (injected)

    /**
     * Constructor with dependency injection for InvestorService
     */
    public InvestorController(InvestorService investorService) {
        this.investorService = investorService; // Inject the service dependency
    }

    /**
     * GET endpoint to retrieve all investors
     * HTTP GET /api/investors
     * @return ResponseEntity with List of InvestorDTO objects and HTTP 200 OK
     */
    @GetMapping // Maps to HTTP GET request at /api/investors
    public ResponseEntity<List<InvestorDTO>> getAllInvestors() {
        return ResponseEntity.ok(investorService.getAllInvestors()); // Get all investors and return with 200 status
    }

    /**
     * GET endpoint to retrieve a specific investor by ID
     * HTTP GET /api/investors/{id}
     * @param id The investor ID from the URL path
     * @return ResponseEntity with InvestorDTO object and HTTP 200 OK
     * @throws NoSuchElementException if investor with given ID not found
     */
    @GetMapping("/{id}") // Maps to HTTP GET request at /api/investors/{id}
    public ResponseEntity<InvestorDTO> getInvestorById(@PathVariable Long id) { // Extract ID from URL path
        return ResponseEntity.ok(investorService.getInvestorById(id)); // Get investor by ID and return with 200 status
    }
}

