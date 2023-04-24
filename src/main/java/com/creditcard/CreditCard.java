package com.creditcard;

/**
 * Public class representing a Credit Card in the system.
 * @author Tia Kungwani
 * @version 1.0
 */

import java.util.List;
import java.util.ArrayList;

public class CreditCard {
    private String issuanceBank;
    private String cardNumber;
    private String cardHolder;
    private List<BalanceHistory> balanceHistory = new ArrayList<>();

    /**
     * Constructor initializing a Credit Card.
     * @param issuanceBank String representing the bank that issued the credit card
     * @param cardNumber String representing the card's number
     * @param cardHolder String representing name of the card's holder
     */
    CreditCard(String issuanceBank, String cardNumber, String cardHolder) {
        this.issuanceBank = issuanceBank;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    /**
     * Getter method for the issuance bank.
     * @return String representing the bank that issued the credit card
     */
    public String getIssuanceBank() {
        return issuanceBank;
    }

    /**
     * Getter method for the card number.
     * @return String representing the card's number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Getter method for the card holder's name.
     * @return String representing name of the card's holder
     */
    public String getCardHolder() {
        return cardHolder;
    }

    /**
     * Getter method for the balance history.
     * @return List containing the balance history.
     */
    public List<BalanceHistory> getBalanceHistory() {
        return balanceHistory;
    }
}