package dk.via.orders;

import java.util.Queue;

public class OrderProducer implements Runnable {
    private final Queue<Order> queue;

    public OrderProducer(Queue<Order> queue) {
        this.queue = queue;
    }

    private Order createOrder() {
        return null;
    }

    @Override
    public void run() {
        while(true) {
            Order order = createOrder();
            queue.offer(order);
        }
    }
}
