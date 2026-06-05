/*
 * InsufficientBalanceException.java
 * Custom exception for balance-related business rule violations.
 * Thrown when withdrawal amount exceeds available balance or violates limit constraints.
 * Extends RuntimeException for unchecked exception behavior.
 */
package com.enviro.assessment.junior.siseko_makomazi.exception; // Exception layer package

/**
 * InsufficientBalanceException represents business rule violations related to insufficient funds.
 * Used when a withdrawal or operation fails due to balance constraints.
 */
public class InsufficientBalanceException extends RuntimeException { // Extends RuntimeException for unchecked exception
    
    /**
     * Constructor to create exception with descriptive message
     * @param message Description of the insufficient balance violation
     */
    public InsufficientBalanceException(String message) {
        super(message); // Pass message to parent RuntimeException
    }
}

