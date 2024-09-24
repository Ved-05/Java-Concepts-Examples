package org.personal.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class Observer {

    public static void main( String[] args ) {
        Producer<String> producer = new Producer<>();
        List<Consumer<String>> consumers = new ArrayList<>();

        IntStream.range(0, 20).forEach(i -> {
            Consumer<String> consumer = new Consumer<>();
            producer.getNotifier().subscribe(consumer);
            consumers.add(consumer);
        });

        producer.produceAndNotify("Thanks for subscribing!");

        System.out.println("\n Unsubscribing 2 consumers \n");
        consumers
                .subList(0, 2)
                .forEach(consumer -> producer.getNotifier().unsubscribe(consumer));

        producer.produceAndNotify("Dropping video at 5 PM!");
    }

}
