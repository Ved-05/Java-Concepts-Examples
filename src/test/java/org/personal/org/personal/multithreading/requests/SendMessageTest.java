package org.personal.org.personal.multithreading.requests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.personal.multithreading.entities.AppUser;
import org.personal.multithreading.message.IMessage;
import org.personal.multithreading.message.OneToOneMessage;
import org.personal.multithreading.requests.IRequest;
import org.personal.multithreading.requests.QueryBalance;
import org.personal.multithreading.requests.SendMessage;

class SendMessageTest {

    AppUser user;

    @BeforeEach
    public void setUp() {
        user = new AppUser("sender");
    }

    @AfterEach
    public void tearDown() {
        user = null;
    }

    @Test
    public void testQueryBalance() {
        // Test the default constructor. The default balance should be 1000.
        assert user.getWallet().getBalance() == 1000;

        // Send a message from one user to another.
        IMessage oneToOneMessage = new OneToOneMessage(user, user, "Hello!");
        oneToOneMessage.send();
        
        // The balance should be reduced by 50.
        assert user.getWallet().getBalance() == 950;
    }

}
