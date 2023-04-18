package dk.via.exercise13_4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TodoListTest {
    private TodoList todoList;

    @BeforeEach
    void setUp() {
        todoList = new TodoList();
    }

    // Given a new to-do-list, it should be all done
    @Test
    void new_list_is_all_done() {
        assertTrue(todoList.isAllDone());
    }
    // Given a new to-do-list, it should have no unfinished to-dos
    @Test
    void new_list_has_no_unfinished_todos() {
        assertEquals(0, todoList.unfinishedCount());
    }
    // Given a new to-do-list, it should have no finished to-dos
    @Test
    void new_list_has_no_finished_todos() {
        assertEquals(0, todoList.finishedCount());
    }

    // Given a new to-do-list, it should be empty
    @Test
    void new_list_is_empty() {
        assertTrue(todoList.isEmpty());
    }

    // Given a new to-do-list, when adding one item, it should not be "all done"
    @Test
    void add_one_item_makes_list_not_done() {
        todoList.add("Do this");
        assertFalse(todoList.isAllDone());
    }

    // Given a new to-do-list, when adding one item, it should not be empty
    @Test
    void add_one_item_makes_list_nonempty() {
        todoList.add("Do this");
        assertFalse(todoList.isEmpty());
    }

    // Given a new to-do-list, when adding one item, it should have 1 unfinished to-do
    @Test
    void adding_one_item_adds_one_unfinished() {
        todoList.add("Do this");
        assertEquals(1, todoList.unfinishedCount());
    }

    // Given a new to-do-list, when adding one item, it should have 0 unfinished to-do
    @Test
    void adding_one_item_doesnt_add_finished() {
        todoList.add("Do this");
        assertEquals(0, todoList.finishedCount());
    }

    // Given a new to-do-list, when adding one item,
    // it should have the item as the unfinished item in index 0
    @Test
    void first_added_item_shows_in_unfinished_index_0() {
        todoList.add("Do this");
        assertEquals("Do this", todoList.getUnfinished(0));
    }

    // Given a new to-do-list, when adding two items, it should have 2 unfinished to-dos
    @Test
    void adding_two_item_adds_two_unfinished() {
        todoList.add("Do this");
        todoList.add("Do that");
        assertEquals(2, todoList.unfinishedCount());
    }

    // Given a new to-do-list, when adding two items,
    // it should have the first item as the unfinished item in index 0
    void first_added_item_remains_in_unfinished_index_0() {
        todoList.add("Do this");
        todoList.add("Do that");
        assertEquals("Do this", todoList.getUnfinished(0));
    }

    // Given a new to-do-list, when adding two items,
    // it should have the second item as the unfinished item in index 1
    void second_added_item_shows_in_unfinished_index_1() {
        todoList.add("Do this");
        todoList.add("Do that");
        assertEquals("Do that", todoList.getUnfinished(1));
    }

    // Finish to-do on singleton to-do-list makes list "all done"
    // Given a to-do list with one unfinished element,
    // when finishing the element,
    // it should be "all done"
    @Test
    void finishing_an_item_on_a_singleton_leaves_it_all_done() {
        todoList.add("Do this");
        todoList.finish(0);
        assertTrue(todoList.isAllDone());
    }

    // Given a to-do list with one unfinished element,
    // when finishing the element,
    // it should have 0 unfinished elements
    @Test
    void finishing_an_item_on_a_singleton_leaves_no_unfinished_items() {
        todoList.add("Do this");
        todoList.finish(0);
        assertEquals(0, todoList.unfinishedCount());
    }

    // Given a to-do list with one unfinished and no finished elements,
    // when finishing the element,
    // it should have 1 finished elements
    @Test
    void finishing_an_item_on_a_singleton_makes_unfinished_count_one() {
        todoList.add("Do this");
        todoList.finish(0);
        assertEquals(1, todoList.finishedCount());
    }

    // Finished to-do is added to finished list
    // Given a to-do list with one unfinished and no finished elements,
    // when finishing the element,
    // it should have the finished element in index 0
    @Test
    void finishing_an_item_on_a_singleton_adds_one_unfinished_item() {
        todoList.add("Do this");
        todoList.finish(0);
        assertEquals("Do this", todoList.getFinished(0));
    }

    // Given a to-do list with two unfinished and no finished elements
    // When finishing both elements
    // It should have the first finished element in index 0 and the second in index 1
    @Test
    void finished_todos_are_added_in_finishing_order() {
        todoList.add("Do this");
        todoList.add("Do that");
        todoList.finish(1);
        todoList.finish(0);
        assertEquals("Do that", todoList.getFinished(0));
        assertEquals("Do this", todoList.getFinished(1));
    }

    // Finish to-do on singleton list does not make list empty
    // Given a to-do list with one unfinished element
    // When the element is finished
    // It should not be empty
    @Test
    void finishing_todos_dont_empty_list() {
        todoList.add("Do this");
        todoList.finish(0);
        assertFalse(todoList.isEmpty());
    }

    /* Given a new to-do-list,
     * when getting unfinished index 0,
     * it should throw an exception
     */
    @Test
    void reading_past_end_of_unfinished_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            todoList.getUnfinished(0);
        });
    }

    /* Given any to-do-list,
     * when getting unfinished index -1,
     * it should throw an exception
     */
    @Test
    void reading_before_beginning_of_unfinished_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            todoList.getUnfinished(-1);
        });
    }

    /* Given a new to-do-list,
     * when getting finished index 0,
     * it should throw an exception
     */
    @Test
    void reading_past_end_of_finished_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            todoList.getFinished(0);
        });
    }

    /* Given any to-do-list,
     * when getting finished index -1,
     * it should throw an exception
     */
    @Test
    void reading_before_beginning_of_finished_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            todoList.getFinished(-1);
        });
    }


    /* Given a new to-do-list,
     * when finishing index 0,
     * it should throw an exception
     */
    @Test
    void finishing_past_end_of_unfinished_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            todoList.finish(0);
        });
    }

    /* Given any to-do-list,
     * when finishing index -1,
     * it should throw an exception
     */
    @Test
    void finishing_before_beginning_of_unfinished_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            todoList.finish(-1);
        });
    }
}