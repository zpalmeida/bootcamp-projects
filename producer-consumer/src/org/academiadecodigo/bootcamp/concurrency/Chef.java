package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Produces and stores integers into a blocking queue
 */
public class Chef implements Runnable {

    private final BQueue<Integer> queue;
    private int dishNum;

    /**
     * @param queue the blocking queue to add elements to
     * @param dishNum the number of elements to produce
     */
    public Chef(BQueue queue, int dishNum) {
        this.queue = queue;
        this.dishNum = dishNum;
    }

    private int dish() {

        int random = (int) (Math.random() * 5);
        String dish = new String();

        try {
            switch (random) {
                case 0:
                    dish = "braised octopus risotto with capers and chilli pangrattato";
                    Thread.sleep((long) (2000 + Math.random() * 2000));
                    break;

                case 1:
                    dish = "roasted pork loin filled with fennel, rosemary, garlic and bay";
                    Thread.sleep((long) (3000 + Math.random() * 2000));
                    break;

                case 2:
                    dish = "slow roasted lamb shoulder rolled with truffle butter, pecorino and mint";
                    Thread.sleep((long) (5000 + Math.random() * 2000));
                    break;

                case 3:
                    dish = "roasted free range chicken in honey and spices";
                    Thread.sleep((long) (4000 + Math.random() * 2000));
                    break;

                case 4:
                default:
                    dish = "baked seabass in a citrus and fennel rock salt crust";
                    Thread.sleep((long) (1000 + Math.random() * 2000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("A dish of " + dish + " is plated and ready to serve.");
        return random;
    }

    @Override
    public void run() {

        while (dishNum > 0) {

            queue.offer(dish());
            dishNum--;
        }
    }
}
