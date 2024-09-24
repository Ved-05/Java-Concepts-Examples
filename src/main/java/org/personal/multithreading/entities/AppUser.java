package org.personal.multithreading.entities;

public class AppUser {
    private final String name;
    private final Wallet wallet;

    public AppUser(String name) {
        this.name = name;
        this.wallet = new Wallet();
    }

    public AppUser(String name, Wallet wallet) {
        this.name = name;
        this.wallet = new Wallet();
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return this.wallet;
    }
}
