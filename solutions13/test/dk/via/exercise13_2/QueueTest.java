package dk.via.exercise13_2;

import dk.via.exercise13_2.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private Queue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    @Test
    void a_new_queue_is_empty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void a_new_queue_has_size_0() {
        assertEquals(0, queue.size());
    }

    @Test
    void removing_from_a_new_queue_is_not_allowed() {
        assertThrows(IllegalStateException.class, queue::remove);
    }

    @Test
    void peeking_on_a_new_queue_is_not_allowed() {
        assertThrows(IllegalStateException.class, queue::element);
    }

    @Test
    void adding_to_the_queue_makes_it_non_empty() {
        queue.add("Hello");
        assertFalse(queue.isEmpty());
    }

    @Test
    void adding_to_the_queue_makes_the_size_grow() {
        queue.add("Hello");
        assertEquals(1, queue.size());
    }

    @Test
    void peeking_on_a_queue_with_a_added_element_returns_that_element() {
        queue.add("Hello");
        assertEquals("Hello", queue.element());
    }

    @Test
    void removing_from_a_queue_with_a_added_element_returns_that_element() {
        queue.add("Hello");
        assertEquals("Hello", queue.remove());
    }

    @Test
    void removing_from_a_queue_with_a_added_element_leaves_it_with_size_0() {
        queue.add("Hello");
        queue.remove();
        assertEquals(0, queue.size());
    }

    @Test
    void peeking_on_a_queue_with_a_added_element_leaves_the_element() {
        queue.add("Hello");
        queue.element();
        assertEquals(1, queue.size());
    }

    @Test
    void removing_from_a_queue_with_a_added_element_leaves_it_empty() {
        queue.add("Hello");
        queue.remove();
        assertTrue(queue.isEmpty());
    }

    @Test
    void peeking_on_a_queue_with_two_added_elements_returns_the_last_element() {
        queue.add("Hello");
        queue.add("Goodbye");
        assertEquals("Goodbye", queue.element());
    }

    @Test
    void removing_twice_from_a_queue_with_two_added_elements_returns_the_elements_in_order() {
        queue.add("Hello");
        queue.add("Goodbye");
        assertEquals("Hello", queue.remove());
        assertEquals("Goodbye", queue.remove());
    }

    @Test
    void adding_nulls_is_not_allowed() {
        assertThrows(NullPointerException.class, () -> queue.add(null));
    }
}
