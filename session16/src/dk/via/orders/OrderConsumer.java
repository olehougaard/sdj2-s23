package dk.via.orders;

import java.util.Queue;

public class OrderConsumer implements Runnable {
    private final Queue<Order> queue;

    public OrderConsumer(Queue<Order> queue) {
        this.queue = queue;
    }

    private void handle(Order order) {

    }

    public void run() {
        while(true) {
            Order order = queue.remove();
            handle(order);
        }
    }
}
