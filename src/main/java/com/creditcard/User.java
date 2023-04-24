package com.creditcard;

/**
 * Public class representing a User in the system.
 * @author Tia Kungwani
 * @version 1.0
 */

import java.time.LocalDate;
import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

public class User {
    private String id;
    private String name;
    private LocalDate dateOfBirth;
    private Map<String, CreditCard> creditCards = new HashMap<>();

    /**
     * Constructor initializing a User.
     * @param name String representing the user's name
     * @param dateOfBirth LocalDate representing the user's date of birth
     */
    User(String name, LocalDate dateOfBirth) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Getter method for the user's ID.
     * @return String representing the user's ID
     */
    public String getId() {
        return id;
    }

    /**
     * Getter method for the user's name.
     * @return String representing the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the user's date of birth.
     * @return LocalDate representing the user's date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Getter method for the user's credit cards.
     * @return Map containing the user's credit cards
     */
    public Map<String, CreditCard> getCreditCards() {
        return creditCards;
    }
}