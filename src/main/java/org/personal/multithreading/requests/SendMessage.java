package org.personal.multithreading.requests;

import org.personal.multithreading.message.OneToOneMessage;

/**
 * This class represents a request to send a message.
 */
public class SendMessage implements IRequest<Boolean> {
    private final OneToOneMessage message;

    /**
     * This constructor initializes the message to be sent.
     *
     * @param message The message to be sent.
     */
    public SendMessage(OneToOneMessage message) {
        this.message = message;
    }

    @Override
    public Boolean execute() {
        return message.send();
    }
}
