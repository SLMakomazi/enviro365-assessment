/*
 * WithdrawalService.java
 * Service class for business logic related to withdrawal operations.
 * Processes withdrawal requests, validates them, and manages withdrawal records.
 * Coordinates between WithdrawalValidator and WithdrawalRepository.
 */
package com.enviro.assessment.junior.siseko_makomazi.service; // Service layer package

import com.enviro.assessment.junior.siseko_makomazi.dto.WithdrawalRequestDTO; // DTO for incoming withdrawal requests
import com.enviro.assessment.junior.siseko_makomazi.dto.WithdrawalResponseDTO; // DTO for API responses
import com.enviro.assessment.junior.siseko_makomazi.model.Withdrawal; // Entity model
import com.enviro.assessment.junior.siseko_makomazi.repository.WithdrawalRepository; // Data access
import com.enviro.assessment.junior.siseko_makomazi.validation.WithdrawalValidator; // Business validation logic
import org.springframework.stereotype.Service; // Service annotation

import java.time.LocalDateTime; // For timestamp handling
import java.util.List; // For returning lists
import java.util.stream.Collectors; // For stream operations

@Service // Marks this class as a business logic service component
public class WithdrawalService {

    private final WithdrawalRepository withdrawalRepository; // Repository for database operations (injected)
    private final WithdrawalValidator withdrawalValidator; // Validator for business rules (injected)

    /**
     * Constructor with dependency injection for repository and validator
     */
    public WithdrawalService(WithdrawalRepository withdrawalRepository, WithdrawalValidator withdrawalValidator) {
        this.withdrawalRepository = withdrawalRepository; // Inject the repository dependency
        this.withdrawalValidator = withdrawalValidator; // Inject the validator dependency
    }

    /**
     * Retrieves all withdrawal records from the database and converts to DTOs
     * @return List of WithdrawalResponseDTO objects containing all withdrawal records
     */
    public List<WithdrawalResponseDTO> getAllWithdrawals() {
        return withdrawalRepository.findAll() // Fetch all withdrawal records from database
                .stream() // Convert to stream for functional processing
                .map(this::mapToDto) // Transform each Withdrawal entity to WithdrawalResponseDTO
                .collect(Collectors.toList()); // Collect results into a list
    }

    /**
     * Processes a new withdrawal request: validates, creates, saves, and returns response
     * @param request The WithdrawalRequestDTO containing amount and reason
     * @return WithdrawalResponseDTO with the saved withdrawal details and initial status
     * @throws RuntimeException if validation fails (from WithdrawalValidator)
     */
    public WithdrawalResponseDTO processWithdrawal(WithdrawalRequestDTO request) {
        withdrawalValidator.validate(request); // Validate the request against business rules
        
        Withdrawal withdrawal = new Withdrawal(); // Create new withdrawal entity
        withdrawal.setAmount(request.getAmount()); // Set the requested withdrawal amount
        withdrawal.setReason(request.getReason()); // Set the reason for withdrawal
        withdrawal.setStatus("Pending"); // Initialize status to Pending
        withdrawal.setRequestedAt(LocalDateTime.now()); // Set current timestamp for request
        
        Withdrawal saved = withdrawalRepository.save(withdrawal); // Persist to database and get ID
        return mapToDto(saved); // Convert persisted entity to DTO and return
    }

    /**
     * Maps Withdrawal entity to WithdrawalResponseDTO
     * @param withdrawal The entity to map
     * @return WithdrawalResponseDTO with populated fields
     */
    private WithdrawalResponseDTO mapToDto(Withdrawal withdrawal) { // Private helper for entity-to-DTO transformation
        return new WithdrawalResponseDTO( // Create and return new DTO instance
                withdrawal.getId(), // Unique transaction identifier
                withdrawal.getAmount(), // Withdrawal amount
                withdrawal.getStatus(), // Current status (Pending/Approved/Rejected/Completed)
                withdrawal.getRequestedAt().toString() // Request timestamp as string
        );
    }
}

