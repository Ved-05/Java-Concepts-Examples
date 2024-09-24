package org.personal.multithreading.exceptions;

/**
 * This class represents an exception that is thrown when a message transfer fails.

 */
public class MessageTransferException extends Exception {

    /**
     * This constructor initializes the message to be displayed when the exception is thrown.
     * @param message The message to be displayed.
     */
    public MessageTransferException(String message) {
        super(message);
    }
}
