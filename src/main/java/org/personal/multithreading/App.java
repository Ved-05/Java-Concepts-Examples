package org.personal.multithreading;

import org.personal.multithreading.entities.AppUser;
import org.personal.multithreading.message.OneToOneMessage;
import org.personal.multithreading.requests.IRequest;
import org.personal.multithreading.requests.QueryBalance;
import org.personal.multithreading.requests.SendMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The main class to run the application.
 */
public class App {
    public static void main(String[] args) {
        // Create a list of users.
        List<AppUser> appUsers = populateUsers();

        // Generate requests for the users.
        List<IRequest> requests = getRequests(appUsers);

        // Execute the requests using executor service of fixed size 4.
        executeRequests(requests);
    }

    /**
     * Executes the requests in parallel.
     *
     * @param requests The list of requests.
     */
    private static void executeRequests(List<IRequest> requests) {
        requests.parallelStream().forEach(IRequest::execute);
    }

    /**
     * Generates requests for the users.
     *
     * @param appUsers The list of users.
     * @return The list of requests.
     */
    private static List<IRequest> getRequests(List<AppUser> appUsers) {
        // generate sample requests for the users without random
        int appUsersSize = appUsers.size();
        List<IRequest> requests = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            int index = random.nextInt(2);
            switch (index) {
                case 0:
                    requests.add(new SendMessage(new OneToOneMessage(appUsers.get(0),
                            appUsers.get(random.nextInt(appUsersSize)), "Hello!")));
                    break;
                case 1:
                    requests.add(new QueryBalance(appUsers.get(0)));
                    break;
            }
        }
        return requests;
    }

    /**
     * Populates the list of users.
     *
     * @return The list of users.
     */
    private static List<AppUser> populateUsers() {
        // Create a list of random users.
        return List.of(
                new AppUser("Alice"),
                new AppUser("Bob"),
                new AppUser("Charlie"),
                new AppUser("David"),
                new AppUser("Eve")
        );
    }
}
