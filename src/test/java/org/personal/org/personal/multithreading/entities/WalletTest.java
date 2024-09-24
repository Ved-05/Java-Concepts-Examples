package org.personal.org.personal.multithreading.entities;

import org.junit.jupiter.api.Test;
import org.personal.multithreading.entities.Wallet;

public class WalletTest {
    @Test
    public void testWalletCreation() {
        // Test the default constructor. The default balance should be 1000.
        Wallet wallet = new Wallet();
        assert wallet.getBalance() == 1000;

        // Test the constructor with balance. The balance should be 10.
        wallet = new Wallet(10);
        assert wallet.getBalance() == 10;
    }

}
