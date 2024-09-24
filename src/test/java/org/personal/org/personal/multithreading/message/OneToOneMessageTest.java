package org.personal.org.personal.multithreading.message;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.personal.multithreading.entities.AppUser;
import org.personal.multithreading.message.IMessage;
import org.personal.multithreading.message.OneToOneMessage;

public class OneToOneMessageTest {

    AppUser fromAppUser, toAppUser;

    @BeforeEach
    public void setUp() {
        fromAppUser = new AppUser("sender");
        toAppUser = new AppUser("receiver");
    }

    @AfterEach
    public void tearDown() {
        fromAppUser = null;
        toAppUser = null;
    }

    @Test
    public void testOneToOneMessage_BestCase() {
        // Test the default constructor. The default balance should be 1000.
        assert fromAppUser.getWallet().getBalance() == 1000;
        // Send a message from one user to another.
        IMessage oneToOneMessage = new OneToOneMessage(fromAppUser, toAppUser, "Hello!");
        oneToOneMessage.send();
        // The balance should be reduced by 50.
        assert fromAppUser.getWallet().getBalance() == 950;
    }

    @Test
    public void testOneToOneMessage_InsufficientBalance() {
        // Test the default constructor. The default balance should be 1000.
        assert fromAppUser.getWallet().getBalance() == 1000;
        // Send a message from one user to another.
        IMessage oneToOneMessage = new OneToOneMessage(fromAppUser, toAppUser, "Hello!");
        for (int i = 0; i < 20; i++) {
            oneToOneMessage.send();
        }
        // The balance should be reduced to 0.
        assert fromAppUser.getWallet().getBalance() == 0;

        // Send a message from one user to another. The balance is still 0 i.e. message not send.
        oneToOneMessage.send();
        assert fromAppUser.getWallet().getBalance() == 0;
    }

}
