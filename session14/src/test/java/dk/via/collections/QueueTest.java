package dk.via.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueueTest {

    private Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    @Test
    void a_new_queue_has_size_0() {
        assertEquals(0, queue.size());
    }

    @Test
    void peeking_on_a_new_queue_fails() {
        assertThrows(IllegalStateException.class, () -> {
            queue.peek();
        });
    }

    @Test
    void leaving_from_a_new_queue_fails() {
        assertThrows(IllegalStateException.class, () -> {
            queue.leave();
        });
    }

    @Test
    void entering_something_to_the_queue_increases_the_size() {
        queue.enter(7);
        assertEquals(1, queue.size());
    }

    @Test
    void peeking_from_a_queue_of_size_1_returns_the_element() {
        queue.enter(7);
        assertEquals(7, queue.peek());
    }

    @Test
    void peeking_from_a_queue_with_2_elements_returns_the_first() {
        queue.enter(7);
        queue.enter(42);
        assertEquals(7, queue.peek());
    }
}
