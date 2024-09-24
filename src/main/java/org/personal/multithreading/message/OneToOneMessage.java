package org.personal.multithreading.message;

import org.personal.multithreading.entities.AppUser;
import org.personal.multithreading.exceptions.InsufficientBalanceException;

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
            this.transferMessage();
            status = true;
        } catch (InsufficientBalanceException e) {
            System.out.printf("Failed to send message %s. Exception: %s \n", this, e.getMessage());
        } catch (Exception e) {
            System.err.printf("Failed to send message %s. Exception: %s \n", e.getMessage(), this);
            this.from.getWallet().credit(cost);
        }
        return status;
    }

    /**
     * Transfers the message.
     * This is a dummy method to simulate message transfer.
     * In real world, this method would be replaced by actual message transfer logic.
     *
     * @throws InterruptedException If the thread is interrupted.
     */
    private void transferMessage() throws InterruptedException {
        Thread.sleep(100);
        System.out.printf("Message sent from %s to %s: %s \n", from.getName(), to.getName(), message);
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
