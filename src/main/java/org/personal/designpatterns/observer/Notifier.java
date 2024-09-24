package org.personal.designpatterns.observer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Notifier<T> {
    private final List<Subscriber<T>> clients;

    public Notifier() {
        clients = new LinkedList<>();
    }

    public void subscribe(Subscriber<T> client) {
        clients.add(client);
    }
    public void notifySubscribers(T message) {
        final Set<String> threadSet = new HashSet<>();
        clients.parallelStream().forEach(client -> {
            threadSet.add(Thread.currentThread().getName());
            client.consume(message);
        });
        System.out.println("Threads used: " + threadSet + " to notify " + clients.size() + " subscribers.");
    }

    public void unsubscribe(Subscriber<T> consumer) {
        clients.remove(consumer);
    }
}
