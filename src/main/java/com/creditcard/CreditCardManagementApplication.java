package com.creditcard;

/**
 * Public class that manages a user/credit card system.
 * Contains methods for creating users, deleting users, and adding credit cards
 * to user profiles.
 * Contains two APIs: one to retrieve all credit cards for a user and another to find
 * a user by credit card number.
 * @author Tia Kungwani
 * @version 1.0
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


@SpringBootApplication
@RestController
public class CreditCardManagementApplication {

    private static final Map<String, User> users = new HashMap<>();

    /**
     * Method to create a new user.
     * @param name New user's name
     * @param dateOfBirth New user's date of birth
     */
    public void createUser(String name, LocalDate dateOfBirth) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Entered name is invalid.");
        }
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("Entered date of birth is invalid.");
        }
        //Creates and adds new user to the map
        User user = new User(name, dateOfBirth);
        users.put(user.getId(), user);
    }

    /**
     * Method to delete a user by ID.
     * @param userId ID of user you wish to delete
     */
    public void deleteUser(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("Entered userId is invalid.");
        }
        //Simply removes user from the map
        User user = users.remove(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
    }

    /**
     * Method to add a credit card to a user's profile by ID.
     * @param userId User's ID
     * @param issuanceBank Credit card's issuance bank
     * @param cardNumber Credit card's number
     * @param cardHolder Credit card holder's name
     */
    public void addCreditCard(String userId, String issuanceBank, String cardNumber, String cardHolder) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("Entered userId is invalid.");
        }

        if (issuanceBank == null || issuanceBank.trim().isEmpty()) {
            throw new IllegalArgumentException("Entered issuanceBank is invalid.");
        }

        if (cardNumber == null || cardNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Entered cardNumber is invalid.");
        }

        if (cardHolder == null || cardHolder.trim().isEmpty()) {
            throw new IllegalArgumentException("Entered cardHolder is invalid.");
        }
        User user = users.get(userId);
        //Creates and adds credit card to user's profile if user is found
        if (user != null) {
            CreditCard creditCard = new CreditCard(issuanceBank, cardNumber, cardHolder);
            user.getCreditCards().put(creditCard.getCardNumber(), creditCard);
        } else {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
    }

    /**
     * API to retrieve all credit cards for a user by ID.
     * @param userId ID of user whose credit cards you'd like to retrieve
     * @return List of user's credit cards
     */
    @GetMapping("/users/{userId}/credit-cards")
    public ResponseEntity<List<CreditCard>> getAllCreditCardsForUser(@PathVariable String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        User user = users.get(userId);
        // Return a list of credit cards or appropriate HTTP status code
        // based on whether the user is found or not
        if (user != null) {
            return ResponseEntity.ok(new ArrayList<>(user.getCreditCards().values()));
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    /**
     * API to find a user by credit card number.
     * @param cardNumber Credit card's number
     * @return User who owns the credit card
     */
    @GetMapping("/users/find-by-card/{cardNumber}")
    public ResponseEntity<User> findUserByCreditCardNumber(@PathVariable String cardNumber) {
        if (cardNumber == null || cardNumber.trim().isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        User user = users.get(cardNumber);
        // Return a list of credit cards or appropriate HTTP status code
        // based on whether the user is found or not
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}