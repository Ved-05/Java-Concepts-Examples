package org.personal.multithreading.message;

import org.personal.multithreading.entities.AppUser;

/**
 * One to one message
 */
public class OneToOneMessage implements IMessage {
    private final String message;
    private final AppUser from;
    private final AppUser to;
    private final Integer cost;

    /**
     * Constructor to create a message
     *
     * @param from    The sender
     * @param to      The receiver
     * @param message The message
     */
    public OneToOneMessage(AppUser from, AppUser to, String message) {
        this.message = message;
        this.from = from;
        this.to = to;
        this.cost = 50;
    }

    public boolean send() {
        boolean status = false;
        try {
            this.from.getWallet().debit(cost);
            // send message sudo. Assuming a message is sent.
            System.out.printf("Message sent from %s to %s: %s \n", from.getName(), to.getName(), message);
            status = true;
        } catch (Exception e) {
            System.out.printf("Failed to send message %s. Exception: %s \n", this, e.getMessage());
        }
        return status;
    }

    @Override
    public String toString() {
        return "OneToOneMessage{" +
                "message='" + message + '\'' +
                ", from=" + from.getName() +
                ", to=" + to.getName() +
                '}';
    }
}
