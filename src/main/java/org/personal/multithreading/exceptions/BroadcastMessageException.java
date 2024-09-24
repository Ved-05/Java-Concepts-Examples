package org.personal.multithreading.exceptions;

/**
 * This exception is thrown when the user is unable to send message to all users.
 */
public class BroadcastMessageException extends Exception {

    /**
     * This constructor initializes the message to be displayed when the exception is thrown.
     * @param message The message to be displayed.
     */
    public BroadcastMessageException(String message) {
        super(message);
    }
}
