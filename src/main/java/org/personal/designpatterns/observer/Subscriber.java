package org.personal.designpatterns.observer;

public interface Subscriber<T> {
    void consume(T value);
}
