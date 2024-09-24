package org.personal.org.personal.multithreading.message;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.personal.multithreading.entities.AppUser;
import org.personal.multithreading.entities.AppUserGroup;
import org.personal.multithreading.message.BroadcastMessage;
import org.personal.multithreading.message.IMessage;
import org.personal.multithreading.message.OneToOneMessage;

public class BroadcastTest {

    AppUser fromAppUser;
    AppUserGroup toAppUserGroup;

    @BeforeEach
    public void setUp() {
        fromAppUser = new AppUser("sender");
        toAppUserGroup = new AppUserGroup("receivers");
    }

    @AfterEach
    public void tearDown() {
        fromAppUser = null;
        toAppUserGroup = null;
    }

    @Test
    public void testOneToOneMessage_BestCase() {
        // Test the default constructor. The default balance should be 1000.
        assert fromAppUser.getWallet().getBalance() == 1000;
        // Send a message from one user to another.
        for (int i = 0; i < 10; i++) {
            toAppUserGroup.addUser(new AppUser("receiver" + (i + 1)));
        }
        IMessage broadcastMessage = new BroadcastMessage(fromAppUser, toAppUserGroup, "Hello!");
        broadcastMessage.send();
        // The balance should be reduced by 500.
        assert fromAppUser.getWallet().getBalance() == 500;
    }

    @Test
    public void testOneToOneMessage_InsufficientBalance() {
        // Test the default constructor. The default balance should be 1000.
        assert fromAppUser.getWallet().getBalance() == 1000;
        // Send a message from one user to another.
        for (int i = 0; i < 50; i++) {
            toAppUserGroup.addUser(new AppUser("receiver" + (i + 1)));
        }
        IMessage broadcastMessage = new BroadcastMessage(fromAppUser, toAppUserGroup, "Hello!");
        broadcastMessage.send();
        // The balance should be reduced by 500.
        assert fromAppUser.getWallet().getBalance() == 0;
    }

}
