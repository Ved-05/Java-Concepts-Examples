package org.personal.multithreading.entities;

import org.personal.multithreading.exceptions.InsufficientBalanceException;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a wallet.
 */
public class Wallet {
    private AtomicInteger balance;

    public Wallet() {
        this.balance = new AtomicInteger(1000);
    }

    public Wallet(int balance) {
        this.balance = new AtomicInteger(balance);
    }

    /**
     * Gets the balance of the wallet.
     *
     * @return The balance of the wallet.
     */
    public int getBalance() {
        return balance.get();
    }

    /**
     * Debits the wallet.
     *
     * @param amount The amount to debit.
     */
    public void debit(int amount) throws InsufficientBalanceException {
        int currentBalance = balance.get();
        if (currentBalance < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance.getAndSet(currentBalance - amount);
    }

    /**
     * Credits the wallet.
     *
     * @param amount The amount to credit.
     */
    public void credit(int amount) {
        balance.getAndSet(balance.get() + amount);
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "balance=" + balance.get() +
                '}';
    }
}
