package com.creditcard;

/**
 * Public class representing Credit Card Balance for a specific date.
 *
 * @author Tia Kungwani
 * @version 1.0
 */

import java.time.LocalDate;

public class BalanceHistory {
    private LocalDate date;
    private double balance;

    /**
     * Constructor initializing Balance History object.
     * @param date LocalDate representing the date who's history you want to retrieve
     * @param balance double representing the balance on that date
     */
    BalanceHistory(LocalDate date, double balance) {
        this.date = date;
        this.balance = balance;
    }

    /**
     * Getter method for the date
     * @return LocalDate representing the date of the balance
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Getter method for the balance
     * @return double representing the balance on that date
     */
    public double getBalance() {
        return balance;
    }
}

