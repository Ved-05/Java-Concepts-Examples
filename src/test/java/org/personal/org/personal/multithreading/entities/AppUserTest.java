package org.personal.org.personal.multithreading.entities;

import org.junit.jupiter.api.Test;
import org.personal.multithreading.entities.AppUser;

public class AppUserTest {
    @Test
    public void testAppUser() {
        // Test the default constructor. The default balance should be 1000.
        AppUser appUser = new AppUser("test");
        assert appUser.getName().equals("test");
        assert appUser.getWallet().getBalance() == 1000;
    }

}
