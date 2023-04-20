package dk.via.shopping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingListTest {

    private ShoppingList shoppingList;

    @BeforeEach
    void setUp() {
        shoppingList = new ShoppingList();
    }

    @Test
    void new_shopping_list_is_empty() {
        assertEquals(0, shoppingList.size());
    }

    @Test
    void new_shopping_list_has_no_cost() {
        assertEquals(0.0, shoppingList.totalCost());
    }

    @Test
    void adding_item_to_shopping_list_increases_size() {
        shoppingList.addItem("Carrots", 10, .5);
        assertEquals(1, shoppingList.size());
    }

    @Test
    void adding_item_to_shopping_list_adds_item_name_in_index_0() {
        shoppingList.addItem("Carrots", 10, .5);
        assertEquals("Carrots", shoppingList.getItemName(0));
    }

    @Test
    void adding_item_to_shopping_list_adds_amount_in_index_0() {
        shoppingList.addItem("Carrots", 10, .5);
        assertEquals(10, shoppingList.getItemAmount(0));
    }

    @Test
    void adding_item_to_shopping_list_adds_cost() {
        shoppingList.addItem("Carrots", 10, .5);
        assertEquals(5, shoppingList.totalCost());
    }

    @Test
    void adding_two_items_to_shopping_list_adds_the_item_names_in_index_0_and_1() {
        shoppingList.addItem("Carrots", 10, .5);
        shoppingList.addItem("Bananas", 5, 2);
        assertEquals("Carrots", shoppingList.getItemName(0));
        assertEquals("Bananas", shoppingList.getItemName(1));
    }

    @Test
    void adding_two_items_to_shopping_list_adds_the_amounts_in_index_0_and_1() {
        shoppingList.addItem("Carrots", 10, .5);
        shoppingList.addItem("Bananas", 5, 2);
        assertEquals(10, shoppingList.getItemAmount(0));
        assertEquals(5, shoppingList.getItemAmount(1));
    }

    @Test
    void adding_two_items_to_shopping_list_adds_both_to_total_cost() {
        shoppingList.addItem("Carrots", 10, .5);
        shoppingList.addItem("Bananas", 5, 2);
        assertEquals(15, shoppingList.totalCost());
    }

    @Test
    void zero_amount_has_no_effect() {
        shoppingList.addItem("Carrots", 0, .5);
        assertEquals(0, shoppingList.size());
    }

    @Test
    void negative_amount_is_not_allowed() {
        assertThrows(IllegalArgumentException.class, () -> shoppingList.addItem("Carrots", -1, .5));
    }

    @Test
    void negative_price_is_not_allowed() {
        assertThrows(IllegalArgumentException.class, () -> shoppingList.addItem("Carrots", 10, -.5));
    }
}
