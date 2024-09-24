package org.personal.designpatterns.observer;

public class Consumer<T> implements Subscriber<T> {

    @Override
    public void consume(T value) {
        System.out.println(this.hashCode() + ":: Received message: " + value);
    }
}
