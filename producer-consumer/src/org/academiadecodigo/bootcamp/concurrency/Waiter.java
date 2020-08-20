package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Consumer of integers from a blocking queue
 */
public class Waiter implements Runnable {

    private final BQueue<Integer> queue;
    private int dishNum;

    /**
     * @param queue the blocking queue to consume elements from
     * @param dishNum the number of elements to consume
     */
    public Waiter(BQueue queue, int dishNum) {
        this.queue = queue;
        this.dishNum = dishNum;
    }

    @Override
    public void run() {

        while (dishNum > 0) {

            try {
                Thread.sleep((long) (2000 + Math.random() * 13000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (queue.getSize() <= 0) {
                System.out.println("The queue is empty.");
                continue;
            }

            System.out.println("A dish was fetched by a waiter.");
            queue.poll();
            dishNum--;
        }
    }
}
