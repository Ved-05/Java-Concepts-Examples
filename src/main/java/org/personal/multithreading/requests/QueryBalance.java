package org.personal.multithreading.requests;

import org.personal.multithreading.entities.AppUser;

/**
 * This class represents a request to send a message.
 */
public class QueryBalance implements IRequest<Integer> {

    private final AppUser user;

    public QueryBalance(AppUser user) {
        this.user = user;
    }

    @Override
    public Integer execute() {
        int balance = this.user.getWallet().getBalance();
        System.out.println("Balance for " + user.getName() + " is " + balance);
        return balance;
    }
}
