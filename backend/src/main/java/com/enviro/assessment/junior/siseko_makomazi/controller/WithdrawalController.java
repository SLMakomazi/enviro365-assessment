/*
 * WithdrawalController.java
 * REST API controller for withdrawal-related endpoints.
 * Handles HTTP requests for retrieving and processing withdrawal requests.
 * Maps to /api/withdrawals base path.
 */
package com.enviro.assessment.junior.siseko_makomazi.controller; // Controller layer package

import java.util.List; // For returning lists

import org.springframework.http.ResponseEntity; // HTTP response wrapper
import org.springframework.web.bind.annotation.GetMapping; // HTTP GET annotation
import org.springframework.web.bind.annotation.PostMapping; // HTTP POST annotation
import org.springframework.web.bind.annotation.RequestBody; // Request body annotation
import org.springframework.web.bind.annotation.RequestMapping; // Base URL path mapping
import org.springframework.web.bind.annotation.RestController; // REST controller annotation

import com.enviro.assessment.junior.siseko_makomazi.dto.WithdrawalRequestDTO; // DTO for incoming requests
import com.enviro.assessment.junior.siseko_makomazi.dto.WithdrawalResponseDTO; // DTO for API responses
import com.enviro.assessment.junior.siseko_makomazi.service.WithdrawalService; // Business logic service

@RestController // Marks this class as a REST API controller (returns JSON/XML)
@RequestMapping("/api/withdrawals") // Base URL path: localhost:8080/api/withdrawals
public class WithdrawalController {

    private final WithdrawalService withdrawalService; // Service for business logic (injected)

    /**
     * Constructor with dependency injection for WithdrawalService
     */
    public WithdrawalController(WithdrawalService withdrawalService) {
        this.withdrawalService = withdrawalService; // Inject the service dependency
    }

    /**
     * GET endpoint to retrieve all withdrawal records
     * HTTP GET /api/withdrawals
     * @return ResponseEntity with List of WithdrawalResponseDTO objects and HTTP 200 OK
     */
    @GetMapping // Maps to HTTP GET request at /api/withdrawals
    public ResponseEntity<List<WithdrawalResponseDTO>> getAllWithdrawals() {
        return ResponseEntity.ok(withdrawalService.getAllWithdrawals()); // Get all withdrawals and return with 200 status
    }

    /**
     * POST endpoint to submit a new withdrawal request
     * HTTP POST /api/withdrawals
     * Request body contains amount and reason for withdrawal
     * @param request WithdrawalRequestDTO with amount and reason
     * @return ResponseEntity with WithdrawalResponseDTO containing saved withdrawal details and HTTP 200 OK
     * @throws RuntimeException if validation fails (insufficient balance, invalid amount, etc.)
     */
    @PostMapping // Maps to HTTP POST request at /api/withdrawals
    public ResponseEntity<WithdrawalResponseDTO> requestWithdrawal(@RequestBody WithdrawalRequestDTO request) { // Parse JSON body to DTO
        return ResponseEntity.ok(withdrawalService.processWithdrawal(request)); // Process and return response with 200 status
    }
}

