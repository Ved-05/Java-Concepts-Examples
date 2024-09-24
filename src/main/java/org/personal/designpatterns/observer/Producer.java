package org.personal.designpatterns.observer;

public class Producer <T> {
    private final Notifier<T> notifier;

    public Producer() {
        this.notifier = new Notifier<>();
    }

    public void produceAndNotify(T message) {
        System.out.println("Producing value: " + message);
        notifier.notifySubscribers(message);
    }

    public Notifier<T> getNotifier() {
        return this.notifier;
    }
}
