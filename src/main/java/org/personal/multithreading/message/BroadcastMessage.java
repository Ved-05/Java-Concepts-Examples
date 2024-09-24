package org.personal.multithreading.message;

import org.personal.multithreading.entities.AppUser;
import org.personal.multithreading.entities.AppUserGroup;
import org.personal.multithreading.exceptions.BroadcastMessageException;
import org.personal.multithreading.exceptions.InsufficientBalanceException;
import org.personal.multithreading.exceptions.MessageTransferException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * One to one message
 */
public class BroadcastMessage implements IMessage {
    private final String message;
    private final AppUser from;
    private final AppUserGroup to;
    private final Integer cost;

    /**
     * Constructor to create a message
     *
     * @param from    The sender
     * @param to      The receiver
     * @param message The message
     */
    public BroadcastMessage(AppUser from, AppUserGroup to, String message) {
        this.message = message;
        this.from = from;
        this.to = to;
        this.cost = 50;
    }

    public boolean send() {
        final List<AppUser> failedUsers = Collections.synchronizedList(new ArrayList<>());
        this.to.getUsers().parallelStream().forEach(user -> {
            try {
                this.from.getWallet().debit(cost);
                this.transferMessage();
            } catch (InsufficientBalanceException e) {
                System.err.printf("Failed to send message %s. Exception: %s \n", e.getMessage(), this);
                failedUsers.add(user);
            } catch (Exception e) {
                System.err.printf("Failed to send message %s. Exception: %s \n", e.getMessage(), this);
                this.from.getWallet().credit(cost);
            }
        });

        boolean status = failedUsers.isEmpty();

        if (!status)
            System.err.printf("Failed to send message to users: %s \n", Arrays.toString(failedUsers.toArray()));

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
        return "BroadcastMessage{" +
                "message='" + message + '\'' +
                ", from=" + from.getName() +
                ", to=" + to.getName() +
                '}';
    }
}
