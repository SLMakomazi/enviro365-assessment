/*
 * AgeRestrictionException.java
 * Custom exception for age-related business rule violations.
 * Thrown when withdrawal or operation restrictions apply based on investor age.
 * Extends RuntimeException for unchecked exception behavior.
 */
package com.enviro.assessment.junior.siseko_makomazi.exception; // Exception layer package

/**
 * AgeRestrictionException represents business rule violations related to age restrictions.
 * Used when a withdrawal or operation fails due to age-based compliance requirements.
 */
public class AgeRestrictionException extends RuntimeException { // Extends RuntimeException for unchecked exception
    
    /**
     * Constructor to create exception with descriptive message
     * @param message Description of the age restriction violation
     */
    public AgeRestrictionException(String message) {
        super(message); // Pass message to parent RuntimeException
    }
}

