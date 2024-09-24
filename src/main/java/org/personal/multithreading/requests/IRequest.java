package org.personal.multithreading.requests;

/**
 * This interface represents a request.
 * It has a method to process the request and return the result of Type T.
 * @param <T> The type of the result of the request.
 */
public interface IRequest<T> {

    /**
     * This method processes the request and returns the result.
     * @return The result of the request.
     */
    T execute();
}
