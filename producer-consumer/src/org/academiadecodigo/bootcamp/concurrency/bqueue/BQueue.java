package org.academiadecodigo.bootcamp.concurrency.bqueue;

import java.util.LinkedList;

/**
 * Blocking Queue
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {

    private final int limit;
    private final LinkedList<T> list;

    /**
     * Constructs a new queue with a maximum size
     * @param limit the queue size
     */
    public BQueue(int limit) {

        this.limit = limit;
        list = new LinkedList();
    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     * @param data the data to add to the queue
     */
    public synchronized void offer(T data) {

        while (list.size() >= limit) {
            try {
                System.out.println("The queue is full. The dish was added to the waiting line.");
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.addLast(data);
    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     * @return the data from the head of the queue
     */
    public synchronized T poll() {

        if (list.size() == limit) {
            System.out.println("The dishes in the waiting line were added to the queue.");
            notifyAll();
        }
        return list.poll();
    }

    /**
     * Gets the number of elements in the queue
     * @return the number of elements
     */
    public synchronized int getSize() {

        return list.size();
    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     * @return the maximum number of elements
     */
    public int getLimit() {

        return limit;
    }
}
