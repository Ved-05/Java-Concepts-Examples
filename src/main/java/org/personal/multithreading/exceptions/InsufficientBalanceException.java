package org.personal.multithreading.exceptions;

/**
 * This exception is thrown when the balance in the account is insufficient to perform a transaction.
 */
public class InsufficientBalanceException extends Exception {

    /**
     * This constructor initializes the message to be displayed when the exception is thrown.
     * @param message The message to be displayed.
     */
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
